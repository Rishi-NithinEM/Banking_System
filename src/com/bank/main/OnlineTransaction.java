package com.bank.main;

import com.bank.Card.Card;
import com.bank.accounts.Account;
import com.bank.accounts.DebitCard;
import com.bank.banking.Transaction;
import com.bank.customer.Customer;

import java.util.*;

public class OnlineTransaction {

    public void deposit(Customer cust, Transaction tr) {
        Scanner sc = new Scanner(System.in);
        tr.setCustomerId(cust.getCustomerID());
        System.out.println("Card no");
        int accNo = Integer.parseInt(sc.nextLine());
        Card card = checkCardNo(accNo, cust);
        if (card != null) {
            tr.setSenderAccNo(accNo);
            System.out.println("Enter Pin :");
            int pin = Integer.parseInt(sc.nextLine());
            if (card.getPin() == pin) {
                if (card instanceof DebitCard) {

                    System.out.println("Enter transaction amt");
                    int amt = Integer.parseInt(sc.nextLine());
                    if (amt < 1) {
                        System.out.println("Invalid Amount");
                    } else {

                        tr.setTransactionAmt(amt);
                        card.setBalance(card.getBalance() + amt);
                        tr.setCurrentBalance(card.getBalance());
                        tr.setTransactionID(BankingMain.TransactionId++);
                        tr.setTranactionTime(new Date());
                        BankingMain.transactionList.add(tr);
                        Operations.printTransaction(tr);

                    }
                } else {
                    if(card.getBalance() - 100000 < 0) {
                        int amt= 100000 - card.getBalance();
                        System.out.println("Amount to be deposited "+amt);

                        tr.setTransactionAmt(amt);
                        card.setBalance(card.getBalance() + amt);
                        tr.setCurrentBalance(card.getBalance());
                        tr.setTransactionID(BankingMain.TransactionId++);
                        tr.setTranactionTime(new Date());
                        BankingMain.transactionList.add(tr);
                        Operations.printTransaction(tr);

                    } else {
                        System.out.println("Your card it full");
                        return;
                    }
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
        System.out.println("Card no");
        int accNo = Integer.parseInt(sc.nextLine());
        Card card = checkCardNo(accNo, cust);
        if (card != null) {
            tr.setSenderAccNo(accNo);
            System.out.println("Enter Pin :");
            int pin = Integer.parseInt(sc.nextLine());
            if (card.getPin() == pin) {
                System.out.println("Enter transaction amt");
                int amt = Integer.parseInt(sc.nextLine());
                if (card instanceof DebitCard) {
                    if(card.getBalance() < amt && ((DebitCard) card).getWithdrawLimit() < amt){
                        System.out.println("Transaction Invalid exceeds the limit or exceeds the balance");
                        return;
                    }
                    else if (amt < 1) {
                        System.out.println("Invalid Amount");
                        return;
                    } else {

                        tr.setTransactionAmt(amt);
                        card.setBalance(card.getBalance() - amt);
                        tr.setCurrentBalance(card.getBalance());
                        tr.setTransactionID(BankingMain.TransactionId++);
                        tr.setTranactionTime(new Date());
                        BankingMain.transactionList.add(tr);
                        Operations.printTransaction(tr);

                    }
                } else {
                    if(card.getBalance() - amt >=0 ) {

                        tr.setTransactionAmt(amt);
                        card.setBalance(card.getBalance() - amt);
                        tr.setCurrentBalance(card.getBalance());
                        tr.setTransactionID(BankingMain.TransactionId++);
                        tr.setTranactionTime(new Date());
                        BankingMain.transactionList.add(tr);
                        Operations.printTransaction(tr);

                    } else {
                        System.out.println("Your withdraw limit is full");
                        return;
                    }
                }
            } else {
                System.out.println("Wrong Pin");
            }
        } else
            return;
    }

    public void checkBalance(Customer cust) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Account no");
        int accNo = Integer.parseInt(sc.nextLine());
        Card card = checkCardNo(accNo, cust);
        if (card != null) {
            System.out.println("Enter Pin :");
            int pin = Integer.parseInt(sc.nextLine());
            if (card.getPin() == pin) {
                System.out.println("Balance : " + card.getBalance());
            } else {
                System.out.println("Wrong Pin");
            }
        }
    }


    public Card checkCardNo(int accNo, Customer cust) {

        List<Card> cards = cust.getCreditCards();
        if (cards != null) {

            Iterator<Card> itr = cards.listIterator();

            while (itr.hasNext()) {

                Card c = itr.next();

                if (c.getCardNo() == accNo) {
                    return c;
                }
            }
        }

        HashMap<Integer, Account> accountHashMap = cust.getAccount();
        if (accountHashMap != null) {
            for (Map.Entry acc : accountHashMap.entrySet()) {

                Account ac = (Account) acc;
                if (ac.getDebitCard().getCardNo() == accNo) {
                    return ac.getDebitCard();
                }

            }
        }

        System.out.println("You have no Account");
        return null;
    }

}
