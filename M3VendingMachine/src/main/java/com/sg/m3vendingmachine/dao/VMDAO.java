package com.sg.m3vendingmachine.dao;

import com.sg.m3vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;

public interface VMDAO {
    
    /*snack/drink specific*/
    /**
     * 
     * @param snackDrink
     * @throws VendingPersistenceException 
     */
    void addItem(Item snackDrink) throws VendingPersistenceException;
    
    /**
     * 
     * @param snackDrink
     * @throws VendingPersistenceException 
     */
    void removeItem(Item snackDrink) throws VendingPersistenceException;
    
    /**
     * 
     * @return
     * @throws VendingPersistenceException 
     */
    List<Item> getInventory() throws VendingPersistenceException;
    
    /**
     * 
     * @param snackDrink
     * @param userCashIn
     * @return
     * @throws VendingPersistenceException 
     */
    Item dispenseItemChange(Item snackDrink, BigDecimal userCashIn) throws VendingPersistenceException;
    
}
