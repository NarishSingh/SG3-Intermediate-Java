/** *******************************
 * The Software Guild
 * Copyright (C) 2020 Wiley edu LLC - All Rights Reserved
 ******************************** */
package com.tsg.unittesting.logic;

/**
 *
 * @author ahill
 */
public class LogicExerciseB {

    /**
     * Given a number, return the 'place rank' word associated with it. I.e.
     * pretend you're ranking folks running in a race from the order they
     * arrived at the finish line. Assume nonzero, positive inputs! Also, start
     * by going up to 100, but stretch to more if you can!
     *
     * Ex: placeOf( 1 ) -> "1st" placeOf( 3 ) -> "3rd" placeOf( 22 ) -> "22nd"
     * 
     * http://www.tushar-mehta.com/publish_train/xl_vba_cases/0122%20ordinal%20number%20suffixes.shtml
     *
     * @param place
     * @return String
     */
    public String placeOf(int place) {
        String placeTitle = "";

        if (place > 0) {
            if (place == 1 || place % 10 == 1) {
                placeTitle += place;
                placeTitle += "st";

                return placeTitle;
            } else if (place == 2 || place % 10 == 2) {
                placeTitle += place;
                placeTitle += "nd";

                return placeTitle;
            } else if (place == 3 || place % 10 == 3) {
                placeTitle += place;
                placeTitle += "rd";

                return placeTitle;
            } else if (place % 100 == 11
                    || place % 100 == 12
                    || place % 100 == 13
                    || place % 100 == 14
                    || place % 100 == 15
                    || place % 100 == 16
                    || place % 100 == 17
                    || place % 100 == 18
                    || place % 100 == 19
                    || place % 100 == 20) {
                placeTitle += place;
                placeTitle += "th";

                return placeTitle;
            } else {
                placeTitle += place;
                placeTitle += "th";

                return placeTitle;
            }
        }

        return placeTitle;
    }
    
}
