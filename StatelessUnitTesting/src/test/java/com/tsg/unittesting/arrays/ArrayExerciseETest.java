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
public class ArrayExerciseETest {

    public ArrayExerciseETest() {
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
     * Test of camelCaseIt method, of class ArrayExerciseE.
     */
    @Test
    public void testCamelCaseIt() {
        System.out.println("camelCaseIt");
        String[] words = null;
        String expResult = "";
        String result = ArrayExerciseE.camelCaseIt(words);
        assertEquals(expResult, result);
    }

//     * camelCaseIt( {"llama", "llama", "duck"}  ) ->  "llamaLlamaDuck"
//     * camelCaseIt( {"lambs", "eat", "oats", "and", "does", "eat", "oats"}  ) ->  "lambsEatOatsAndDoesEatOats"
//     * camelCaseIt( {"DO", "OR", "DO", "NOT", "THERE", "IS", "NO", "TRY"}  ) ->  "doOrDoNotThereIsNoTry"
    @Test
    public void testCamelCaseIt3words() {
        System.out.println("camelCaseIt");
        String[] words = {"llama", "llama", "duck"};
        String expResult = "llamaLlamaDuck";

        String result = ArrayExerciseE.camelCaseIt(words);

        assertEquals(expResult, result);
    }

    @Test
    public void testCamelCaseIt7words() {
        System.out.println("camelCaseIt");
        String[] words = {"lambs", "eat", "oats", "and", "does", "eat", "oats"};
        String expResult = "lambsEatOatsAndDoesEatOats";

        String result = ArrayExerciseE.camelCaseIt(words);

        assertEquals(expResult, result);
    }

    @Test
    public void testCamelCaseIt8wordsAllCalps() {
        System.out.println("camelCaseIt");
        String[] words = {"DO", "OR", "DO", "NOT", "THERE", "IS", "NO", "TRY"};
        String expResult = "doOrDoNotThereIsNoTry";

        String result = ArrayExerciseE.camelCaseIt(words);

        assertEquals(expResult, result);
    }
}
