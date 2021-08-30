package com.bank.banking;

import com.bank.customer.Customer;
import com.bank.accounts.Account;

import java.util.*;

public class Transaction {

    private int customerId;
    private int senderAccNo;
    private int receiverAccNo;
    private long transactionID;
    private int transactionAmt;
    private int currentBalance;
    private String tranactionTime = "current_timestamp";
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

    public void deposit(Customer cust) {
        Scanner sc = new Scanner(System.in);
        setCustomerId(cust.getCustomerID());
        System.out.println("Account no");
        int accNo = Integer.parseInt(sc.nextLine());
        Account acc = checkAccountNo(accNo, cust);
        if (acc != null) {
            this.setSenderAccNo(accNo);
            System.out.println("Enter Pin :");
            int pin = Integer.parseInt(sc.nextLine());
            if (acc.getPin() == pin) {
                System.out.println("Enter transaction amt");
                int amt = Integer.parseInt(sc.nextLine());
                if (amt > 25000) {
                    System.out.println("Transaction limit exceeded");
                } else if (amt < 1) {
                    System.out.println("Invalid Amount");
                } else {
                    this.setTransactionAmt(amt);
                    acc.setBalance(acc.getBalance() + amt);
                    this.setCurrentBalance(acc.getBalance());
                    this.setTransactionID(BankingMain.TransactionId++);
                    this.setTranactionTime(new Date().toString());
                    BankingMain.transactionList.add(this);
                    printTransaction(this);
                }
            } else {
                System.out.println("Wrong Pin");
            }
        } else
            return;
    }

    public void withdraw(Customer cust) {
        Scanner sc = new Scanner(System.in);
        setCustomerId(cust.getCustomerID());
        System.out.println("Account no");
        int accNo = Integer.parseInt(sc.nextLine());
        Account acc = checkAccountNo(accNo, cust);
        if (acc != null) {
            this.setSenderAccNo(accNo);
            System.out.println("Enter Pin :");
            int pin = Integer.parseInt(sc.nextLine());
            if (acc.getPin() == pin) {
                System.out.println("Enter transaction amt");
                int amt = Integer.parseInt(sc.nextLine());
                if (amt > 25000) {
                    System.out.println("Transaction limit exceeded");
                } else if (amt < 1) {
                    System.out.println("Invalid Amount");
                } else {
                    if (acc.getBalance() - amt >= 0) {
                        this.setTransactionAmt(amt);
                        acc.setBalance(acc.getBalance() - amt);
                        this.setCurrentBalance(acc.getBalance());
                        this.setTransactionID(BankingMain.TransactionId++);
                        this.setTranactionTime(new Date().toString());
                        BankingMain.transactionList.add(this);
                        printTransaction(this);
                    } else {
                        System.out.println("Sorry withdraw amount exceeds the balance");
                    }
                }
            } else {
                System.out.println("Wrong Pin");
            }
        } else
            return;
    }

    public void transfer(Customer cust) {
        Scanner sc = new Scanner(System.in);
        setCustomerId(cust.getCustomerID());
        System.out.println("Sender Account no");
        int accNo = Integer.parseInt(sc.nextLine());
        Account acc = checkAccountNo(accNo, cust);
        if (acc != null) {
            this.setSenderAccNo(accNo);
            System.out.println("Enter Pin :");
            int pin = Integer.parseInt(sc.nextLine());
            if (acc.getPin() == pin) {
                System.out.println("Receiver Account no");
                int raccNo = Integer.parseInt(sc.nextLine());
                Account racc = checkAccountNo(raccNo);
                if (racc != null) {
                    this.setReceiverAccNo(raccNo);
                    System.out.println("Enter transaction amt");
                    int amt = Integer.parseInt(sc.nextLine());
                    if (amt > 25000) {
                        System.out.println("Transaction limit exceeded");
                    } else {
                        if (amt < 1) {
                            System.out.println("Invalid Amount");
                        } else {
                            if(acc.getBalance() - amt >= 0) {
                                this.setTransactionAmt(amt);
                                acc.setBalance(acc.getBalance() - amt);
                                racc.setBalance(racc.getBalance() + amt);
                                this.setCurrentBalance(acc.getBalance());
                                this.setTransactionID(BankingMain.TransactionId++);
                                this.setTranactionTime(new Date().toString());
                                BankingMain.transactionList.add(this);
                                printTransaction(this);
                            }else {
                                System.out.println("Sorry transfer amount exceeds the balance");
                            }

                        }
                    }
                }
            }else {
                System.out.println("Wrong Pin");
            }
        } else {
            return;
        }
    }

    public void checkBalance(Customer cust) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Account no");
        int accNo = Integer.parseInt(sc.nextLine());
        Account acc = checkAccountNo(accNo, cust);
        if (acc != null) {
            System.out.println("Enter Pin :");
            int pin = Integer.parseInt(sc.nextLine());
            if (acc.getPin() == pin) {
                System.out.println("Balance : " + acc.getBalance());
            } else {
                System.out.println("Wrong Pin");
            }
        }
    }

    public String getTranactionTime() {
        return this.tranactionTime;
    }

    public void setTranactionTime(String tranactionTime) {
        this.tranactionTime = tranactionTime;
    }

    private static enum TransactionType {
        Deposit,
        WithDraw,
        Transfer;

        private TransactionType() {
        }
    }

    public Account checkAccountNo(int accNo, Customer cust) {

        HashMap<Integer, Account> accountHashMap = cust.getAccount();
        if (accountHashMap != null) {
            for (Map.Entry acc : accountHashMap.entrySet()) {
                if ((int) acc.getKey() == accNo) {
                    return (Account) acc.getValue();
                } else
                    continue;
            }
            System.out.println("Sorry No Account found of that Account Number");
        } else {
            System.out.println("You have no Account");
        }
        return null;
    }

    public Account checkAccountNo(int accNo) {


        Iterator var5 = BankingMain.accountList.iterator();

        while (var5.hasNext()) {
            Account acc = (Account) var5.next();

            if (acc.getAccountNo() == accNo) {
                return acc;
            }
        }

        return null;

    }

    public void printTransaction(Transaction tr) {


        if(tr.getTransactionType().equals("Transfer")){

            System.out.println(tr.getTransactionType()+" Transaction Id : "+tr.getTransactionID());
            System.out.println("Sender Account No : " + tr.getSenderAccNo());
            System.out.println("Transaction Amount :" + tr.getTransactionAmt());
            System.out.println("Receiver Account No : "+tr.getReceiverAccNo());
            System.out.println("Current Balance :" + tr.getCurrentBalance());
            System.out.println("Transaction Time :" + tr.getTranactionTime()+"\n\n");

        }else {

            System.out.println(tr.getTransactionType()+" Transeaction Id : "+tr.getTransactionID());
            System.out.println("Account No : " + tr.getSenderAccNo());
            System.out.println("Transaction Amount :" + tr.getTransactionAmt());
            System.out.println("Current Balance :" + tr.getCurrentBalance());
            System.out.println("Transaction Time :" + tr.getTranactionTime()+"\n\n");
        }

    }

}
