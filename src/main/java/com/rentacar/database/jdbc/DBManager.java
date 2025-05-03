package com.rentacar.database.jdbc;

import com.rentacar.util.LogUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * Helper class for managing database operations with direct JDBC
 * Note: This class is currently designed as a utility class for future use.
 * It will be fully utilized when additional database operations are implemented.
 */
@SuppressWarnings({"unused", "SqlNoDataSourceInspection", "SqlDialectInspection"})
public class DBManager {
    // SQL injection prevention validation pattern - only allow basic SQL keywords and operators
    private static final Pattern SQL_VALIDATION_PATTERN = 
            Pattern.compile("^[\\sA-Za-z0-9_,*()=<>!.?'+\\-:;]*$");
    
    // Block potentially dangerous SQL commands
    private static final Pattern SQL_DANGER_PATTERN =
            Pattern.compile("(?i).*(drop|truncate|delete|alter|exec|execute|union|insert|update).*");
    
    private static Connection connection;
    
    /**
     * Ensures database connection is active and ready
     * @return true if connection is active and ready for use
     */
    public static boolean ensureConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DatabaseConnection.getConnection();
            }
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            LogUtils.error("Failed to ensure database connection", e);
            return false;
        }
    }
    
    /**
     * Prepares connection for the given operation
     * @param operationType Type of operation being performed (for logging)
     * @return true if connection is ready, false if connection failed
     */
    private static boolean prepareConnection(String operationType) {
        boolean connectionReady = ensureConnection();
        if (!connectionReady) {
            LogUtils.error("Could not ensure database connection for " + operationType);
        }
        return connectionReady;
    }
    
    /**
     * Validates SQL statement for basic security
     * This is an additional layer of protection, not a replacement for prepared statements
     * @param sql SQL statement to validate
     * @return true if SQL statement seems safe
     */
    private static boolean isSqlValid(String sql) {
        if (sql == null || sql.trim().isEmpty()) {
            LogUtils.error("SQL statement is empty or null");
            return false;
        }
        
        // Check for dangerous SQL operations
        // This is a second layer of protection - we still use prepared statements
        boolean hasDangerousCommands = false;
        if (SQL_DANGER_PATTERN.matcher(sql).matches()) {
            hasDangerousCommands = true;
            LogUtils.error("SQL statement contains potentially unsafe commands: " + sql);
        }
        
        boolean matchesValidPattern = SQL_VALIDATION_PATTERN.matcher(sql).matches();
        if (!matchesValidPattern) {
            LogUtils.error("SQL statement contains potentially unsafe characters: " + sql);
        }
        
        return !hasDangerousCommands && matchesValidPattern;
    }
    
    /**
     * Sanitizes SQL for logging purposes only
     * @param sql Original SQL statement
     * @return Sanitized version safe for logging
     */
    private static String sanitizeSqlForLogging(String sql) {
        if (sql == null) return "";
        return sql.replaceAll("\\s+", " ").trim();
    }
    
    /**
     * Closes database connection
     */
    public static void closeConnection() {
        DatabaseConnection.closeConnection();
    }
    
    /**
     * Executes query and returns results as a list
     * Use prepared statements with parameterized queries to prevent SQL injection
     * 
     * @param sqlQuery SQL query with ? placeholders for parameters (MUST be parameterized to prevent SQL injection)
     * @param params Query parameters
     * @return List converted from ResultSet
     */
    public static List<Map<String, Object>> executeQuery(String sqlQuery, Object... params) {
        final String safeSqlForLogging = sanitizeSqlForLogging(sqlQuery);
        
        // Validate SQL format as additional security measure
        if (!isSqlValid(sqlQuery)) {
            LogUtils.error("Invalid SQL detected in query: " + safeSqlForLogging);
            return Collections.emptyList();
        }
        
        // Connection check with early return
        boolean connectionReady = prepareConnection("query");
        if (!connectionReady) {
            return Collections.emptyList();
        }
        
        List<Map<String, Object>> resultList = Collections.emptyList();
        
        try (PreparedStatement stmt = connection.prepareStatement(sqlQuery)) {
            bindParameters(stmt, params);
            
            try (ResultSet rs = stmt.executeQuery()) {
                resultList = convertResultSetToList(rs);
            }
            
            LogUtils.logDatabase("QUERY", safeSqlForLogging);
        } catch (SQLException e) {
            LogUtils.error("Error executing query: " + safeSqlForLogging, e);
        }
        
        return resultList;
    }
    
    /**
     * Converts a ResultSet to a List of Maps
     */
    private static List<Map<String, Object>> convertResultSetToList(ResultSet rs) throws SQLException {
        List<Map<String, Object>> resultList = new ArrayList<>();
        int columnCount = rs.getMetaData().getColumnCount();
        
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            
            for (int i = 1; i <= columnCount; i++) {
                String columnName = rs.getMetaData().getColumnName(i);
                Object value = rs.getObject(i);
                row.put(columnName, value);
            }
            
            resultList.add(row);
        }
        
        return resultList;
    }
    
    /**
     * Binds parameters to a PreparedStatement
     */
    private static void bindParameters(PreparedStatement stmt, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            stmt.setObject(i + 1, params[i]);
        }
    }
    
    /**
     * Executes update (INSERT, UPDATE, DELETE) query
     * Use prepared statements with parameterized queries to prevent SQL injection
     * 
     * @param sqlUpdate SQL query with ? placeholders for parameters (MUST be parameterized to prevent SQL injection)
     * @param params Query parameters
     * @return Number of affected rows, -1 in case of error
     */
    public static int executeUpdate(String sqlUpdate, Object... params) {
        final String safeSqlForLogging = sanitizeSqlForLogging(sqlUpdate);
        
        // Validate SQL format as additional security measure
        if (!isSqlValid(sqlUpdate)) {
            LogUtils.error("Invalid SQL detected in update: " + safeSqlForLogging);
            return -1;
        }
        
        // Connection check with early return
        boolean connectionReady = prepareConnection("update");
        if (!connectionReady) {
            return -1;
        }
        
        try (PreparedStatement stmt = connection.prepareStatement(sqlUpdate)) {
            bindParameters(stmt, params);
            
            int result = stmt.executeUpdate();
            LogUtils.logDatabase("UPDATE", safeSqlForLogging);
            return result;
        } catch (SQLException e) {
            LogUtils.error("Error executing update query: " + safeSqlForLogging, e);
            return -1;
        }
    }
    
    /**
     * Executes insert query and returns generated ID
     * Use prepared statements with parameterized queries to prevent SQL injection
     * 
     * @param sqlInsert SQL query with ? placeholders for parameters (MUST be parameterized to prevent SQL injection)
     * @param params Query parameters
     * @return Generated ID, -1 in case of error
     */
    public static long executeInsert(String sqlInsert, Object... params) {
        final String safeSqlForLogging = sanitizeSqlForLogging(sqlInsert);
        
        // Validate SQL format as additional security measure
        if (!isSqlValid(sqlInsert)) {
            LogUtils.error("Invalid SQL detected in insert: " + safeSqlForLogging);
            return -1;
        }
        
        // Connection check with early return
        boolean connectionReady = prepareConnection("insert");
        if (!connectionReady) {
            return -1;
        }
        
        try (PreparedStatement stmt = connection.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS)) {
            bindParameters(stmt, params);
            
            int affectedRows = stmt.executeUpdate();
            
            if (affectedRows == 0) {
                LogUtils.warning("Insert statement did not generate any rows");
                return -1;
            }
            
            return getGeneratedId(stmt, safeSqlForLogging);
        } catch (SQLException e) {
            LogUtils.error("Error executing insert query: " + safeSqlForLogging, e);
            return -1;
        }
    }
    
    /**
     * Gets the generated ID from a statement after insert
     */
    private static long getGeneratedId(Statement stmt, String safeSql) throws SQLException {
        try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                long id = generatedKeys.getLong(1);
                LogUtils.logDatabase("INSERT", safeSql + " (ID: " + id + ")");
                return id;
            } else {
                LogUtils.warning("Insert did not generate any keys");
                return -1;
            }
        }
    }
    
    /**
     * Executes batch operation (transaction)
     * Use prepared statements with parameterized queries to prevent SQL injection
     * 
     * @param sqlStatements List of SQL queries with ? placeholders for parameters (MUST be parameterized to prevent SQL injection)
     * @param paramsList List of parameters for each query
     * @return true if successful
     */
    public static boolean executeTransaction(List<String> sqlStatements, List<Object[]> paramsList) {
        // Validate input parameters
        if (sqlStatements.size() != paramsList.size()) {
            LogUtils.error("SQL and parameter list sizes do not match");
            return false;
        }
        
        // Validate all SQL statements
        for (String sql : sqlStatements) {
            if (!isSqlValid(sql)) {
                LogUtils.error("Invalid SQL detected in transaction: " + sanitizeSqlForLogging(sql));
                return false;
            }
        }
        
        // Connection check with early return
        boolean connectionReady = prepareConnection("transaction");
        if (!connectionReady) {
            return false;
        }
        
        boolean originalAutoCommit = true;
        boolean success = false;
        
        try {
            // Setup transaction
            originalAutoCommit = connection.getAutoCommit();
            connection.setAutoCommit(false);
            
            // Execute all statements
            executeTransactionStatements(sqlStatements, paramsList);
            
            // Commit changes
            connection.commit();
            LogUtils.logDatabase("TRANSACTION", "Batch operation completed successfully");
            success = true;
        } catch (SQLException e) {
            performRollback();
            LogUtils.error("Error during transaction", e);
        } finally {
            restoreAutoCommit(originalAutoCommit);
        }
        
        return success;
    }
    
    /**
     * Executes all statements in a transaction
     */
    private static void executeTransactionStatements(List<String> sqlStatements, List<Object[]> paramsList) 
            throws SQLException {
        for (int i = 0; i < sqlStatements.size(); i++) {
            String sql = sqlStatements.get(i);
            Object[] params = paramsList.get(i);
            final String safeSqlForLogging = sanitizeSqlForLogging(sql);
            
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                bindParameters(stmt, params);
                stmt.executeUpdate();
                LogUtils.logDatabase("TRANSACTION_STEP", safeSqlForLogging);
            }
        }
    }
    
    /**
     * Performs rollback in case of transaction error
     */
    private static void performRollback() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.rollback();
            }
        } catch (SQLException ex) {
            LogUtils.error("Error during rollback", ex);
        }
    }
    
    /**
     * Restores original auto-commit state
     */
    private static void restoreAutoCommit(boolean originalAutoCommit) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.setAutoCommit(originalAutoCommit);
            }
        } catch (SQLException e) {
            LogUtils.error("Error restoring auto-commit state", e);
        }
    }
    
    /**
     * Checks if database connection is active
     * @return true if connection is active
     */
    public static boolean isConnectionActive() {
        try {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            LogUtils.error("Error checking connection status", e);
            return false;
        }
    }
    
    private DBManager() {
        // Utility class, should not be instantiated
    }
} 