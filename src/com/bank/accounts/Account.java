package com.bank.accounts;

public class Account {

    private int customerID;
    private int accountNo;
    private int balance;
    private int pin;
    private DebitCard debitCard;
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

    public AccountType getAccType() {
        return this.accType;
    }

    public void setAccType(int index) {
        this.accType = Account.AccountType.values()[index];
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

    public void setDebitCard(DebitCard db) {
        this.debitCard = db;
    }

    public DebitCard getDebitCard() {
        return this.debitCard;
    }

    public static enum AccountType {
        Savings,
        Current,
        Deposit;

        private AccountType() {
        }
    }

}
