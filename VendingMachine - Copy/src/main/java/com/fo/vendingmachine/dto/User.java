/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fo.vendingmachine.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author TheFemiFactor
 */
public class User {
    
    private double amount;
    private BigDecimal amountB;

    public BigDecimal getAmountMoney() {
        amountB = BigDecimal.valueOf(this.amount).setScale(2, RoundingMode.HALF_EVEN);
        return amountB;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public BigDecimal getAmountB() {
        return amountB;
    }
    
    public void setAmountB(BigDecimal amountB) {
        this.amountB = amountB;
    }
    
    public double getAmount() {
        return amount;
    }
}
