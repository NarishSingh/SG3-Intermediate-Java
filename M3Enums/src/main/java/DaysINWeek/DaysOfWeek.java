/*
Create an App class that asks the user to enter a day of the week and then use a 
switch statement and your enum to print out how many days there are until Friday.
 */
package DaysINWeek;

import java.util.Scanner;

public class DaysOfWeek {

    /**
     * Validate inputs and convert to enum
     *
     * @param dayInput {String} the user's inputted day
     * @return {Days} return the corresponding enum or throw error
     * @throws UnsupportedDayException if day doesn't exist or isn't in the
     *                                 gregorian calender
     */
    static public Days validateDay(String dayInput) throws UnsupportedDayException {
        String processedDay = dayInput.toUpperCase();

        switch (processedDay) {
            case "SUNDAY": {
                return Days.SUNDAY;
            }
            case "MONDAY": {
                return Days.MONDAY;
            }
            case "TUESDAY": {
                return Days.TUESDAY;
            }
            case "WEDNESDAY": {
                return Days.WEDNESDAY;
            }
            case "THURSDAY": {
                return Days.THURSDAY;
            }
            case "FRIDAY": {
                return Days.FRIDAY;
            }
            case "SATURDAY": {
                return Days.SATURDAY;
            }
            default: {
                throw new UnsupportedDayException();
            }
        }
    }

    /**
     * Calculate how many days until Friday
     *
     * @param day {Days} day of the week obj from user's inputs
     * @return {int} the amount of days until Friday
     * @throws UnsupportedDayException if day doesn't exist or isn't in the
     *                                 gregorian calender
     */
    static public int fridayCountdown(Days day) throws UnsupportedDayException {
        switch (day) {
            case SUNDAY: {
                return 5;
            }
            case MONDAY: {
                return 4;
            }
            case TUESDAY: {
                return 3;
            }
            case WEDNESDAY: {
                return 2;
            }
            case THURSDAY: {
                return 1;
            }
            case FRIDAY: {
                return 0;
            }
            case SATURDAY: {
                return 6;
            }
            default: {
                throw new UnsupportedDayException();
            }
        }
    }

    public static void main(String[] args) throws UnsupportedDayException {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a day of the Week: ");
        String aDay = input.nextLine();

        Days userDay = validateDay(aDay);

        if (fridayCountdown(userDay) == 0) {
            System.out.println("ITS FRIDAY FRIDAY FRIDAYYYYY");
        } else {
            System.out.println(fridayCountdown(userDay) + " days until Friday");
        }
    }

}
