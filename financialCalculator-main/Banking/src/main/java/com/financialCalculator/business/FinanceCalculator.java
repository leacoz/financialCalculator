package com.cejv416.business;

import com.cejv416.data.FinanceBean;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 *
 * @Lab#1
 */
public class FinanceCalculator {

    private final FinanceBean financeBean;

    public FinanceCalculator(FinanceBean financeBean) {
        this.financeBean = financeBean;
    }

    public void calculateLoanPayment() {

        BigDecimal result = financeBean.getPv();
        double tmp = ((financeBean.getRate() / 12.0)) / (1.0 - (Math.pow(1.0 + (financeBean.getRate() / 12.0), -financeBean.getN())));

        financeBean.setPmt(result.multiply(new BigDecimal(tmp)));

    }

    public void calculateFutureValue() {

        BigDecimal result = financeBean.getFv();
        double tmp = ((1.0 - (Math.pow(1.0 + (financeBean.getRate() / 12.0), financeBean.getN()))) / ((financeBean.getRate() / 12.0)));
        financeBean.setPmt(result.multiply(new BigDecimal(tmp)));

    }

    public void calculateSavingsGoal() {

        BigDecimal result = financeBean.getFv();

        double a = 1.0 + (financeBean.getRate() / 12.0);
        double b = Math.pow(a, financeBean.getN());
        double denom = 1.0 - b;
        double num = ((financeBean.getRate() / 12.0));
        BigDecimal tmp = new BigDecimal(num / denom);
        financeBean.setPmt(result.multiply(tmp));

    }

}
