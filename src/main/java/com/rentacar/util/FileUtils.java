package com.rentacar.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Helper class for file operations
 */
public class FileUtils {
    
    private static final String CONFIG_FILE = "config.properties";
    private static final String EXPORT_DIR = "exports";
    
    /**
     * Reads a file and returns its content as String
     * @param filePath file path
     * @return file content
     * @throws IOException if file cannot be read
     */
    public static String readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.readString(path);
    }
    
    /**
     * Writes content to a file
     * @param filePath file path
     * @param content content to write
     * @throws IOException if file cannot be written
     */
    public static void writeFile(String filePath, String content) throws IOException {
        Path path = Paths.get(filePath);
        Files.writeString(path, content);
    }
    
    /**
     * Checks if directory exists, creates it if not
     * @param dirPath directory path
     * @return true if directory is successfully created
     */
    public static boolean createDirectoryIfNotExists(String dirPath) {
        File dir = new File(dirPath);
        if (!dir.exists()) {
            return dir.mkdirs();
        }
        return true;
    }
    
    /**
     * Exports data in CSV format
     * @param fileName file name
     * @param data data to export
     * @return path of created file
     * @throws IOException if file cannot be created
     */
    public static String exportToCSV(String fileName, String[][] data) throws IOException {
        createDirectoryIfNotExists(EXPORT_DIR);
        String filePath = EXPORT_DIR + "/" + fileName + ".csv";
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (String[] row : data) {
                StringBuilder line = new StringBuilder();
                for (int i = 0; i < row.length; i++) {
                    if (row[i].contains(",") || row[i].contains("\"") || row[i].contains("\n")) {
                        line.append("\"").append(row[i].replace("\"", "\"\"")).append("\"");
                    } else {
                        line.append(row[i]);
                    }
                    
                    if (i < row.length - 1) {
                        line.append(",");
                    }
                }
                writer.println(line.toString());
            }
        }
        
        return filePath;
    }
    
    /**
     * Loads configuration from properties file
     * @return Properties object
     * @throws IOException if file cannot be read
     */
    public static Properties loadConfig() throws IOException {
        Properties props = new Properties();
        
        File configFile = new File(CONFIG_FILE);
        if (configFile.exists()) {
            try (FileInputStream fis = new FileInputStream(configFile)) {
                props.load(fis);
            }
        }
        
        return props;
    }
    
    /**
     * Saves configuration to properties file
     * @param props Properties object to save
     * @throws IOException if file cannot be written
     */
    public static void saveConfig(Properties props) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(CONFIG_FILE)) {
            props.store(fos, "RentACar Application Configuration");
        }
    }
    
    /**
     * Returns file extension
     * @param fileName file name
     * @return file extension
     */
    public static String getFileExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex > 0) {
            return fileName.substring(lastDotIndex + 1);
        }
        return "";
    }
    
    /**
     * Checks if file exists
     * @param filePath file path
     * @return true if file exists
     */
    public static boolean fileExists(String filePath) {
        File file = new File(filePath);
        return file.exists() && file.isFile();
    }
    
    private FileUtils() {
        // Utility class, should not be instantiated
    }
} 