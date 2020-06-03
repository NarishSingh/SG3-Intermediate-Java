/*
Another refactored version of the interest calculator
This time with Big Decimal Class
 */
package com.sg.m3interestcalcrefactored;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class IntCalcMain {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter initial investment: $");
        BigDecimal principle = new BigDecimal(input.nextLine()).setScale(2, RoundingMode.HALF_UP);
        System.out.print("Enter annual interest rate in % form: ");
        BigDecimal interest = new BigDecimal(input.nextLine()).setScale(2, RoundingMode.HALF_UP);
        System.out.print("Enter number of years for principle growth: ");
        int growthPeriod = Integer.parseInt(input.nextLine());
        Interest acc = new Interest(principle, interest, growthPeriod);

        for (int i = 0; i < acc.getTerm(); i++) {
            System.out.println("Year " + (i + 1) + ":");
            System.out.printf("Year Start = $%.2f", acc.getInvestment());
            System.out.printf("\nAnnual Interest Earned: $%.2f", acc.calcYearlyIntr());
            System.out.printf("\nApproximate Interest Earned per quarter: $%.2f", acc.calcQuarterlyIntr());
            System.out.printf("\nApproximate Interest Earned per month: $%.2f", acc.calcMonthlyIntr());
            System.out.printf("\nApproximate Interest Earned per daily: $%.5f", acc.calcDailyIntr());

            System.out.printf("\nYear End Total = $%.2f", acc.yearEndPrinciple());
            System.out.println("\n---");
        }
    }

}
