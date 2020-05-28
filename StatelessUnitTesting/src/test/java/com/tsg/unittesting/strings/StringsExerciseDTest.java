/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class StringsExerciseDTest {

    public StringsExerciseDTest() {
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
     * Test of simpleReverse method, of class StringsExerciseD.
     */
    @Test
    public void testSimpleReverse() {
        System.out.println("simpleReverse");
        String phrase = "";
        String expResult = "";
        String result = StringsExerciseD.simpleReverse(phrase);
        assertEquals(expResult, result);
    }

    @Test
    public void testFunTimes() {
        System.out.println("simpleReverse");
        String phrase = "fun times";
        String expResult = "semit nuf";
        String result = StringsExerciseD.simpleReverse(phrase);
        assertEquals(expResult, result);
    }

    @Test
    public void testLlamaLlamaDuck() {
        System.out.println("simpleReverse");
        String phrase = "llama llama duck";
        String expResult = "kcud amall amall";
        String result = StringsExerciseD.simpleReverse(phrase);
        assertEquals(expResult, result);
    }

    @Test
    public void testHannah() {
        System.out.println("simpleReverse");
        String phrase = "hannah";
        String expResult = "hannah";
        String result = StringsExerciseD.simpleReverse(phrase);
        assertEquals(expResult, result);
    }

}
