package com.sg.m3vendingmachine.service;

import com.sg.m3vendingmachine.dao.VMAuditDAO;
import com.sg.m3vendingmachine.dao.VMDAO;
import com.sg.m3vendingmachine.dao.VendingPersistenceException;
import com.sg.m3vendingmachine.dto.Item;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.platform.engine.TestDescriptor;

public class VMServiceImplTest {

    private VMService testServ;

    public VMServiceImplTest() {
        VMDAO testDAO = new VMDAOImplStub();
        VMAuditDAO testAuditDAO = new VMAuditDAOImplStub();

        testServ = new VMServiceImpl(testDAO, testAuditDAO);
    }

    /**
     * Test of stockItem method, of class VMServiceImpl.
     *
     * @throws Exception
     */
    @Test
    public void testStockItem() throws Exception {
        System.out.println("stockItem");

        //arrange
        Item newItem = new Item("Energy Drink", new BigDecimal("2.99"));

        //act and assert
        try {
            testServ.stockItem(newItem);
        } catch (VendingPersistenceException
                | ItemDataValidationException e) {
            fail("Valid Item. No exception should be thrown");
        }
    }

    /**
     * Test of getInventory and inventoryCount method, of class VMServiceImpl.
     *
     * @throws Exception
     */
    @Test
    public void testGetInventoryWithCount() throws Exception {
        System.out.println("getInventory");

        //arrange
        Item newItem = new Item("Energy Drink", new BigDecimal("2.99"));

        //act and assert
        try {
            testServ.stockItem(newItem);
        } catch (VendingPersistenceException
                | ItemDataValidationException e) {
            fail("Valid Item. No exception should be thrown");
        }

        assertEquals(1, testServ.getInventory().size(), "Test Inventory should only have 1 Item");
        assertTrue(testServ.getInventory().contains(newItem), "Test Inventory should contain Energy Drink");

        int testInventoryCount = testServ.inventoryCount();

        assertEquals(testInventoryCount, testServ.getInventory().size(), "Test Inventory Count should register 1 Item");
    }

    /**
     * Test of getItem method, of class VMServiceImpl.
     *
     * @throws Exception
     */
    @Test
    public void testGetItem() throws Exception {
        System.out.println("getItem");
        final String TEST_ITEM_NAME = "Energy Drink";

        //arrange
        Item newItem = new Item(TEST_ITEM_NAME, new BigDecimal("2.99"));
        Item testItem;

        //act and assert
        try {
            testServ.stockItem(newItem);
            testItem = testServ.getItem(TEST_ITEM_NAME);

            assertEquals(testItem, newItem, "New item added should be Energy Drink");
        } catch (VendingPersistenceException
                | ItemDataValidationException e) {
            fail("Valid Item. No exception should be thrown");
        }
    }

    /**
     * Test of sellItem method, of class VMServiceImpl. This will have exact
     * change and successful run
     *
     * @throws Exception
     */
    @Test
    public void testSellItemSuccess() throws Exception {
        System.out.println("sellItem");

        //arrange
        final BigDecimal exactChange = new BigDecimal("2.99");
        Item newItem = new Item("Energy Drink", exactChange);

        //act and assert
        try {
            testServ.sellItem(newItem, exactChange);
        } catch (InsufficientFundsException e) {
            fail("Should not be failing, valid change.");
        }
    }

    /**
     * Test of sellItem method, of class VMServiceImpl.
     *
     * @throws Exception
     */
    @Test
    public void testSellItemFailUnderPay() throws Exception {
        System.out.println("sellItem");

        //arrange
        final BigDecimal underpayChange = new BigDecimal(".99");
        Item newItem = new Item("Energy Drink", new BigDecimal("2.99"));

        //act and assert
        try {
            testServ.sellItem(newItem, underpayChange);
        } catch (InsufficientFundsException e) {
            return; //should fail
        }
    }

    /**
     * Test of sellItem method, of class VMServiceImpl.
     *
     * @throws Exception
     */
    @Test
    public void testSellItemFailOverPay() throws Exception {
        System.out.println("sellItem");

        //arrange
        final BigDecimal overpayChange = new BigDecimal(".99");
        Item newItem = new Item("Energy Drink", new BigDecimal("2.99"));

        //act and assert
        try {
            testServ.sellItem(newItem, overpayChange);
        } catch (InsufficientFundsException e) {
            fail("Shouldn't fail, enough money has been deposited even if its over the amount");
        }
    }
}
