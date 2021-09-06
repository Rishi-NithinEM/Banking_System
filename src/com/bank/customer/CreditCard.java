package com.bank.customer;

import com.bank.Card.Card;
import com.bank.accounts.Account;

import java.util.Date;

public class CreditCard extends Card {

    private Customer cust;
    private int creditScore;
    private int balance = 100000;


    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    public int getCardNo() {
        return this.cardNo;
    }

    @Override
    public Account getAccount() {
        return null;
    }

    public void setAcc(Customer acc) {
        this.cust = acc;
    }

    public Customer getAcc() {
        return this.cust;
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

    public void updateBalance(int val){
        this.balance -= val;
    }

    public int getBalance(){
        return this.balance;
    }

    @Override
    public void setBalance(int i) {
        this.balance -= i;
    }

    public void addCreditscore(int val){
        this.creditScore += val;
    }
}
