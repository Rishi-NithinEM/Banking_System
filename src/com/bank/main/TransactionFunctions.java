package com.bank.main;

import com.bank.accounts.Account;
import com.bank.banking.Transaction;
import com.bank.customer.Customer;

import java.util.*;

public class TransactionFunctions {


    public void deposit(Customer cust, Transaction tr) {
        Scanner sc = new Scanner(System.in);
        tr.setCustomerId(cust.getCustomerID());
        System.out.println("Account no");
        int accNo = Integer.parseInt(sc.nextLine());
        Account acc = checkAccountNo(accNo, cust);
        if (acc != null) {
            tr.setSenderAccNo(accNo);
            System.out.println("Enter Pin :");
            int pin = Integer.parseInt(sc.nextLine());
            if (acc.getPin() == pin) {
                System.out.println("Enter transaction amt");
                int amt = Integer.parseInt(sc.nextLine());
                if (amt < 1) {
                    System.out.println("Invalid Amount");
                } else {
                    tr.setTransactionAmt(amt);
                    acc.setBalance(acc.getBalance() + amt);
                    tr.setCurrentBalance(acc.getBalance());
                    tr.setTransactionID(BankingMain.TransactionId++);
                    tr.setTranactionTime(new Date());
                    BankingMain.transactionList.add(tr);
                    Operations.printTransaction(tr);
                }
            } else {
                System.out.println("Wrong Pin");
            }
        } else
            return;
    }

    public void withdraw(Customer cust, Transaction tr) {
        Scanner sc = new Scanner(System.in);
        tr.setCustomerId(cust.getCustomerID());
        System.out.println("Account no");
        int accNo = Integer.parseInt(sc.nextLine());
        Account acc = checkAccountNo(accNo, cust);
        if (acc != null) {
            tr.setSenderAccNo(accNo);
            System.out.println("Enter Pin :");
            int pin = Integer.parseInt(sc.nextLine());
            if (acc.getPin() == pin) {
                System.out.println("Enter transaction amt");
                int amt = Integer.parseInt(sc.nextLine());
                if (amt < 1) {
                    System.out.println("Invalid Amount");
                } else {
                    if (acc.getBalance() - amt >= 0) {
                        tr.setTransactionAmt(amt);
                        acc.setBalance(acc.getBalance() - amt);
                        tr.setCurrentBalance(acc.getBalance());
                        tr.setTransactionID(BankingMain.TransactionId++);
                        tr.setTranactionTime(new Date());
                        BankingMain.transactionList.add(tr);
                        Operations.printTransaction(tr);
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

    public void transfer(Customer cust, Transaction tr) {
        Scanner sc = new Scanner(System.in);
        tr.setCustomerId(cust.getCustomerID());
        System.out.println("Sender Account no");
        int accNo = Integer.parseInt(sc.nextLine());
        Account acc = checkAccountNo(accNo, cust);
        if (acc != null) {
            tr.setSenderAccNo(accNo);
            System.out.println("Enter Pin :");
            int pin = Integer.parseInt(sc.nextLine());
            if (acc.getPin() == pin) {
                System.out.println("Receiver Account no");
                int raccNo = Integer.parseInt(sc.nextLine());
                Account racc = checkAccountNo(raccNo);
                if (racc != null) {
                    tr.setReceiverAccNo(raccNo);
                    System.out.println("Enter transaction amt");
                    int amt = Integer.parseInt(sc.nextLine());

                    if (amt < 1) {
                        System.out.println("Invalid Amount");
                    } else {
                        if (acc.getBalance() - amt >= 0) {
                            tr.setTransactionAmt(amt);
                            acc.setBalance(acc.getBalance() - amt);
                            racc.setBalance(racc.getBalance() + amt);
                            tr.setCurrentBalance(acc.getBalance());
                            tr.setTransactionID(BankingMain.TransactionId++);
                            tr.setTranactionTime(new Date());
                            BankingMain.transactionList.add(tr);
                            Operations.printTransaction(tr);
                        } else {
                            System.out.println("Sorry transfer amount exceeds the balance");
                        }

                    }
                }
            } else {
                System.out.println("Wrong Pin");
            }
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


}
