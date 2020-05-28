/** *******************************
 * The Software Guild
 * Copyright (C) 2020 Wiley edu LLC - All Rights Reserved
 ******************************** */
package com.tsg.unittesting.strings;

/**
 *
 * @author ahill
 */
public class StringsExerciseC {

    /**
     * Take a word, and remove all its vowels and returns it.
     *
     * Ex: removeTheVowels( "truncate" ) -> "trnct" removeTheVowels( "squashed"
     * ) -> "sqshd" removeTheVowels( "compressed" ) -> "cmprssd"
     *
     * @param word
     * @return String
     */
    public static String removeTheVowels(String word) {
        String noVowels = "";

        if (!word.isBlank()) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != 'a'
                        && word.charAt(i) != 'e'
                        && word.charAt(i) != 'i'
                        && word.charAt(i) != 'o'
                        && word.charAt(i) != 'u') {
                    noVowels += word.charAt(i);
                }
            }
        }

        return noVowels;
    }

}
