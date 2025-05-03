package com.rentacar.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Helper class for logging operations
 */
public class LogUtils {
    
    private static final Logger LOGGER = Logger.getLogger("RentACarLogger");
    private static final String LOG_DIR = "logs";
    private static final ThreadLocal<SimpleDateFormat> DATE_FORMAT = 
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));
    private static final ThreadLocal<SimpleDateFormat> TIME_FORMAT = 
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    
    static {
        try {
            File logDir = new File(LOG_DIR);
            if (!logDir.exists() && !logDir.mkdir()) {
                System.err.println("Failed to create log directory");
            }
            
            String logFileName = LOG_DIR + "/rental_" + DATE_FORMAT.get().format(new Date()) + ".log";
            FileHandler fileHandler = new FileHandler(logFileName, true);
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
            LOGGER.setLevel(Level.ALL);
        } catch (IOException e) {
            System.err.println("Could not create log file: " + e.getMessage());
        }
    }
    
    /**
     * Creates an info level log entry
     * @param message log message
     */
    public static void info(String message) {
        LOGGER.info(message);
        writeToFile("INFO", message);
    }
    
    /**
     * Creates a warning level log entry
     * @param message log message
     */
    public static void warning(String message) {
        LOGGER.warning(message);
        writeToFile("WARNING", message);
    }
    
    /**
     * Creates an error level log entry
     * @param message log message
     */
    public static void error(String message) {
        LOGGER.severe(message);
        writeToFile("ERROR", message);
    }
    
    /**
     * Creates an error level log entry with exception
     * @param message log message
     * @param e exception
     */
    public static void error(String message, Exception e) {
        LOGGER.log(Level.SEVERE, message, e);
        writeToFile("ERROR", message + " - " + e.getMessage());
    }
    
    /**
     * Creates a log entry for database operations
     * @param operation operation type
     * @param details operation details
     */
    public static void logDatabase(String operation, String details) {
        String message = "DATABASE (" + operation + "): " + details;
        LOGGER.info(message);
        writeToFile("DATABASE", message);
    }
    
    /**
     * Creates a log entry for user actions
     * @param username username
     * @param action performed action
     */
    public static void logUserAction(String username, String action) {
        String message = "USER (" + username + "): " + action;
        LOGGER.info(message);
        writeToFile("USER", message);
    }
    
    private static void writeToFile(String level, String message) {
        try {
            File logDir = new File(LOG_DIR);
            if (!logDir.exists() && !logDir.mkdir()) {
                System.err.println("Failed to create log directory");
                return;
            }
            
            String logFileName = LOG_DIR + "/rental_" + DATE_FORMAT.get().format(new Date()) + ".log";
            try (PrintWriter writer = new PrintWriter(new FileWriter(logFileName, true))) {
                writer.println(TIME_FORMAT.get().format(new Date()) + " [" + level + "] " + message);
            }
        } catch (IOException e) {
            System.err.println("Could not write to log file: " + e.getMessage());
        }
    }
    
    private LogUtils() {
        // Utility class, should not be instantiated
    }
} 