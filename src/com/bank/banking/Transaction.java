package com.bank.banking;

import com.bank.customer.Customer;
import com.bank.accounts.Account;
import com.bank.main.BankingMain;
import com.bank.main.Operations;

import java.util.*;

public class Transaction {

    private int customerId;
    private int senderAccNo;
    private int receiverAccNo;
    private long transactionID;
    private int transactionAmt;
    private int currentBalance;
    private Date tranactionTime ;
    private Transaction.TransactionType transactionType;

    public int getSenderAccNo() {
        return this.senderAccNo;
    }

    public void setSenderAccNo(int senderAccNo) {
        this.senderAccNo = senderAccNo;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public int getReceiverAccNo() {
        return this.receiverAccNo;
    }

    public void setReceiverAccNo(int receiverAccNo) {
        this.receiverAccNo = receiverAccNo;
    }

    public long getTransactionID() {
        return this.transactionID;
    }

    public void setTransactionID(long transactionID) {
        this.transactionID = transactionID;
    }

    public int getTransactionAmt() {
        return this.transactionAmt;
    }

    public void setTransactionAmt(int transactionAmt) {
        this.transactionAmt = transactionAmt;
    }

    public String getTransactionType() {
        return this.transactionType == null ? null : this.transactionType.toString();
    }

    public void setTransactionType(int index) {
        this.transactionType = Transaction.TransactionType.values()[index];
    }

    public int getCurrentBalance() {
        return this.currentBalance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Transaction() {
    }


    public Date getTranactionTime() { return this.tranactionTime; }

    public void setTranactionTime(Date tranactionTime) { this.tranactionTime = tranactionTime; }

    private static enum TransactionType {
        Deposit,
        WithDraw,
        Transfer;

    }




}
