package com.duannd.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCard {

    private String customer;
    private String bank;
    private String account;
    private int limit;
    protected double balance;

    public CreditCard(String customer, String bank, String account, int limit, double balance) {
        this.customer = customer;
        this.bank = bank;
        this.account = account;
        this.limit = limit;
        this.balance = balance;
    }

    public CreditCard(String customer, String bank, String account, int limit) {
        this(customer, bank, account, limit, 0.0);
    }

    public boolean charge(double price) {
        if (this.balance + price > limit)
            return false;
        this.balance += price;
        return true;
    }

    public void makePayment(double amount) {
        this.balance -= amount;
    }

    public static void printSummary(CreditCard card) {
        System.out.println("Customer = " + card.customer);
        System.out.println("Bank = " + card.bank);
        System.out.println("Account = " + card.account);
        System.out.println("Balance = " + card.balance);
        System.out.println("Limit = " + card.limit);
    }

}
