/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class LogicExerciseETest {
    
    public LogicExerciseETest() {
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
     * Test of whatColor method, of class LogicExerciseE.
     */
    @Test
    public void testWhatColor() {
        System.out.println("whatColor");
        int waveLengthNM = 0;
        int frequencyTHZ = 0;
        double photonicEnergyEV = 0.0;
        String expResult = "";
        String result = LogicExerciseE.whatColor(waveLengthNM, frequencyTHZ, photonicEnergyEV);
        assertEquals(expResult, result);
    }
    
}
