package com.sg.m3vendingmachine.service;

import com.sg.m3vendingmachine.dto.Coins;
import com.sg.m3vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VMServiceImplTest {
    
    public VMServiceImplTest() {
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
     * Test of stockItem method, of class VMServiceImpl.
     */
    @Test
    public void testStockItem() throws Exception {
        System.out.println("stockItem");
        Item snackDrink = null;
        VMServiceImpl instance = null;
        instance.stockItem(snackDrink);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInventory method, of class VMServiceImpl.
     */
    @Test
    public void testGetInventory() throws Exception {
        System.out.println("getInventory");
        VMServiceImpl instance = null;
        List<Item> expResult = null;
        List<Item> result = instance.getInventory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItem method, of class VMServiceImpl.
     */
    @Test
    public void testGetItem() throws Exception {
        System.out.println("getItem");
        String itemName = "";
        VMServiceImpl instance = null;
        Item expResult = null;
        Item result = instance.getItem(itemName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sellItem method, of class VMServiceImpl.
     */
    @Test
    public void testSellItem() throws Exception {
        System.out.println("sellItem");
        Item snackDrink = null;
        BigDecimal userCashIn = null;
        VMServiceImpl instance = null;
        Map<Coins, Integer> expResult = null;
        Map<Coins, Integer> result = instance.sellItem(snackDrink, userCashIn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inventoryCount method, of class VMServiceImpl.
     */
    @Test
    public void testInventoryCount() throws Exception {
        System.out.println("inventoryCount");
        VMServiceImpl instance = null;
        int expResult = 0;
        int result = instance.inventoryCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
