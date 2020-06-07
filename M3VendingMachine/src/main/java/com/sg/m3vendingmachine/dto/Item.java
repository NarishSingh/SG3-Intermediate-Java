/*
Item DTO class, populates Vending Machine DTO
 */
package com.sg.m3vendingmachine.dto;

import java.math.BigDecimal;

public class Item {

    /*fields*/
//    private final ItemType type;
    private String name;
    private BigDecimal cost;

    /*ctor*/
    public Item(String name, BigDecimal cost) {
        this.name = name;
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

}
