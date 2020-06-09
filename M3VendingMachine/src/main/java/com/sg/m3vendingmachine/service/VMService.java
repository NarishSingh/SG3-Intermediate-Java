package com.sg.m3vendingmachine.service;

import com.sg.m3vendingmachine.dao.VendingPersistenceException;
import com.sg.m3vendingmachine.dto.Coins;
import com.sg.m3vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface VMService {

    /**
     * Validate a newly constructed item and stock it in inventory
     *
     * @param snackDrink {Item} a item obj created by admin
     * @throws ItemDataValidationException if item is invalid
     * @throws VendingPersistenceException if cannot stock item to inventory
     */
    void stockItem(Item snackDrink) throws ItemDataValidationException, VendingPersistenceException;

    /**
     * Return the current inventory
     *
     * @return {List} all items available for purchase
     * @throws VendingPersistenceException if cannot read from inventory file
     */
    List<Item> getInventory() throws VendingPersistenceException;

    Item getItem(String itemName) throws VendingPersistenceException, NoSuchItemExistsException;
    
    /**
     * Sell an existing item from inventory, removing it, and returning the
     * proper change
     *
     * @param snackDrink {Item} the item to be sold
     * @param userCashIn {BigDecimal} cash inputted by user
     * @return {Map} change for the user as a HashMap of coins
     * @throws NoItemInventoryException   if no such item is present in
     *                                    inventory
     * @throws InsufficientFundsException if user has not inputted enough money
     *                                    into the vending machine
     */
    Map<Coins, Integer> sellItem(Item snackDrink, BigDecimal userCashIn)
            throws NoItemInventoryException, InsufficientFundsException;
}
