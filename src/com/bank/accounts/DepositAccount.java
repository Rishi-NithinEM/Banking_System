package com.bank.accounts;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DepositAccount extends Account {

    private double interestRate;
    private String depositDate;
    private int termsInMonth;

    public double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public String getDepositDate() {
        return this.depositDate;
    }

    public void setDepositDate(String depositDate) {
        this.depositDate = depositDate;
    }

    public int getTermsInMonth() {
        return this.termsInMonth;
    }

    public void setTermsInMonth(int termsInMonth) {
        this.termsInMonth = termsInMonth;
    }

    public DepositAccount() {
        this.setBalance(0);
        this.setInterestRate(0.45D);
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        this.setDepositDate(sm.format(new Date()).toString());
    }

}
