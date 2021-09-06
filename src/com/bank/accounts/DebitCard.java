package com.bank.accounts;

import com.bank.Card.Card;

import java.util.Date;

public class DebitCard extends Card {


    private Account acc;
    private int withdrawLimit;

    public DebitCard() {
        this.setWithdrawLimit(40000);
    }

    public int getWithdrawLimit() {
        return this.withdrawLimit;
    }

    public void setWithdrawLimit(int withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    public int getCardNo() {
        return this.cardNo;
    }

    @Override
    public Account getAccount() {
        return this.acc;
    }

    @Override
    public int getBalance() {
        return acc.getBalance();
    }

    @Override
    public void setBalance(int i) {
        acc.setBalance(i);
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }

    public Account getAcc() {
        return this.acc;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getPin() {
        return this.pin;
    }

    public void setUserName(String name){
        this.userName = name;
    }

    public String getUserName(){
        return this.userName;
    }

    public void setDoo(Date doo){
        this.dateofOpen = doo;
    }

    public Date getDoo(){
        return this.dateofOpen;
    }

    public void setDoe(Date doe){
        this.dateofExpire=doe;
    }

    public Date getDoe(){
        return this.dateofExpire;
    }

}
