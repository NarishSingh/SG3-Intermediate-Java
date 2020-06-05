/*
Vending Machine DTO class

maybe later consider adding
//    int gumCt;
//    int nutCt;
//    int cookieCt;
//    int juiceCt;
//    int snackBarCt;
 */
package com.sg.m3vendingmachine.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author naris
 */
public class VendingMachine extends Change {

    /*fields*/
    private List<Item> inventory = new ArrayList<>();
    private Change cash;
    //use stream .count on their .getType() to set below?
    private int candyCt;
    private int chocolateCt;
    private int sodaCt;
    private int waterCt;

    /*ctor*/
    public VendingMachine(BigDecimal totalChange) {
        super(totalChange);

        this.candyCt = 0;
        this.chocolateCt = 0;
        this.sodaCt = 0;
        this.waterCt = 0;
    }

    /*getter/setters*/
    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public Change getCash() {
        return cash;
    }

    public void setCash(Change cash) {
        this.cash = cash;
    }

    public int getCandyCt() {
        return candyCt;
    }

    public void setCandyCt(int candyCt) {
        this.candyCt = candyCt;
    }

    public int getChocolateCt() {
        return chocolateCt;
    }

    public void setChocolateCt(int chocolateCt) {
        this.chocolateCt = chocolateCt;
    }

    public int getSodaCt() {
        return sodaCt;
    }

    public void setSodaCt(int sodaCt) {
        this.sodaCt = sodaCt;
    }

    public int getWaterCt() {
        return waterCt;
    }

    public void setWaterCt(int waterCt) {
        this.waterCt = waterCt;
    }
    
}
