package com.rentacar.util;

/**
 * Application constants
 */
public class Constants {
    
    // Vehicle statuses
    public static final String VEHICLE_STATUS_AVAILABLE = "AVAILABLE";
    public static final String VEHICLE_STATUS_RENTED = "RENTED";
    public static final String VEHICLE_STATUS_IN_SERVICE = "IN_SERVICE";
    public static final String VEHICLE_STATUS_SOLD = "SOLD";
    public static final String VEHICLE_STATUS_IN_SERVICE_ACCIDENT = "IN_SERVICE_ACCIDENT";
    public static final String VEHICLE_STATUS_IN_SERVICE_MAINTENANCE = "IN_SERVICE_MAINTENANCE";
    
    // Contract statuses
    public static final String CONTRACT_STATUS_ACTIVE = "ACTIVE";
    public static final String CONTRACT_STATUS_COMPLETED = "COMPLETED";
    public static final String CONTRACT_STATUS_CANCELLED = "CANCELLED";
    
    // Payment methods
    public static final String PAYMENT_METHOD_CASH = "CASH";
    public static final String PAYMENT_METHOD_CREDIT_CARD = "CREDIT_CARD";
    public static final String PAYMENT_METHOD_BANK_TRANSFER = "BANK_TRANSFER";
    
    // Personnel types
    public static final String PERSONNEL_TYPE_MANAGER = "MANAGER";
    public static final String PERSONNEL_TYPE_SALES_REPRESENTATIVE = "SALES_REPRESENTATIVE";
    public static final String PERSONNEL_TYPE_RENTAL_SPECIALIST = "RENTAL_SPECIALIST";
    public static final String PERSONNEL_TYPE_SERVICE_PERSONNEL = "SERVICE_PERSONNEL";
    
    // Customer types
    public static final String CUSTOMER_TYPE_INDIVIDUAL = "INDIVIDUAL";
    public static final String CUSTOMER_TYPE_CORPORATE = "CORPORATE";
    
    // DateFormat patterns
    public static final String DATE_PATTERN = "dd/MM/yyyy";
    public static final String DATE_TIME_PATTERN = "dd/MM/yyyy HH:mm";
    
    // Currency
    public static final String CURRENCY = "USD";
    
    // Default page size
    public static final int DEFAULT_PAGE_SIZE = 10;
    
    // Application settings
    public static final String APPLICATION_NAME = "RentACar Vehicle Rental Management System";
    public static final String APPLICATION_VERSION = "1.0.0";
    
    private Constants() {
        // Utility class, should not be instantiated
    }
} 