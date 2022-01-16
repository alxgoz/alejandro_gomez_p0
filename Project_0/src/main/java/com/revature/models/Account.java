package com.revature.models;

public class Account {

    private int id;
    private String fName;
    private String lName;
    private double balance;
    private boolean available;
    private String pw;



    // No-Arg Constructor
    public Account() {
    }

    // Full-Arg Constructor
    public Account(int id, String fName, String lName, double balance, boolean available, String pw) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.balance = balance;
        this.available = available;
        this.pw = pw;
    }

    // ID-less Constructor
    public Account(String fName, String lName ,double balance, boolean available, String pw) {
        this.fName = fName;
        this.lName = lName;
        this.balance = balance;
        this.available = available;
        this.pw = pw;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", first name='" + fName + '\'' +
                ", last name='" + lName + '\'' +
                ", balance=" + balance +
                ", available=" + available +
                ", password=" + pw +
                '}';
    }
}
