package com.sg.m3vendingmachine.dao;

import com.sg.m3vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;

public interface VMDAO {
    
    /*snack/drink specific*/
    void addItem(Item snackDrink, int quantity) throws VendingDAOException;
    
    void removeItem(Item snackDrink, int quantity) throws VendingDAOException;
    
    List<Item> getInventory() throws VendingDAOException;
    
    Item dispenseItemChange(Item snackDrink, BigDecimal userCashIn) throws VendingDAOException;
    
}
