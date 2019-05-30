package com.duannd.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PredatoryCreditCard extends CreditCard {

    private double apr; // annual percentage rate

    public PredatoryCreditCard(String customer, String bank, String account, int limit,
                               double initBalance, double rate) {
        super(customer, bank, account, limit, initBalance);
        this.apr = rate;
    }

    public void processMonth() {
        if (this.balance > 0) {
            double monthlyFactor = Math.pow(1 + apr, 1.0/12);
            balance *= monthlyFactor;
        }
    }

    @Override
    public boolean charge(double price) {
        boolean isSuccess = super.charge(price);
        if (!isSuccess) {
            balance += 5;
        }
        return isSuccess;
    }
}
