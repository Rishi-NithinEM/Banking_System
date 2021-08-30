package com.bank.banking;

import com.bank.accounts.Account;
import com.bank.customer.Customer;
import com.bank.employee.Employee;

import java.util.ArrayList;
import java.util.Iterator;
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


    public static void main(String[] arg) {


        String functions = "Enter\n1 : login as Employee\n";
        functions = functions + "2 : login as customer\n";
        functions = functions + "3 : create new Employee\n";
        functions = functions + "4 : create a new customer";
        Scanner sc = new Scanner(System.in);
        int opt;


        try {
            while (true) {
                System.out.println(functions);
                opt = sc.nextInt();
                switch (opt) {
                    case 1:
                        if(employeeList.isEmpty()){
                            System.out.println("Sorry there are no Employee , Create a new One");
                            employeeList.add(Operations.createNewEmployee());
                        }else{
                            Operations.isValidEmployee();
                        }
                        break;
                    case 2:
                        if(customersList.isEmpty()){
                            System.out.println("Sorry there are no Customer, Create a new One");
                            customersList.add(Operations.createNewCustomer());
                        }else{
                            Operations.isValidCustomer();
                        }
                        break;
                    case 3:
                        employeeList.add(Operations.createNewEmployee());
                        break;
                    case 4:
                        customersList.add(Operations.createNewCustomer());
                        break;
                }
            }
        } catch (Exception var5) {
            var5.printStackTrace();
        }
    }
}
