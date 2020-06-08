/*
Change class helper class
 */
package com.sg.m3vendingmachine.dao;

import com.sg.m3vendingmachine.dto.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class Change {

    /*fields*/
//    private final BigDecimal cashIn;
//    private Map<Coins, Integer> changeBack;
    private static final BigDecimal PENNY_VALUE = new BigDecimal("0.01");
    private static final BigDecimal NICKEL_VALUE = new BigDecimal("0.05");
    private static final BigDecimal DIME_VALUE = new BigDecimal("0.10");
    private static final BigDecimal QUARTER_VALUE = new BigDecimal("0.25");

    /*ctor*/
 /*
    public Change(BigDecimal cashIn) {
        changeBack = new HashMap<>();
        this.cashIn = cashIn;
    }
     */

 /*getter/setters*/
 /*
    public Map<Coins, Integer> getChangeBack() {
        return changeBack;
    }

    public void setChangeBack(Map<Coins, Integer> changeBack) {
        this.changeBack = changeBack;
    }
    /*

    /*read-only*/
 /*
    public BigDecimal getCashIn() {
        return cashIn;
    }
     */

    /*behaviors*/
    /**
     * Figure out how much change to dispense
     *
     * @param cashIn {BigDecimal} cash inputted by user
     * @param buying {Item} the consumable the user intends to buy
     * @return {Map} a HashMap of change in coins to be dispensed to the user
     */
    static public Map<Coins, Integer> calculateChange(Item buying, BigDecimal cashIn) {
        BigDecimal price = buying.getCost();
//        BigDecimal change = this.getCashIn().subtract(price);
        BigDecimal change = cashIn.subtract(price);
        Map<Coins, Integer> changeCoins = new HashMap<>();

        int quarterCt = change.divide(QUARTER_VALUE, 0, RoundingMode.HALF_UP).intValue();
        changeCoins.put(Coins.QUARTERS, quarterCt);
        BigDecimal changeAfterQuarters = change.subtract(QUARTER_VALUE.multiply(new BigDecimal(String.valueOf(quarterCt))));

        int dimeCt = changeAfterQuarters.divide(DIME_VALUE, 0, RoundingMode.HALF_UP).intValue();
        changeCoins.put(Coins.DIMES, dimeCt);
        BigDecimal changeAfterDimes = changeAfterQuarters.subtract(DIME_VALUE.multiply(new BigDecimal(String.valueOf(dimeCt))));

        int nickelCt = changeAfterDimes.divide(NICKEL_VALUE, 0, RoundingMode.HALF_UP).intValue();
        changeCoins.put(Coins.NICKELS, nickelCt);
        BigDecimal changeAfterNickels = changeAfterDimes.subtract(NICKEL_VALUE.multiply(new BigDecimal(String.valueOf(nickelCt))));

        int pennyCt = changeAfterNickels.divide(PENNY_VALUE, 0, RoundingMode.HALF_UP).intValue();
        changeCoins.put(Coins.PENNIES, pennyCt);

//        this.setChangeBack(changeCoins);
        return changeCoins;
    }
}
