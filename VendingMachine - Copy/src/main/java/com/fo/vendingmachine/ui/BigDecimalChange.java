/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fo.vendingmachine.ui;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 *
 * @author TheFemiFactor
 */
public class BigDecimalChange {
    
    private BigDecimal dollars = BigDecimal.ZERO;
    private BigDecimal quarters = BigDecimal.ZERO;
    private BigDecimal dimes = BigDecimal.ZERO;
    private BigDecimal nickles = BigDecimal.ZERO;
    private BigDecimal pennies = BigDecimal.ZERO;
    private BigDecimal change = BigDecimal.ZERO;
    
    
//    public void GetChange (Double change)  {
//        
//        change = (int)(Math.ceil(change*100));
//        quarters = (int)change % 25;
//        change = change - (25 * quarters);
//        dimes = change % 10;
//        change = change - (10 * dimes);
//        nickles = change % 5;
//        change = change - (5 * nickles);
//        pennies = change;
//        
//        
//    }

    public BigDecimal getQuarters() {
        return quarters;
    }

    public BigDecimal getDimes() {
        return dimes;
    }

    public BigDecimal getNickles() {
        return nickles;
    }

    public BigDecimal getPennies() {
        return pennies;
    }
    
    public BigDecimal getDollars() {
        return dollars;
    }
    
    
    public  BigDecimalChange (Double fundLeft){
        
        BigDecimal cents = new BigDecimal("100");
        BigDecimal quarter = new BigDecimal("25");
        BigDecimal dime = new BigDecimal("10");
        BigDecimal nickle = new BigDecimal("5");
        change = new BigDecimal(fundLeft);
        
        dollars = (change).setScale(0, RoundingMode.DOWN);
        change = (((change).setScale(2, RoundingMode.HALF_EVEN).subtract(dollars)).multiply(cents)).setScale(0, RoundingMode.HALF_EVEN);
        

        // Quarters
            quarters = (change.divide(quarter)).setScale(0, RoundingMode.DOWN);
            change = (change.subtract(quarters.multiply(quarter)));


        // Dimes
            dimes = (change.divide(dime)).setScale(0, RoundingMode.DOWN);
            change = (change.subtract(dimes.multiply(dime)));
        
        // Nickles
            nickles = (change.divide(nickle)).setScale(0, RoundingMode.DOWN);
            change = (change.subtract(nickles.multiply(nickle)));

        // Pennies
            pennies = (change);
    
}
}