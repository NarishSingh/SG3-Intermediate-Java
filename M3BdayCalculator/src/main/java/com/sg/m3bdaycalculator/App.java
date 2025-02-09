/*
Your birthday calculator application should do the following:
Ask someone for their birthday ex: 01/01/2002
Tell them the day of the week their birthday falls on.
Then tell them the day of the week it falls on this year!
Next tell them what day it is today & the number of days until their next birthday...
And how many years old they will be!
 */
package com.sg.m3bdaycalculator;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class App {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LocalDate ld = LocalDate.now();

        System.out.println("Welcome to the Bday Calculator!!!");
        System.out.print("Enter your Birthday in mm-dd-yyyy format: ");
        String userDate = input.nextLine();

        //bday that year
        LocalDate bday = LocalDate.parse(userDate, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        Period age = bday.until(ld);

        //bday this year
        int bdayMonth = bday.get(ChronoField.MONTH_OF_YEAR);
        int bdayDay = bday.getDayOfMonth();
        final int thisYear = ld.getYear();
        LocalDate bdayThisYear = LocalDate.of(thisYear, bdayMonth, bdayDay);

        //bday next year
        final int nextYear = thisYear + 1;
        LocalDate bdayNextYear = LocalDate.of(nextYear, bdayMonth, bdayDay);
        long daysUntilNextBday = ChronoUnit.DAYS.between(ld, bdayNextYear);

        System.out.println("You are " + age.getYears() + " years old!!");
        System.out.println("Your birthday fell on a " + bday.getDayOfWeek());
        System.out.println("This year, your birthday falls on a " + bdayThisYear.getDayOfWeek());
        System.out.println("There are " + daysUntilNextBday + " days until your birthday next year!"); //need to extract days from this
        System.out.println("You will be " + (age.getYears() + 1) + " years old!!");
    }

}
