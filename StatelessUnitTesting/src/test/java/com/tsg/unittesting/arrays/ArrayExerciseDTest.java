package com.tsg.unittesting.arrays;

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
public class ArrayExerciseDTest {

    public ArrayExerciseDTest() {
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
     * Test of pointFree method, of class ArrayExerciseD.
     */
    @Test
    public void testPointFree() {
        System.out.println("pointFree");
        double[] numbers = null;
        int expResult = 0;
        int result = ArrayExerciseD.pointFree(numbers);
        assertEquals(expResult, result);
    }

    @Test
    public void testPointFree2Numbers() {
        System.out.println("pointFree");
        double[] numbers = {1.1, .22};
        int expResult = 22;

        int result = ArrayExerciseD.pointFree(numbers);

        assertEquals(expResult, result);
    }

    @Test
    public void testPointFree3Numbers() {
        System.out.println("pointFree");
        double[] numbers = {.039, 20, .005005};
        int expResult = 5005;

        int result = ArrayExerciseD.pointFree(numbers);

        assertEquals(expResult, result);
    }

    @Test
    public void testPointFree3NegativeNumbers() {
        System.out.println("pointFree");
        double[] numbers = {-9.9, -700, -.5};
        int expResult = -5;

        int result = ArrayExerciseD.pointFree(numbers);

        assertEquals(expResult, result);
    }
}
