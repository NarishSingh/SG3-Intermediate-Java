package com.sg.m3vendingmachine.dao;

import com.sg.m3vendingmachine.dto.Coins;
import com.sg.m3vendingmachine.dto.Item;
import com.sg.m3vendingmachine.service.InsufficientFundsException;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VMDAOImplTest {

    VMDAO testDAO;

    public VMDAOImplTest() {
    }

    @BeforeEach
    public void setUp() throws Exception {
        String testFile = "testInventory.txt";
        new FileWriter(testFile);
        testDAO = new VMDAOImpl(testFile);
    }

    /**
     * Test of addItem method, of class VMDAOImpl.
     */
    @Test
    public void testAddItem() throws Exception {
        System.out.println("addItem");

        //arrange
        String testName = "Arizona Iced Tea";
        BigDecimal testCost = new BigDecimal("1.00");
        Item test = new Item(testName, testCost);

        //act
        testDAO.addItem(test);
        Item addedItem = testDAO.getItem(testName);

        //assert
        assertEquals(test.getName(), addedItem.getName(), "Added Item should be an Arizona Iced Tea");
        assertEquals(test.getCost(), addedItem.getCost(), "Added item should cost $1.00");
    }

    /**
     * Test of removeItem method, of class VMDAOImpl. Uses addItem and
     * getInventory methods
     */
    @Test
    public void testRemoveItem() throws Exception {
        System.out.println("removeItem");

        //arrange
        String testName1 = "Arizona Iced Tea";
        BigDecimal testCost1 = new BigDecimal("1.00");
        Item test1 = new Item(testName1, testCost1);

        String testName2 = "Coconut Water";
        BigDecimal testCost2 = new BigDecimal("2.99");
        Item test2 = new Item(testName2, testCost2);

        //act and assert
        testDAO.addItem(test1);
        testDAO.addItem(test2);

        boolean removedItem = testDAO.removeItem(test1);
        List<Item> inventoryAfterRemoval = testDAO.getInventory();

        assertTrue(removedItem, "test1 should've been removed from inventory");
        assertEquals(1, inventoryAfterRemoval.size(), "Should only have 1 item after removal");
        assertTrue(inventoryAfterRemoval.contains(test2), "Inventory should contain the Coconut Water");
        assertFalse(inventoryAfterRemoval.contains(test1), "Inventory should not contain the Arizona");
    }

    /**
     * Test of getInventory method, of class VMDAOImpl.
     */
    @Test
    public void testGetInventory() throws Exception {
        System.out.println("getInventory");

        //arrange
        String testName1 = "Arizona Iced Tea";
        BigDecimal testCost1 = new BigDecimal("1.00");
        Item test1 = new Item(testName1, testCost1);

        String testName2 = "Coconut Water";
        BigDecimal testCost2 = new BigDecimal("2.99");
        Item test2 = new Item(testName2, testCost2);

        //act and assert
        testDAO.addItem(test1);
        testDAO.addItem(test2);
        List<Item> inventory = testDAO.getInventory();

        assertEquals(2, inventory.size(), "Should have 2 items in inventory");
        assertTrue(inventory.contains(test1), "inventory should contain Arizona");
        assertTrue(inventory.contains(test2), "inventory should contain Coconut Water");
    }

    /**
     * Test of dispenseItemChange method, of class VMDAOImpl. This will pass but needs to dispense change
     */
    @Test
    public void testDispenseItemChangeSuccess() throws Exception {
        System.out.println("dispenseItemChange - Success");

        //arrange
        String testName1 = "Arizona Iced Tea";
        BigDecimal testCost1 = new BigDecimal("1.00");
        Item test1 = new Item(testName1, testCost1);

        BigDecimal overpay = new BigDecimal("2.00");

        Map<Coins, Integer> expectedChange = new HashMap<>();
        expectedChange.put(Coins.QUARTERS, 4);
        expectedChange.put(Coins.DIMES, 0);
        expectedChange.put(Coins.NICKELS, 0);
        expectedChange.put(Coins.PENNIES, 0);

        //act & assert
        try {
            Map<Coins, Integer> testChange = testDAO.dispenseItemChange(test1, overpay);
            assertEquals(expectedChange, testChange, "Transaction should return 4 quarters");
        } catch (InsufficientFundsException e) {
            fail("Shouldn't be failing");
        }
    }

    /**
     * Test of dispenseItemChange method, of class VMDAOImpl. This will fail as we underpaid
     * @throws Exception
     */
    @Test
    public void testDispenseItemChangeFail() throws Exception {
        System.out.println("dispenseItemChange - Fail");

        //arrange
        String testName1 = "Arizona Iced Tea";
        BigDecimal testCost1 = new BigDecimal("1.00");
        Item test1 = new Item(testName1, testCost1);

        BigDecimal underpay = new BigDecimal("0.50");

        try {
            Map<Coins, Integer> noChange = testDAO.dispenseItemChange(test1, underpay);
        } catch (InsufficientFundsException e) {
            return;
        }
    }

    /**
     * Test of inventoryCount method, of class VMDAOImpl.
     */
    @Test
    public void testInventoryCount() throws Exception {
        System.out.println("inventoryCount");

        //arrange
        String testName1 = "Arizona Iced Tea";
        BigDecimal testCost1 = new BigDecimal("1.00");
        Item test1 = new Item(testName1, testCost1);

        String testName2 = "Coconut Water";
        BigDecimal testCost2 = new BigDecimal("2.99");
        Item test2 = new Item(testName2, testCost2);

        //act
        testDAO.addItem(test1);
        testDAO.addItem(test2);
        List<Item> inventory = testDAO.getInventory();

        int inventoryCount = testDAO.inventoryCount();

        //assert
        assertEquals(2, inventoryCount, "Inventory should be counting 2 items stored in memory");
    }

}
