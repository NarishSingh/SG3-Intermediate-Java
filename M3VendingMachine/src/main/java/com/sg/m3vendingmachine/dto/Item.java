/*
Item DTO class, populates Vending Machine DTO
 */
package com.sg.m3vendingmachine.dto;

import java.math.BigDecimal;

public class Item {

    /*fields*/
    private String name;
    private int itemID = 0;
    private BigDecimal cost;

    /*ctor*/
    public Item(String name, BigDecimal cost) {
        this.name = name;
        this.itemID = itemID++;
        this.cost = cost;
    }

    /*getters/setter*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
    
    /*read-only*/
    public int getItemID() {
        return itemID;
    }

    //TODO override the test methods

}
