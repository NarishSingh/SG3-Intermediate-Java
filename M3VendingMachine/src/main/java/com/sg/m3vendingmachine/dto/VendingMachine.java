/*
Vending Machine DTO class
 */
package com.sg.m3vendingmachine.dto;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    /*fields*/
    private List<Item> inventory;
    private int inventoryCount;

    /*ctor*/
    public VendingMachine() {
        this.inventory = new ArrayList<>();
    }

    public VendingMachine(List<Item> inventory) {
        this.inventory = inventory;
    }

    /*getter/setters*/
    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public int getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(int inventoryCount) {
        this.inventoryCount = inventoryCount;
    }

    /*Behaviors*/
    /**
     * Tally items in inventory and set inventoryCount
     */
    private void totalInventory() {
        Long itemCtLong = inventory.stream()
                .count();

        int itemCount = itemCtLong.intValue();

        this.setInventoryCount(inventoryCount);
    }
}
