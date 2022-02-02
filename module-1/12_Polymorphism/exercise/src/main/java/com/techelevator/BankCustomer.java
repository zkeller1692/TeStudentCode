package com.techelevator;

import java.util.ArrayList;
import java.util.List;


public class BankCustomer{
    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable> accounts = new ArrayList<>();



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Accountable[] getAccounts() {
        Accountable[] arrOfAccounts = new Accountable[this.accounts.size()];
        for (int i = 0; i < accounts.size(); i++) {
            arrOfAccounts[i] = this.accounts.get(i);
        }
        return arrOfAccounts;
    }


    public void addAccount(Accountable newAccount) {
        accounts.add(newAccount);
    }


    public boolean isVip(){
        int totalBalanceSum = 0;
        for(Accountable account : accounts)
            totalBalanceSum += account.getBalance();
        if (totalBalanceSum >= 25000){
            return true;
        }
        return false;
    }
}
