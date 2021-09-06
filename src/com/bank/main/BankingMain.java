package com.bank.main;

import com.bank.accounts.Account;
import com.bank.banking.Address;
import com.bank.banking.Transaction;
import com.bank.customer.Customer;
import com.bank.employee.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class BankingMain {


    public static List<Customer> customersList = new ArrayList<>();
    public static List<Account> accountList = new ArrayList<>();
    public static List<Address> addressList = new ArrayList<>();
    public static List<Employee> employeeList = new ArrayList<>();
    public static List<Transaction> transactionList = new ArrayList<>();

    public static int CustomerId = 100;
    public static int AccountId = 1000;
    public static int AddressId = 10;
    public static int EmployeeId = 1;
    public static int TransactionId = 100;
    public static int CardNumber = 10000;


    public static void main(String[] arg) {


        String functions = "Enter\n1 : login as Employee\n";
        functions = functions + "2 : login as customer\n";
        functions = functions + "3 : create new Employee\n";
        functions = functions + "4 : create a new customer\n";
        functions = functions + "5 : Exit";
        Scanner sc = new Scanner(System.in);
        int opt = 0;
        String st;

        while (true) {
            System.out.println(functions);
            st = sc.nextLine();
            try {
                opt = Integer.parseInt(st);
            } catch (Exception e) {
                System.out.println("Enter numbers between 1 - 4 only");
                opt = 0;
                continue;
            }

            switch (opt) {
                case 1:
                    Operations.isValidEmployee();
                    break;
                case 2:
                    Operations.isValidCustomer();
                    break;
                case 3:
                    Operations.createNewEmployee();
                    break;
                case 4:
                    Operations.createNewCustomer();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Enter number between 1 to 5");
            }
        }
    }
}

