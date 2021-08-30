package com.bank.accounts;

public class SavingsAccount extends Account {

    private int withdrawLimit;

    public int getWithdrawLimit() {
        return this.withdrawLimit;
    }

    public void setWithdrawLimit(int withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public SavingsAccount() {
        this.setBalance(0);
        this.setWithdrawLimit(25000);
    }

}
