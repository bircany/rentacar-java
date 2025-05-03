package com.rentacar.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Helper class for date operations
 */
public class DateUtils {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    
    /**
     * Converts a date string to a Date object
     * @param dateString date string in "dd/MM/yyyy" format
     * @return Date object
     * @throws ParseException if date format is invalid
     */
    public static Date parseDate(String dateString) throws ParseException {
        return DATE_FORMAT.parse(dateString);
    }
    
    /**
     * Formats a Date object to "dd/MM/yyyy" format
     * @param date date to format
     * @return formatted date string
     */
    public static String formatDate(Date date) {
        return DATE_FORMAT.format(date);
    }
    
    /**
     * Calculates the number of days between two dates
     * @param startDate start date
     * @param endDate end date
     * @return number of days (integer)
     */
    public static long daysBetween(Date startDate, Date endDate) {
        LocalDate start = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate end = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return ChronoUnit.DAYS.between(start, end);
    }
    
    /**
     * Adds specified number of days to a date
     * @param date date
     * @param days number of days to add
     * @return new date
     */
    public static Date addDays(Date date, int days) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate newDate = localDate.plusDays(days);
        return Date.from(newDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
    
    /**
     * Returns today's date
     * @return today's date
     */
    public static Date today() {
        return new Date();
    }
    
    private DateUtils() {
        // Utility class, should not be instantiated
    }
} 