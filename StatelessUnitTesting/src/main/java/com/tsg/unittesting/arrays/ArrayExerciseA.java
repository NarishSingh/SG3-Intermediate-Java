/** *******************************
 * The Software Guild
 * Copyright (C) 2020 Wiley edu LLC - All Rights Reserved
 ******************************** */
package com.tsg.unittesting.arrays;

/**
 *
 * @author ahill
 */
public class ArrayExerciseA {

    /**
     * Given an array of ints, find and return the maximum value.
     *
     * Example Results: maxOfArray( {1} ) -> 1 maxOfArray( {3,4,5} ) -> 5
     * maxOfArray( {-9000, -700, -50, -3} ) -> -3
     *
     * @param numbers array of integers
     * @return int max
     */
    public static int maxOfArray(int[] numbers) {
        int max = 0;

        if (numbers != null && numbers.length > 0) {
            max = numbers[0];

            for (int x : numbers) {
                if (x > max) {
                    max = x;
                }
            }
        }

        return max;
    }

}
