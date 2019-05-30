package com.duannd.test;

import com.duannd.models.CreditCard;

public class CreditCardTest {

    public static void main(String[] args) {
        var wallets = new CreditCard[3];
        wallets[0] = new CreditCard("John Bowman", "California Savings",
                "5391 0375 9387 5309", 5000);
        wallets[1] = new CreditCard("John Bowman", "California Federal",
                "3485 0399 3395 1954", 3500);
        wallets[2] = new CreditCard("John Bowman", "California Finance",
                "5391 0375 9387 5309", 2500, 300);

        for (var val = 0; val <= 16; val++) {
            wallets[0].charge(val * 3);
            wallets[1].charge(val * 2);
            wallets[2].charge(val);
        }

        for (var card : wallets) {
            CreditCard.printSummary(card);
            while (card.getBalance() > 200) {
                card.makePayment(200);
                System.out.println("New balance = " + card.getBalance());
            }
        }
    }

}
