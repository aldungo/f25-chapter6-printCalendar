/**
 * Print Calendar Program
 * Chapter 6: Method Abstraction and Stepwise Refinement
 * 
 * This program prints a calendar for any given month and year.
 * We build it using a bottom-up approach, starting with small helper methods
 * and combining them to create more complex functionality.
 * 
 * @author FirstName LastName
 * @date November 3, 2025
 */

import java.util.Scanner;

public class F25_PrintCalendar_FirstName_LastName {
    
    /**
     * Main method: Entry point of the program
     * Handles user input and calls printMonth to display the calendar
     */
    public static void main(String[] args) {
        // TODO: Create a Scanner object for user input
        
        
        // TODO: Prompt the user to enter a full year (e.g., 2025)
        
        
        // TODO: Read the year from user input
        
        
        // TODO: Prompt the user to enter a month (1-12)
        
        
        // TODO: Read the month from user input
        
        
        // TODO: Call printMonth with the year and month
        
    }
    
    
    /* ========================================================================
     * STEP 1: isLeapYear
     * Bottom of our method hierarchy - no dependencies
     * ======================================================================== */
    
    /**
     * Determines if a given year is a leap year
     * 
     * A year is a leap year if:
     * - It's divisible by 400, OR
     * - It's divisible by 4 AND NOT divisible by 100
     * 
     * @param year The year to check
     * @return true if the year is a leap year, false otherwise
     * 
     * Examples:
     * - 2000: leap year (divisible by 400)
     * - 2024: leap year (divisible by 4, not by 100)
     * - 1900: NOT a leap year (divisible by 100, but not by 400)
     */

    public static boolean isLeapYear(int year) {
        // TODO: Implement the leap year logic
        // HINT: Use the modulo operator (%) to check divisibility
        // HINT: Remember the order of operations matters!
        
        return false; // Replace this with your actual logic
    }
    
    
    /* ========================================================================
     * STEP 2: getNumberOfDaysInMonth
     * Uses: isLeapYear
     * ======================================================================== */
    
    /**
     * Returns the number of days in a given month
     * 
     * @param year The year (needed for February in leap years)
     * @param month The month (1 = January, 2 = February, ..., 12 = December)
     * @return The number of days in the specified month
     * 
     * Days per month:
     * - 31 days: Jan(1), Mar(3), May(5), Jul(7), Aug(8), Oct(10), Dec(12)
     * - 30 days: Apr(4), Jun(6), Sep(9), Nov(11)
     * - 28/29 days: Feb(2) - depends on leap year
     */
    public static int getNumberOfDaysInMonth(int year, int month) {
        // TODO: Check for months with 31 days
        // HINT: Use an if statement with || (OR) operators
        
        
        // TODO: Check for months with 30 days
        
        
        // TODO: Check for February (month 2)
        // HINT: Call isLeapYear(year) to determine if it's 28 or 29 days
        // HINT: You can use a ternary operator: condition ? valueIfTrue : valueIfFalse
        
        
        return 0; // Default return (this should never be reached if month is valid)
    }
    
    
    /* ========================================================================
     * STEP 3: getTotalNumberOfDays
     * Uses: isLeapYear, getNumberOfDaysInMonth
     * ======================================================================== */
    
    /**
     * Calculates the total number of days from January 1, 1800 to month/1/year
     * 
     * We use January 1, 1800 as our reference date (it was a Wednesday)
     * This method adds up:
     * 1. All days in complete years from 1800 to the given year
     * 2. All days in complete months before the given month
     * 
     * @param year The target year
     * @param month The target month
     * @return Total number of days since January 1, 1800
     */

    public static int getTotalNumberOfDays(int year, int month) {
        int total = 0;
        
        // TODO: Calculate total days from 1800 to the beginning of 'year'
        // HINT: Use a for loop from 1800 to year (not including year)
        // HINT: For each year, check if it's a leap year
        //       - If leap year: add 366 days
        //       - If not: add 365 days
        
        
        
        
        
        // TODO: Add days for each month before the target month in the current year
        // HINT: Use a for loop from month 1 to the month before our target month
        // HINT: Call getNumberOfDaysInMonth for each month and add to total
        
        
        
        
        return total;
    }
    
    
    /* ========================================================================
     * STEP 4: getStartDay
     * Uses: getTotalNumberOfDays
     * ======================================================================== */
    
    /**
     * Determines what day of the week the first day of the month falls on
     * 
     * @param year The year
     * @param month The month
     * @return The day of the week (0 = Sunday, 1 = Monday, ..., 6 = Saturday)
     * 
     * Logic:
     * - January 1, 1800 was a Wednesday (day 3)
     * - We calculate total days since then
     * - Add 3 (for Wednesday) and take modulo 7 to get the day of the week
     */
    public static int getStartDay(int year, int month) {
        final int START_DAY_FOR_JAN_1_1800 = 3; // Wednesday
        
        // TODO: Get the total number of days from 1/1/1800 to month/1/year
        
        
        // TODO: Calculate and return the start day
        // HINT: (totalNumberOfDays + START_DAY_FOR_JAN_1_1800) % 7
        
        return 0; // Replace with your calculation
    }
    
    
    /* ========================================================================
     * STEP 5: getMonthName
     * No dependencies - just a lookup method
     * ======================================================================== */
    
    /**
     * Converts a month number to its English name
     * 
     * @param month The month number (1-12)
     * @return The name of the month (e.g., "January", "February", etc.)
     */
    public static String getMonthName(int month) {
        // TODO: Use a switch statement to return the month name
        // HINT: case 1: return "January";
        //       case 2: return "February";
        //       etc.
        return ""; // Default return (should not reach if month is 1-12)
    }
    
    
    /* ========================================================================
     * STEP 6: printMonthTitle
     * Uses: getMonthName
     * ======================================================================== */
    
    /**
     * Prints the title of the calendar (month name, year, and day headers)
     * 
     * Example output:
     *  November 2025
     * -----------------------------
     *  Sun Mon Tue Wed Thu Fri Sat
     * 
     * @param year The year to display
     * @param month The month to display
     */
    public static void printMonthTitle(int year, int month) {
        // TODO: Print a blank line, then the month name and year
        // HINT: Use getMonthName(month) to get the month name
        // Example: System.out.println("  " + getMonthName(month) + " " + year);
        
        
        // TODO: Print the separator line
        
        
        // TODO: Print the day-of-week headers
        
    }
    
    
    /* ========================================================================
     * STEP 7: printMonthBody
     * Uses: getStartDay, getNumberOfDaysInMonth
     * ======================================================================== */
    
    /**
     * Prints the body of the calendar (all the dates for the month)
     * 
     * This method:
     * 1. Pads spaces for days before the start of the month
     * 2. Prints each day of the month
     * 3. Moves to a new line after Saturday
     * 
     * @param year The year
     * @param month The month
     */

    public static void printMonthBody(int year, int month) {
        // TODO: Get the start day (0-6) for the first day of the month
        
        
        // TODO: Get the number of days in this month
        
        
        // TODO: Print padding spaces before the first day
        // HINT: Each day takes 4 spaces, so print "    " startDay times
        // Example: for (int i = 0; i < startDay; i++)
        //              System.out.print("    ");
        
        
        
        
        // TODO: Print each day of the month
        // HINT: Loop from 1 to numberOfDaysInMonth
        // HINT: Use System.out.printf("%4d", i) to print each day with 4-space width
        // HINT: After every 7th day (including padding), print a newline
        //       Check: if ((i + startDay) % 7 == 0)
        
        
        
        
        
        
        
        // TODO: Print a final newline after the calendar body
        
    }
    
    
    /* ========================================================================
     * STEP 8: printMonth
     * Uses: printMonthTitle, printMonthBody
     * ======================================================================== */
    
    /**
     * Prints the entire calendar for a given month and year
     * This is a high-level method that coordinates the title and body printing
     * 
     * @param year The year
     * @param month The month
     */
    public static void printMonth(int year, int month) {
        // TODO: Call printMonthTitle
        
        
        // TODO: Call printMonthBody
        
    }
} 
