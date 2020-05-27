/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class ArrayExerciseCTest {

    public ArrayExerciseCTest() {
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
     * Test of stringThemTogether method, of class ArrayExerciseC.
     */
    @Test
    public void testStringThemTogether() {
        System.out.println("stringThemTogether");
        int[] nums = null;
        ArrayExerciseC instance = new ArrayExerciseC();
        String expResult = "";
        String result = instance.stringThemTogether(nums);
        assertEquals(expResult, result);
    }

    @Test
    public void testStringThemTogether1337() {
        System.out.println("stringThemTogether");
        int[] nums = {1, 3, 3, 7};
        ArrayExerciseC instance = new ArrayExerciseC();
        String expResult = "1337";

        String result = instance.stringThemTogether(nums);

        assertEquals(expResult, result);
    }

    @Test
    public void testStringThemTogether133555777799999() {
        System.out.println("stringThemTogether");
        int[] nums = {1, 33, 555, 7777, 99999};
        ArrayExerciseC instance = new ArrayExerciseC();
        String expResult = "133555777799999";

        String result = instance.stringThemTogether(nums);

        assertEquals(expResult, result);
    }

    @Test
    public void testStringThemTogetherBlank() {
        System.out.println("stringThemTogether");
        int[] nums = {};
        ArrayExerciseC instance = new ArrayExerciseC();
        String expResult = "";

        String result = instance.stringThemTogether(nums);

        assertEquals(expResult, result);
    }
}
