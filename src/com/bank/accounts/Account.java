package com.bank.accounts;

public class Account {

    private int customerID;
    private int accountNo;
    private int balance;
    private int openedEmpId;
    private int pin;
    private Account.AccountType accType;

    public Account() {
    }

    public int getCustomerID() {
        return this.customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getAccountNo() {
        return this.accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccType() {
        return this.accType.toString();
    }

    public void setAccType(int index) {
        this.accType = Account.AccountType.values()[index];
    }

    public int getOpenedEmpId() {
        return this.openedEmpId;
    }

    public void setOpenedEmpId(int openedEmpId) {
        this.openedEmpId = openedEmpId;
    }

    public int getPin() {
        return this.pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    private static enum AccountType {
        Savings,
        Current,
        Deposit;

        private AccountType() {
        }
    }

}
