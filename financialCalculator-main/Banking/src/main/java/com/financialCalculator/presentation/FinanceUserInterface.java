package com.cejv416.presentation;

import com.cejv416.business.FinanceCalculator;
import com.cejv416.data.FinanceBean;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class FinanceUserInterface {

    private final FinanceCalculator financeCalculator;
    private final FinanceBean financeBean;
    private final Scanner sc;

    public FinanceUserInterface(FinanceBean financeBean, FinanceCalculator financeCalculator) {
        this.financeBean = financeBean;
        this.financeCalculator = financeCalculator;
        sc = new Scanner(System.in);
    }

    public void perform() {
        char choice;

        do {
            choice = menu();
            System.out.println("Choice = " + choice);
            switch (choice) {
                case 'A' -> {
                    requestLoanPaymentInfo();
                    financeCalculator.calculateLoanPayment();
                    displayLoanResult();
                }
                case 'B' -> {
                    requestSavingsGoalInfo();
                    financeCalculator.calculateSavingsGoal();
                    displaySavingsGoalResult();
                }
                case 'C' -> {
                    requestFutureValueInfo();
                    financeCalculator.calculateFutureValue();
                    displayFutureValueResult();
                }
                case 'D' -> {
                    System.out.println("Thank you for using the Financial Calculator console, the menu prompt has exited.");
                }
                default ->
                    System.out.println("I should never see this");
            }
        } while (choice != 'D');
    }

    private void displayMenuText() {
        System.out.println("Financial Calculator");
        System.out.println("\n");

        System.out.println("A) Loan Calculator");
        System.out.println("B) Savings Goal Calculator");
        System.out.println("C) Future Value of Savings Calculator");
        System.out.println("D) Exit");

        System.out.println("\n");
        System.out.println("Please enter your choice: ");
    }

    private char menu() {
        char choice = 'z';

        do {
            displayMenuText();
            if (sc.hasNext("[a-dA-D]")) {
                choice = sc.next().toUpperCase().charAt(0);
            } else {
                choice = 'z';
            }
            sc.nextLine();
        } while (choice == 'z');

        return choice;
    }

    private void requestLoanPaymentInfo() {
        while (true) {
            try {
                System.out.println("Loan Amount: ");
                BigDecimal pv = sc.nextBigDecimal();
                financeBean.setPv(pv);
                break;

            } catch (Exception e) {
                System.out.println("Please enter a valid numerical input. Try again");
                sc.next();
            }
        }

        while (true) {
            try {
                System.out.println("Annual Interest Rate: ");
                double rate = sc.nextDouble();
                financeBean.setRate(rate);
                break;

            } catch (Exception e) {
                System.out.println("Please enter a valid numerical input. Try again");
                sc.next();
            }
        }

        while (true) {
            try {
                System.out.println("Term in Months: ");
                double N = sc.nextDouble();
                financeBean.setN(N);
                break;

            } catch (Exception e) {
                System.out.println("Please enter a valid numerical input. Try again");
                sc.next();
            }
        }
    }

    private void requestSavingsGoalInfo() {
        while (true) {
            while (true) {
                try {
                    System.out.println("Regular Payment Per Period: ");
                    BigDecimal fv = sc.nextBigDecimal();
                    financeBean.setFv(fv);
                    break;

                } catch (Exception e) {
                    System.out.println("Please enter a valid numerical input. Try again");
                    sc.next();
                }
            }

            try {
                System.out.println("Interest Rate Per Period: ");
                double rate = sc.nextDouble();
                financeBean.setRate(rate);
                break;

            } catch (Exception e) {
                System.out.println("Please enter a valid numerical input. Try again");
                sc.next();
            }
        }

        while (true) {
            try {
                System.out.println("Number of Periods: ");
                double N = sc.nextDouble();
                financeBean.setN(N);
                break;

            } catch (Exception e) {
                System.out.println("Please enter a valid numerical input. Try again");
                sc.next();
            }
        }
    }

    private void requestFutureValueInfo() {
        while (true) {
            try {
                System.out.println("Future Value: ");
                BigDecimal fv = sc.nextBigDecimal();
                financeBean.setFv(fv);
                break;

            } catch (Exception e) {
                System.out.println("Please enter a valid numerical input. Try again");
                sc.next();
            }
        }

        while (true) {
            try {
                System.out.println("Interest Rate Per Period: ");
                double rate = sc.nextDouble();
                financeBean.setRate(rate);
                break;

            } catch (Exception e) {
                System.out.println("Please enter a valid numerical input. Try again");
                sc.next();
            }
        }

        while (true) {
            try {
                System.out.println("Number of Periods: ");
                double N = sc.nextDouble();
                financeBean.setN(N);
                break;

            } catch (Exception e) {
                System.out.println("Please enter a valid numerical input. Try again");
                sc.next();
            }
        }
    }

    private void displayLoanResult() {

        NumberFormat usdCostFormat = NumberFormat.getCurrencyInstance(Locale.US);
        usdCostFormat.setMinimumFractionDigits(1);
        usdCostFormat.setMaximumFractionDigits(2);
        System.out.println(usdCostFormat.format(financeBean.getPmt()));
    }

    private void displaySavingsGoalResult() {

        NumberFormat usdCostFormat = NumberFormat.getCurrencyInstance(Locale.US);
        usdCostFormat.setMinimumFractionDigits(1);
        usdCostFormat.setMaximumFractionDigits(2);
        System.out.println(usdCostFormat.format(financeBean.getPmt()));
    }

    private void displayFutureValueResult() {

        NumberFormat usdCostFormat = NumberFormat.getCurrencyInstance(Locale.US);
        usdCostFormat.setMinimumFractionDigits(1);
        usdCostFormat.setMaximumFractionDigits(2);
        System.out.println(usdCostFormat.format(financeBean.getPmt()));
    }
}
