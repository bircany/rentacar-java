package com.rentacar.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Helper class for validation operations
 */
public class ValidationUtils {
    
    // Regex for Turkish license plate format
    private static final String PLATE_REGEX = "^(0[1-9]|[1-7]\\d|8[01])[A-Z]{1,3}(\\d{2,4})$";
    private static final Pattern PLATE_PATTERN = Pattern.compile(PLATE_REGEX);
    
    // Regex for Turkish national ID
    private static final String NATIONAL_ID_REGEX = "^[1-9]\\d{10}$";
    private static final Pattern NATIONAL_ID_PATTERN = Pattern.compile(NATIONAL_ID_REGEX);
    
    // Email regex
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    
    // Phone number regex (for Turkey)
    private static final String PHONE_REGEX = "^(\\+90|0)?\\d{10}$";
    private static final Pattern PHONE_PATTERN = Pattern.compile(PHONE_REGEX);
    
    /**
     * Checks if the license plate format is valid
     * @param plate License plate to check
     * @return true if the license plate format is valid, false otherwise
     */
    public static boolean isValidPlate(String plate) {
        if (plate == null) {
            return false;
        }
        Matcher matcher = PLATE_PATTERN.matcher(plate.trim().toUpperCase());
        return matcher.matches();
    }
    
    /**
     * Checks if the Turkish national ID is valid
     * @param nationalId Turkish national ID to check
     * @return true if the Turkish national ID format is valid, false otherwise
     */
    public static boolean isValidNationalId(String nationalId) {
        if (nationalId == null) {
            return false;
        }
        
        Matcher matcher = NATIONAL_ID_PATTERN.matcher(nationalId.trim());
        if (!matcher.matches()) {
            return false;
        }
        
        // Turkish national ID algorithm check
        char[] digits = nationalId.toCharArray();
        int[] numbers = new int[11];
        
        // Convert char digits to int numbers
        for (int i = 0; i < 11; i++) {
            numbers[i] = Character.getNumericValue(digits[i]);
        }
        
        // Calculate 10th digit verification
        int oddSum = numbers[0] + numbers[2] + numbers[4] + numbers[6] + numbers[8];
        int evenSum = numbers[1] + numbers[3] + numbers[5] + numbers[7];
        int tenthDigitCheck = (oddSum * 7 - evenSum) % 10;
        
        // Calculate 11th digit verification (sum of first 10 digits mod 10)
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += numbers[i];
        }
        int eleventhDigitCheck = sum % 10;
        
        return (tenthDigitCheck == numbers[9] && eleventhDigitCheck == numbers[10]);
    }
    
    /**
     * Checks if the email format is valid
     * @param email Email to check
     * @return true if the email format is valid, false otherwise
     */
    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        Matcher matcher = EMAIL_PATTERN.matcher(email.trim());
        return matcher.matches();
    }
    
    /**
     * Checks if the phone number format is valid
     * @param phone Phone number to check
     * @return true if the phone number format is valid, false otherwise
     */
    public static boolean isValidPhone(String phone) {
        if (phone == null) {
            return false;
        }
        Matcher matcher = PHONE_PATTERN.matcher(phone.trim());
        return matcher.matches();
    }
    
    /**
     * Checks if a text is empty
     * @param text Text to check
     * @return true if the text is empty or null, false otherwise
     */
    public static boolean isEmpty(String text) {
        return text == null || text.trim().isEmpty();
    }
    
    /**
     * Checks if a number is in a specific range
     * @param number Number to check
     * @param min Minimum value (inclusive)
     * @param max Maximum value (inclusive)
     * @return true if the number is in the range, false otherwise
     */
    public static boolean isInRange(int number, int min, int max) {
        return number >= min && number <= max;
    }
    
    /**
     * Checks if a number is in a specific range
     * @param number Number to check
     * @param min Minimum value (inclusive)
     * @param max Maximum value (inclusive)
     * @return true if the number is in the range, false otherwise
     */
    public static boolean isInRange(double number, double min, double max) {
        return number >= min && number <= max;
    }
    
    private ValidationUtils() {
        // Utility class, should not be instantiated
    }
} 