package com.tsg.unittesting.strings;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author naris
 */
public class StringsExerciseFTest {

    public StringsExerciseFTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of longestWord method, of class StringsExerciseF.
     */
    @Test
    public void testLongestWord() {
        System.out.println("longestWord");
        String aPhrase = "";
        String expResult = "";
        String result = StringsExerciseF.longestWord(aPhrase);
        assertEquals(expResult, result);
    }

    /*
     longestWord( "Invention my dear friends is 93% perspiration 6% electricity 4% evaporation and 2% butterscotch ripple" ) ->  "perspiration"
     longestWord( "All well-established principles should be periodically challenged" ) ->  "well-established"
     longestWord( "Never argue with the data" ) ->  "Never"
     */
    @Test
    public void testInventionSentence() {
        System.out.println("longestWord");
        String aPhrase = "Invention my dear friends is 93% perspiration 6% electricity 4% evaporation and 2% butterscotch ripple";
        String expResult = "perspiration";
        String result = StringsExerciseF.longestWord(aPhrase);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testPrinciplesSentence() {
        System.out.println("longestWord");
        String aPhrase = "All well-established principles should be periodically challenged";
        String expResult = "well-established";
        String result = StringsExerciseF.longestWord(aPhrase);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDataSentence() {
        System.out.println("longestWord");
        String aPhrase = "Never argue with the data";
        String expResult = "Never";
        String result = StringsExerciseF.longestWord(aPhrase);
        assertEquals(expResult, result);
    }
}
