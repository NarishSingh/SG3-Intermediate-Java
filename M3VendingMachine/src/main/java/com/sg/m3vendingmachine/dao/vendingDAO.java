package com.sg.m3vendingmachine.dao;

import com.sg.m3vendingmachine.dto.Item;
import java.util.List;

public interface vendingDAO {

    List<Item> getInventory() throws VendingPersistenceException;

    List<Item> getInventoryByType() throws VendingPersistenceException;

    Item addItem() throws VendingPersistenceException;

    Item dispenseItem() throws VendingPersistenceException;
}
