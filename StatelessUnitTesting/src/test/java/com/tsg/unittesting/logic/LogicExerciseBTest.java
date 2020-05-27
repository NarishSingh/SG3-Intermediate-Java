package com.tsg.unittesting.logic;

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
public class LogicExerciseBTest {

    public LogicExerciseBTest() {
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
     * Test of placeOf method, of class LogicExerciseB.
     */
    @Test
    public void testPlaceOf() {
        System.out.println("placeOf");
        int place = 0;
        LogicExerciseB instance = new LogicExerciseB();
        String expResult = "";
        String result = instance.placeOf(place);
        assertEquals(expResult, result);
    }

    /*
     Ex: placeOf( 1 ) -> "1st" 
     placeOf( 3 ) -> "3rd" 
     placeOf( 22 ) -> "22nd"
     */
    @Test
    public void testPlaceOf1st() {
        System.out.println("placeOf");
        int place = 1;
        LogicExerciseB instance = new LogicExerciseB();
        String expResult = place + "st";
        String result = instance.placeOf(place);
        assertEquals(expResult, result);
    }

    @Test
    public void testPlaceOf3rd() {
        System.out.println("placeOf");
        int place = 3;
        LogicExerciseB instance = new LogicExerciseB();
        String expResult = place + "rd";
        String result = instance.placeOf(place);
        assertEquals(expResult, result);
    }

    @Test
    public void testPlaceOf22nd() {
        System.out.println("placeOf");
        int place = 22;
        LogicExerciseB instance = new LogicExerciseB();
        String expResult = place + "nd";
        String result = instance.placeOf(place);
        assertEquals(expResult, result);
    }

}
