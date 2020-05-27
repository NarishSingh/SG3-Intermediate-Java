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
public class ArrayExerciseATest {

    public ArrayExerciseATest() {
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
     * Test of maxOfArray method, of class ArrayExerciseA.
     */
    @Test
    public void testMaxOfArray() {
        System.out.println("maxOfArray");
        int[] numbers = null;
        int expResult = 0;
        int result = ArrayExerciseA.maxOfArray(numbers);
        assertEquals(expResult, result);
    }

    @Test
    public void testCountToTenArray() {
        //Arrange
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int expResult = 10;

        //Act
        int result = ArrayExerciseA.maxOfArray(array);

        //Assert
        assertEquals(expResult, result);
    }

    @Test
    public void testCountByTenArray() {
        //Arrange
        int[] array = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int expResult = 100;

        //Act
        int result = ArrayExerciseA.maxOfArray(array);

        //Assert
        assertEquals(expResult, result);
    }

    @Test
    public void testCountDownFromTenArray() {
        //Arrange
        int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int expResult = 10;

        //Act
        int result = ArrayExerciseA.maxOfArray(array);

        //Assert
        assertEquals(expResult, result);
    }

    @Test
    public void testCountRandomArray() {
        //Arrange
        int[] array = {10, 90, 5, 168, 4, 89, 11, 48, 55, 55};
        int expResult = 168;

        //Act
        int result = ArrayExerciseA.maxOfArray(array);

        //Assert
        assertEquals(expResult, result);
    }
}
