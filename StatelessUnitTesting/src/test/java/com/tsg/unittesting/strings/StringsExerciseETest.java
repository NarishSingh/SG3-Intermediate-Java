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
public class StringsExerciseETest {

    public StringsExerciseETest() {
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
     * Test of containsTheOther method, of class StringsExerciseE.
     */
    @Test
    public void testContainsTheOther() {
        System.out.println("containsTheOther");
        String one = "";
        String two = "";
        boolean expResult = false;
        boolean result = StringsExerciseE.containsTheOther(one, two);
        assertEquals(expResult, result);
    }

    @Test
    public void testContainsTheOtherOneTone() {
        System.out.println("containsTheOther");
        String one = "one";
        String two = "tone";
        boolean expResult = true;
        boolean result = StringsExerciseE.containsTheOther(one, two);
        assertEquals(expResult, result);
    }

    @Test
    public void testContainsTheOtherSameSame() {
        System.out.println("containsTheOther");
        String one = "same";
        String two = "same";
        boolean expResult = false;
        boolean result = StringsExerciseE.containsTheOther(one, two);
        assertEquals(expResult, result);
    }

    @Test
    public void testContainsTheOtherFancypantsPants() {
        System.out.println("containsTheOther");
        String one = "fancypants";
        String two = "pants";
        boolean expResult = true;
        boolean result = StringsExerciseE.containsTheOther(one, two);
        assertEquals(expResult, result);
    }

    @Test
    public void testContainsTheOtherLlamaDuck() {
        System.out.println("containsTheOther");
        String one = "llama";
        String two = "duck";
        boolean expResult = false;
        boolean result = StringsExerciseE.containsTheOther(one, two);
        assertEquals(expResult, result);
    }

}
