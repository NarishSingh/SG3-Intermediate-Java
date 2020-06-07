/*
Vending Machine DTO class
 */
package com.sg.m3vendingmachine.dto;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    /*fields*/
    private List<Item> inventory;

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

}
