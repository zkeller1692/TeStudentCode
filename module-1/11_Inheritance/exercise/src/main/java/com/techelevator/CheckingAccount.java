package com.techelevator;

public class CheckingAccount extends BankAccount{

    public CheckingAccount(String accountHolderName, String accountNumber){
        super(accountHolderName, accountNumber);
    }
    public CheckingAccount(String accountHolderName, String accountNumber, int balance){
    super(accountHolderName, accountNumber, balance);
    }

    @Override
    public int withdraw(int amountToWithdraw){
    int newBal = super.getBalance()-amountToWithdraw;
    if (newBal < -100){
        return super.getBalance();
    }
    if (newBal >= -100 && newBal <=0){
        return super.withdraw(amountToWithdraw + 10);
    }
    return super.withdraw(amountToWithdraw);
    }

}
