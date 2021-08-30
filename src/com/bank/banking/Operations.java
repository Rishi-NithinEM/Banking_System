package com.bank.banking;

import com.bank.accounts.*;
import com.bank.customer.Customer;
import com.bank.employee.Employee;
import jdk.nashorn.internal.objects.annotations.Where;
import sun.awt.X11.XSystemTrayPeer;

import java.util.*;

public class Operations {

    public static Customer createNewCustomer() {
        Scanner sc = new Scanner(System.in);
        Customer newCustomer = new Customer();
        System.out.println("Enter the following details\nFirst Name : ");
        newCustomer.setFirstName(sc.nextLine());
        System.out.println("Last Name : ");
        newCustomer.setLastName(sc.nextLine());
        System.out.println("Phone number : ");
        newCustomer.setPhoneNumber(Long.parseLong(sc.nextLine()));
        System.out.println("Date of birth as yyyy-mm-dd");
        newCustomer.setDOB(sc.nextLine());
        System.out.println("Enter password");
        newCustomer.setPassword(sc.nextLine());
        newCustomer.setCustomerID(++BankingMain.CustomerId);
        newCustomer.setAddressID(createNewAddress().getAddressID());
        System.out.println("Your CustomerId is : " + newCustomer.getCustomerID());
        return newCustomer;
    }

    public static void isValidCustomer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter customer id");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Enter customer password");
        String password = sc.nextLine();
        Iterator itr = BankingMain.customersList.iterator();
        while (itr.hasNext()) {
            Customer cust = (Customer) itr.next();
            if (cust.getCustomerID() == id && cust.getPassword().equals(password)) {
                System.out.println(cust.getFirstName() + " " + cust.getLastName() + "'s account");
                performTransaction(cust);
                return;
            }
        }
        System.out.println("Invalid credentials or Account not found");
        return;
    }


    public static Employee createNewEmployee() {
        Scanner sc = new Scanner(System.in);
        String[] empTypes = new String[]{"Manager", "Accountant", "Cashier"};
        Employee ee = new Employee();
        System.out.println("Enter the following details to create an employee");
        System.out.println("Enter the name");
        ee.setEmployeeName(sc.nextLine());
        System.out.println("Enter the employee type");

        int typeNum;
        for (typeNum = 0; typeNum < empTypes.length; ++typeNum) {
            System.out.println(typeNum + 1 + " for " + empTypes[typeNum]);
        }

        typeNum = Integer.parseInt(sc.nextLine());
        ee.setEmployeeType(typeNum - 1);
        System.out.println("Enter Phone number");
        ee.setPhoneNum(Long.parseLong(sc.nextLine()));
        System.out.println("Enter the date of birth as yyyy-mm-dd");
        ee.setDob(sc.nextLine());
        System.out.println("Enter the manager ID if exists else any char");
        String temp = sc.nextLine();

        try {
            ee.setManagerID(Integer.parseInt(temp));
        } catch (NumberFormatException var6) {
            ee.setManagerID(-1);
            temp = null;
        }

        System.out.println("Enter the salary");
        ee.setSalary(Integer.parseInt(sc.nextLine()));
        ee.setEmployeeAddressID(createNewAddress().getAddressID());
        ee.setEmployeeID(BankingMain.EmployeeId++);
        System.out.println("Your Employee ID : " + ee.getEmployeeID());
        BankingMain.employeeList.add(ee);
        return ee;
    }

    public static boolean isValidEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee ID");
        int empID = Integer.parseInt(sc.nextLine());
        System.out.println("Enter Emplyee Name");
        String empName = sc.nextLine();

        Iterator itr = BankingMain.employeeList.iterator();
        while (itr.hasNext()) {
            Employee ee = (Employee) itr.next();
            if (ee.getEmployeeID() == empID && ee.getEmployeeName().equals(empName)) {
                System.out.println(ee.getEmployeeName() + "'s Employee account");
                employeeFunctions();
                return true;
            }
        }
        System.out.println("Invalid id or user name");
        return false;

    }


    public static Address createNewAddress() {
        Scanner sc = new Scanner(System.in);
        Address newAddress = new Address();
        System.out.println("Enter the following details. flat no :");
        newAddress.setBuildingNo(Integer.parseInt(sc.nextLine()));
        System.out.println("Area or Street name");
        newAddress.setArea(sc.nextLine());
        System.out.println("City");
        newAddress.setCity(sc.nextLine());
        System.out.println("State");
        newAddress.setState(sc.nextLine());
        System.out.println("Postal code");
        newAddress.setPincode(sc.nextLong());
        newAddress.setAddressID(++BankingMain.AddressId);
        System.out.println("Your AddressId : " + newAddress.getAddressID());
        BankingMain.addressList.add(newAddress);
        return newAddress;
    }


    public static void employeeFunctions() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter\n1 : to view all accounts");
            System.out.println("2 : to view all savings account");
            System.out.println("3 : to view all current account");
            System.out.println("4 : to create an employee");
            System.out.println("5 : to view all Transactions");
            System.out.println(" exit");
            String accType = "";
            int opt = Integer.parseInt(sc.nextLine());
            switch (opt) {
                case 1:
                    accType = "all";
                    break;
                case 2:
                    accType = "Savings";
                    break;
                case 3:
                    accType = "Current";
                    break;
                case 4:
                    createNewEmployee();
                    break;
                case 5: {
                    if (BankingMain.transactionList.isEmpty()) {
                        System.out.println("No Transactions made yet");
                    } else {
                        Iterator var5 = BankingMain.transactionList.iterator();


                        while (var5.hasNext()) {
                            Transaction tr = (Transaction) var5.next();
                            tr.printTransaction(tr);
                        }
                    }
                }
                default:
                    return;
            }


            if (accType != "") {
                List<Account> allAccs = getAllAccounts(accType);
                Iterator var5 = allAccs.iterator();

                while (var5.hasNext()) {
                    Account i = (Account) var5.next();
                    System.out.println(i.getCustomerID() + " " + i.getAccountNo());
                }
            }
        }
    }

    private static List<Account> getAllAccounts(String accType) {


        List<Account> acc = new ArrayList<>();
        boolean b = false;

        Iterator var5 = BankingMain.accountList.iterator();

        while (var5.hasNext()) {
            Account i = (Account) var5.next();
            if (accType != "all") {
                if (i.getAccType().equals(accType)) {
                    b = true;
                    acc.add(i);
                }
            } else {
                b = true;
                acc.add(i);
            }

        }
        if (b == false) {
            System.out.println("No Accounts found of Type " + accType);
        }
        return acc;

    }

    public static Account createNewAccount(Customer cust) {
        Scanner sc = new Scanner(System.in);
        String[] accTypes = new String[]{"Savings", "Current", "Deposit"};
        System.out.println("Account type");

        int temp;
        for (temp = 0; temp < accTypes.length; ++temp) {
            System.out.println(temp + 1 + " " + accTypes[temp]);
        }

        temp = Integer.parseInt(sc.nextLine());
        Account ac;
        switch (temp) {
            case 1:
                ac = new SavingsAccount();
                break;
            case 2:
                ac = new CurrentAccount();
                break;
            case 3:
                ac = new DepositAccount();
                break;
            default:
                return null;
        }

        ac.setAccType(temp - 1);
        System.out.println("Opened Employee ID");
        ac.setOpenedEmpId(Integer.parseInt(sc.nextLine()));
        if (ac instanceof DepositAccount) {
            System.out.println("Enter the deposit period in months");
            ((DepositAccount) ac).setTermsInMonth(Integer.parseInt(sc.nextLine()));
        }
        ac.setCustomerID(cust.getCustomerID());
        System.out.println("PIN <= 9999");

        while (true) {
            ac.setPin(Integer.parseInt(sc.nextLine()));
            if (ac.getPin() <= 9999)
                break;
        }
        ac.setAccountNo(++BankingMain.AccountId);
        cust.addAccount(ac, ac.getAccountNo());
        BankingMain.accountList.add(ac);
        System.out.println("Your Account Number :" + ac.getAccountNo());
        return ac;
    }

    public static void performTransaction(Customer cust) {
        Scanner sc = new Scanner(System.in);
        while (true) {

            Transaction tr = new Transaction();
            String[] types = new String[]{"Deposit", "Withdraw", "Transfer", "Balance enqiry"};
            System.out.println("Enter transaction type");

            int ch;
            for (ch = 0; ch < types.length; ++ch) {
                System.out.println(ch + 1 + " " + types[ch]);
            }
            System.out.println("5 Check Transactions\n6 Create new Account\n7 Exit");

            ch = Integer.parseInt(sc.nextLine());
            if (ch >= 0 && ch <= 3) {
                tr.setTransactionType(ch - 1);
            }

            switch (ch) {
                case 1:
                    tr.deposit(cust);
                    break;
                case 2:
                    tr.withdraw(cust);
                    break;
                case 3:
                    tr.transfer(cust);
                    break;
                case 4:
                    tr.checkBalance(cust);
                    break;
                case 5:
                    viewTransactions(cust);
                    break;
                case 6:
                    createNewAccount(cust);
                    break;
                case 7:
                    return;
            }
        }
    }

    public static void viewTransactions(Customer cust) {


        if (BankingMain.transactionList.isEmpty()) {
            System.out.println("No Transactions made4 Yet");
        }

        Iterator var5 = BankingMain.transactionList.iterator();


        while (var5.hasNext()) {

            Transaction tr = (Transaction) var5.next();

            if (tr.getCustomerId() == cust.getCustomerID()) {
                tr.printTransaction(tr);
            }

        }
    }
}

