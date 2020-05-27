/** *******************************
 * The Software Guild
 * Copyright (C) 2020 Wiley edu LLC - All Rights Reserved
 ******************************** */
package com.tsg.unittesting.arrays;

/**
 *
 * @author ahill
 */
public class ArrayExerciseD {

    /**
     * Given an array of doubles, return the biggest number of the lot, as if
     * the decimal had gone missing!
     *
     *
     * pointFree( [1.1, .22] ) -> 22 pointFree( [ .039 , 20 , .005005 ] ) ->
     * 5005 pointFree( [ -9.9 , -700 , -.5 ] ) -> -5
     *
     * @param numbers
     * @return
     */
    public static int pointFree(double[] numbers) {
        int maxNum = 0;
        final String DELIMITER = ".";

        if (numbers != null && numbers.length > 0) {
            maxNum = (int) numbers[0];

            String[] numStrings = new String[numbers.length];
            String[] numStringsInt = new String[numbers.length];
            //elements to String
            for (int i = 0; i < numbers.length; i++) {
                numStrings[i] = Double.toString(numbers[i]);
            }
            //split along decimal and rejoin
            for (int i = 0; i < numStrings.length; i++) {
                if (numStrings[i].contains(DELIMITER)) {
                    String t = numStrings[i];
                    String[] tokens = t.split("\\.");
                    if (tokens[0].isBlank()) {
                        numStringsInt[i] = tokens[1];
                    } else {
                        numStringsInt[i] = tokens[0].concat(tokens[1]);
                    }
                } else {
                    numStringsInt[i] = numStrings[i];
                }
            }
            //parse to int
            int[] newNum = new int[numbers.length];
            for (int i = 0; i < numStringsInt.length; i++) {
                newNum[i] = Integer.parseInt(numStringsInt[i]);
                //track biggest number
                if (newNum[i] > maxNum) {
                    maxNum = newNum[i];
                }
            }
        }
        return maxNum;
    }
}
