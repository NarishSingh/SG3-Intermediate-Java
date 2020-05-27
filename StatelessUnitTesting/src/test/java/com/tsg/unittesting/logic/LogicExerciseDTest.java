
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
public class LogicExerciseDTest {
    
    public LogicExerciseDTest() {
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
     * Test of isFirstTheFirst method, of class LogicExerciseD.
     */
    @Test
    public void testIsFirstTheFirst() {
        System.out.println("isFirstTheFirst");
        char letterOne = ' ';
        char letterTwo = ' ';
        boolean expResult = false;
        boolean result = LogicExerciseD.isFirstTheFirst(letterOne, letterTwo);
        assertEquals(expResult, result);
    }
    
    /*
     isFirstTheFirst( 'a' , 'b'  ) ->  true
     isFirstTheFirst( 'O' , 'X'  ) ->  true
     isFirstTheFirst( 'Z' , 'z'   ) -> false
    */
    
    @Test
    public void testIsAbeforeB() {
        System.out.println("isFirstTheFirst");
        char letterOne = 'A';
        char letterTwo = 'B';
        boolean expResult = true;
        boolean result = LogicExerciseD.isFirstTheFirst(letterOne, letterTwo);
        assertEquals(expResult, result);
    }
    @Test
    public void testIsObeforeX() {
        System.out.println("isFirstTheFirst");
        char letterOne = 'O';
        char letterTwo = 'X';
        boolean expResult = true;
        boolean result = LogicExerciseD.isFirstTheFirst(letterOne, letterTwo);
        assertEquals(expResult, result);
    }
    @Test
    public void testIsZbeforeZ() {
        System.out.println("isFirstTheFirst");
        char letterOne = 'Z';
        char letterTwo = 'z';
        boolean expResult = false;
        boolean result = LogicExerciseD.isFirstTheFirst(letterOne, letterTwo);
        assertEquals(expResult, result);
    }
}
