package com.cejv416.data;

import java.math.BigDecimal;

/**
 * STEP (1)
 *
 * @Lab#1
 */
public class FinanceBean {

    private BigDecimal pmt;
    private BigDecimal pv;
    private double rate;
    private double n;
    private BigDecimal fv;

    public BigDecimal getPmt() {
        return pmt;
    }

    public void setPmt(BigDecimal pmt) {
        this.pmt = pmt;
    }

    public BigDecimal getPv() {
        return pv;
    }

    public void setPv(BigDecimal pv) {
        this.pv = pv;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getN() {
        return n;
    }

    public void setN(double n) {
        this.n = n;
    }

    public BigDecimal getFv() {
        return fv;
    }

    public void setFv(BigDecimal fv) {
        this.fv = fv;
    }

}
