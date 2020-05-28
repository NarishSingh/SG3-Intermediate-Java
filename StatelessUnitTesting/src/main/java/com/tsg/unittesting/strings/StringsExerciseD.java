/*********************************
* The Software Guild
* Copyright (C) 2020 Wiley edu LLC - All Rights Reserved
*********************************/
package com.tsg.unittesting.strings;

/**
 *
 * @author ahill
 */
public class StringsExerciseD {
    
    /**
     * Given a phrase string - turns the whole thing around.
     * Return the original, but totally backwards to forwards!
     *
     * 
     * Ex:
     * simpleReverse( "fun times" ) ->  "semit nuf"
     * simpleReverse( "llama llama duck" ) ->  "kcud amall amall"
     * simpleReverse( "hannah" ) ->  "hannah"
     * 
     * @param phrase
     * @return String backwards
     */
    public static String simpleReverse(String phrase){
        String reversePhrase="";
        
        if (!phrase.isBlank()) {
            for (int i = 0; i < phrase.length(); i++) {
                reversePhrase+=phrase.charAt((phrase.length()-1)-i);
            }
        }
        
        return reversePhrase;
    }
}
