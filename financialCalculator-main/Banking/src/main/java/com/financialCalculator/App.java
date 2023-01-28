package com.cejv416;

import com.cejv416.presentation.FinanceUserInterface;

import java.math.BigDecimal;

import com.cejv416.business.FinanceCalculator;
import com.cejv416.data.FinanceBean;

/**
 * STEP (2)
 *
 * @Lab#1
 */
public class App {

    private FinanceBean financeBean;
    private FinanceCalculator financeCalculator;
    private FinanceUserInterface financeUserInterface;

    public void perform() {
        financeBean = new FinanceBean();
        financeCalculator = new FinanceCalculator(financeBean);
        financeUserInterface = new FinanceUserInterface(financeBean, financeCalculator);

        financeUserInterface.perform();

//        financeBean.setPv(new BigDecimal(5000.0)); // Loan Calculator formula
//        financeBean.setRate(0.05);
//        financeBean.setN(60.0);
//        financeCalculator.calculateLoanPayment();
//        System.out.println(financeBean.getPmt());
//
//        financeBean.setPmt(new BigDecimal(100.0)); // Future Value of Savings Calculator formula
//        financeBean.setRate(0.05);
//        financeBean.setN(60.0);
//        financeCalculator.calculateFutureValue();
//        System.out.println(financeBean.getFv());
//        
//        financeBean.setFv(new BigDecimal(6800.61)); // Savings Goal Calculator formula
//        financeBean.setRate(0.05);
//        financeBean.setN(60.0);
//        financeCalculator.calculateSavingsGoal();
//        System.out.println(financeBean.getPmt());
    }

    /**
     *
     * @param args
     */
    public static void main(String... args) {
        new App().perform();
    }

}
