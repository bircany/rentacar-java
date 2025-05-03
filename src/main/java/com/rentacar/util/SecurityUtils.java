package com.rentacar.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * Helper class for security operations
 */
public class SecurityUtils {
    
    private static final SecureRandom RANDOM = new SecureRandom();
    
    /**
     * Hashes text with SHA-256 algorithm
     * @param text text to hash
     * @return hash value or empty string if algorithm not found
     */
    public static String hashSHA256(String text) {
        if (text == null) {
            return "";
        }
        
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(text.getBytes());
            
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            LogUtils.error("SHA-256 algorithm not found", e);
            return "";
        }
    }
    
    /**
     * Hashes password with salt
     * @param password password to hash
     * @param salt salt value
     * @return hash value
     */
    public static String hashPassword(String password, String salt) {
        if (password == null || salt == null) {
            return "";
        }
        return hashSHA256(password + salt);
    }
    
    /**
     * Generates a random salt value
     * @return salt value
     */
    public static String generateSalt() {
        byte[] saltBytes = new byte[16];
        RANDOM.nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes);
    }
    
    /**
     * Generates a random token
     * @return token value
     */
    public static String generateToken() {
        byte[] tokenBytes = new byte[32];
        RANDOM.nextBytes(tokenBytes);
        return Base64.getEncoder().encodeToString(tokenBytes);
    }
    
    /**
     * Checks if password meets strong password requirements
     * @param password password to check
     * @return true if password is strong
     */
    public static boolean isStrongPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }
        
        return hasLower && hasUpper && hasDigit && hasSpecial;
    }
    
    private SecurityUtils() {
        // Utility class, should not be instantiated
    }
} 