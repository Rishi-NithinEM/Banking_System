package com.bank.customer;

import com.bank.Card.Card;
import com.bank.accounts.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Customer {

    private int customerID;
    private String customerPassword;
    private String firstName;
    private String lastName;
    private long addressID;
    private long phoneNum;
    private String dob;
    private HashMap<Integer, Account> customerAccounts= new HashMap<>();
    private List<Card> creditCards = new ArrayList<>();

    public int getCustomerID() {
        return this.customerID;
    }

    public void setCustomerID(int newCustomerID) {
        this.customerID = newCustomerID;
    }

    public void setPassword(String newPassword) {
        this.customerPassword = newPassword;
    }

    public String getPassword() {
        return this.customerPassword;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }

    public long getAddressID() {
        return this.addressID;
    }

    public void setAddressID(long newAddressID) {
        this.addressID = newAddressID;
    }

    public void setPhoneNumber(long newPhoneNum) {
        this.phoneNum = newPhoneNum;
    }

    public long getPhoneNumber() {
        return this.phoneNum;
    }

    public String getDOB() {
        return this.dob;
    }

    public void setDOB(String newDOB) {
        this.dob = newDOB;
    }

    public void addAccount(Account acc, int accNo){
        customerAccounts.put(accNo, acc);
    }

    public HashMap<Integer, Account> getAccount(){
        return customerAccounts;
    }

    public void addCreditCard(Card c){
        this.creditCards.add(c);
    }

    public List<Card> getCreditCards(){
        return this.creditCards;
    }

    public Customer() {
    }

}
