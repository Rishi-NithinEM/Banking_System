package com.bank.Card;

import com.bank.accounts.Account;

import java.util.Date;

public abstract class Card {

    protected int cardNo;
    protected int pin;
    protected String userName;
    protected Date dateofOpen;
    protected Date dateofExpire;


    public abstract int getPin();
    public abstract int getCardNo();
    public abstract Account getAccount();
    public abstract int getBalance();

    public abstract void setBalance(int i);
}
