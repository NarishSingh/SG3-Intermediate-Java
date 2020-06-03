package com.sg.m3interestcalcrefactored;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Interest {

    /*fields*/
    private BigDecimal investment;
    private final BigDecimal annual;
    private final int term;
    static final private BigDecimal PERCENT_DIV = new BigDecimal("100").setScale(2, RoundingMode.HALF_UP);
    static final private BigDecimal QUARTERS = new BigDecimal("4").setScale(2, RoundingMode.HALF_UP);
    static final private BigDecimal MONTHS = new BigDecimal("12").setScale(2, RoundingMode.HALF_UP);
    static final private BigDecimal DAYS = new BigDecimal("365").setScale(2, RoundingMode.HALF_UP);

    /*ctor*/
    public Interest(BigDecimal investment, BigDecimal annual, int term) {
        this.investment = investment;
        this.annual = annual.divide(PERCENT_DIV, 2, RoundingMode.HALF_UP); //convert from % to decimal form
        this.term = term;
    }

    /*getter/setter*/
    public BigDecimal getInvestment() {
        return investment;
    }

    public void setInvestment(BigDecimal investment) {
        this.investment = investment;
    }

    /*read-only*/
    public BigDecimal getAnnual() {
        return annual;
    }

    public int getTerm() {
        return term;
    }

    /*behaviors*/
    /**
     * calculate yearly interest
     *
     * @return {BigDecimal} interest earned per year
     */
    public BigDecimal calcYearlyIntr() {
        return getInvestment().multiply(getAnnual());
    }

    /**
     * calculate quarterly interest
     *
     * @return {BigDecimal} interest earned every 3 months or 1 quarter
     */
    public BigDecimal calcQuarterlyIntr() {
        BigDecimal quarterlyRate = getAnnual().divide(QUARTERS, 2, RoundingMode.HALF_UP);
        return getInvestment().multiply(quarterlyRate);
    }

    /**
     * calculate monthly interest
     *
     * @return {BigDecimal} interest earned per month
     */
    public BigDecimal calcMonthlyIntr() {
        BigDecimal monthlyRate = getAnnual().divide(MONTHS, 2, RoundingMode.HALF_UP);
        return getInvestment().multiply(monthlyRate);
    }

    /**
     * calculate daily interest
     *
     * @return {BigDecimal} interest earned daily
     */
    public BigDecimal calcDailyIntr() {
        BigDecimal dailyRate = getAnnual().divide(DAYS, 2, RoundingMode.HALF_UP);
        return getInvestment().multiply(dailyRate);
    }

    /**
     * calculate principle at end of year
     *
     * @return {BigDecimal} sum of initial investment with interest accumulated
     *         all year
     */
    public BigDecimal yearEndPrinciple() {
        BigDecimal yearEndPrinciple = getInvestment().add(this.calcYearlyIntr());
        this.setInvestment(yearEndPrinciple);
        return yearEndPrinciple;
    }
}
