package com.sg.m3vendingmachine.service;

import com.sg.m3vendingmachine.dao.VMDAO;
import com.sg.m3vendingmachine.dao.VendingPersistenceException;
import com.sg.m3vendingmachine.dto.Coins;
import com.sg.m3vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VMDAOImplStub implements VMDAO {

    public Item onlyItem;
    final BigDecimal overpay = new BigDecimal("2.00");

    /*ctors*/
    public VMDAOImplStub() {
        onlyItem = new Item("Arizona Iced Tea", new BigDecimal("1.00"));
    }

    public VMDAOImplStub(Item onlyItem) {
        this.onlyItem = onlyItem;
    }

    /*stubs*/
    @Override
    public boolean addItem(Item snackDrink) throws VendingPersistenceException {
        return snackDrink==onlyItem;
    }

    @Override
    public boolean removeItem(Item snackDrink) throws VendingPersistenceException {
        return snackDrink==onlyItem;
    }

    @Override
    public Item getItem(String itemName) throws VendingPersistenceException, NoSuchItemExistsException {
        if (itemName.equals(onlyItem.getName())) {
            return onlyItem;
        } else {
            return null;
        }
    }

    @Override
    public List<Item> getInventory() throws VendingPersistenceException {
        List<Item> testInv = new ArrayList<>();
        testInv.add(onlyItem);
        
        return testInv;
    }

    @Override
    public Map<Coins, Integer> dispenseItemChange(Item snackDrink, BigDecimal userCashIn)
            throws InsufficientFundsException {
        Map<Coins, Integer> expectedChange = new HashMap<>();
        expectedChange.put(Coins.QUARTERS, 4);
        expectedChange.put(Coins.DIMES, 0);
        expectedChange.put(Coins.NICKELS, 0);
        expectedChange.put(Coins.PENNIES, 0);
        
        return expectedChange;
    }

    @Override
    public int inventoryCount() throws VendingPersistenceException {
        return 1;
    }

}
