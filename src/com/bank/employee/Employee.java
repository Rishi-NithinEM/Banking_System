package com.bank.employee;

public class Employee {

    private int empID;
    private String empName;
    private long phoneNum;
    private String dob;
    private int managerID;
    private int salary;
    private long addressID;
    private Employee.EmployeeType empType;

    public int getEmployeeID() {
        return this.empID;
    }

    public void setEmployeeID(int empID) {
        this.empID = empID;
    }

    public String getEmployeeName() {
        return this.empName;
    }

    public void setEmployeeName(String empName) {
        this.empName = empName;
    }

    public String getEmployeeType() {
        return this.empType.toString();
    }

    public void setEmployeeType(String val) {
        this.empType = Employee.EmployeeType.valueOf(val);
    }

    public void setEmployeeType(int index) {
        this.empType = Employee.EmployeeType.values()[index];
    }

    public long getPhoneNum() {
        return this.phoneNum;
    }

    public void setPhoneNum(long phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getDob() {
        return this.dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getManagerID() {
        return this.managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public long getEmployeeAddressID() {
        return this.addressID;
    }

    public void setEmployeeAddressID(long newEmployeeID) {
        this.addressID = newEmployeeID;
    }

    public Employee() {
    }

    private static enum EmployeeType {
        Manager,
        Accountant,
        Cashier;

        private EmployeeType() {
        }
    }

}
