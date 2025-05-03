package com.rentacar.database.jdbc;

import com.rentacar.util.LogUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;

/**
 * Helper class to manage database connection using H2
 */
public class DatabaseConnection {
    private static final String URL = "jdbc:h2:mem:rentACarDB";
    private static final String USERNAME = "sa";
    // Generate a random password at runtime for better security
    private static final String PASSWORD = UUID.randomUUID().toString().replace("-", "").substring(0, 20);
    private static Connection connection = null;

    /**
     * Gets the database connection instance
     * @return connection object
     */
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                LogUtils.info("Database connection established successfully");
            }
        } catch (SQLException e) {
            LogUtils.error("Failed to establish database connection", e);
        }
        return connection;
    }

    /**
     * Closes the database connection
     */
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                LogUtils.info("Database connection closed successfully");
            }
        } catch (SQLException e) {
            LogUtils.error("Error closing database connection", e);
        }
    }
    
    private DatabaseConnection() {
        // Utility class, should not be instantiated
    }
} 