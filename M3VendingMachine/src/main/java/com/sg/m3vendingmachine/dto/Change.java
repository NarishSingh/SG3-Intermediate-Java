/*
Change class
1 per Vending Machine Obj
 */
package com.sg.m3vendingmachine.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author naris
 */
public class Change {

    /*fields*/
    private BigDecimal totalChange;
    private int pennyCt;
    private int nickelCt;
    private int dimeCt;
    private int quarterCt;
    private static final BigDecimal PENNY_VALUE = new BigDecimal("0.01");
    private static final BigDecimal NICKEL_VALUE = new BigDecimal("0.05");
    private static final BigDecimal DIME_VALUE = new BigDecimal("0.10");
    private static final BigDecimal QUARTER_VALUE = new BigDecimal("0.25");

    /*ctor*/
    public Change(BigDecimal totalChange) {
        this.totalChange = totalChange;
        convertChange();
    }

    /*getter/setters*/
    public BigDecimal getTotalChange() {
        return totalChange;
    }

    public void setTotalChange(BigDecimal totalChange) {
        this.totalChange = totalChange;
    }

    public int getPennyCt() {
        return pennyCt;
    }

    public void setPennyCt(int pennyCt) {
        this.pennyCt = pennyCt;
    }

    public int getNickelCt() {
        return nickelCt;
    }

    public void setNickelCt(int nickelCt) {
        this.nickelCt = nickelCt;
    }

    public int getDimeCt() {
        return dimeCt;
    }

    public void setDimeCt(int dimeCt) {
        this.dimeCt = dimeCt;
    }

    public int getQuarterCt() {
        return quarterCt;
    }

    public void setQuarterCt(int quarterCt) {
        this.quarterCt = quarterCt;
    }

    /*behaviors*/
    /**
     * Figure out how much change is in machine based on total Change
     */
    private void convertChange() {
        BigDecimal changeInMachine = this.getTotalChange();
        
        this.setQuarterCt((changeInMachine.divide(QUARTER_VALUE, 0, RoundingMode.HALF_UP)).intValue());
        changeInMachine = changeInMachine.subtract(BigDecimal.valueOf(getQuarterCt()).multiply(QUARTER_VALUE));
        
        this.setDimeCt(changeInMachine.divide(DIME_VALUE, 0, RoundingMode.HALF_UP).intValue());
        changeInMachine = changeInMachine.subtract(BigDecimal.valueOf(getDimeCt()).multiply(DIME_VALUE));
        
        this.setNickelCt((changeInMachine.divide(NICKEL_VALUE, 0, RoundingMode.HALF_UP)).intValue());
        changeInMachine = changeInMachine.subtract(BigDecimal.valueOf(getNickelCt()).multiply(NICKEL_VALUE));
        
        this.setPennyCt(changeInMachine.divide(PENNY_VALUE, 0, RoundingMode.HALF_UP).intValue());
    }
}
