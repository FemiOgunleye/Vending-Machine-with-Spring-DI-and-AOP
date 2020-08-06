/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fo.vendingmachine.ui;

import java.math.BigDecimal;

/**
 *
 * @author TheFemiFactor
 */
public class VendingMachineView {
    
    private UserIO io;
    
    public VendingMachineView(UserIO io) {
        this.io = io;
    }
    
    
    // Each Menu line and item based on availability
    public String printMenuAndGetSelection() {
        return io.readString("Please pick an option: ");
    }
        
        public void printInitialMenu() {
            io.print("*******************Main Menu********************");
            io.print("*******************All Items:*******************");  
        }
    
        public void printWelcomeMenu() {
            io.print("*******************Main Menu********************");
            io.print("****************Available Items:****************");
        }
    
        public void printChips() {
            io.print("Chips\t\t\t\t$2.99");
        }
        public void printCookies() {
            io.print("Cookies\t\t\t\t$3.99");
        }
        public void printCashews() {
            io.print("Cashews\t\t\t\t$4.99");
        }
        public void printChewingGum() {
            io.print("Chewing Gum\t\t\t$1.99");
        }    
        public void printCocaCola() {
            io.print("Coca-Cola\t\t\t$2.50");
        }    
        public void printCappuccino() {
            io.print("Cappuccino\t\t\t$3.79");
        }
        public void printChocolateMilk() {
            io.print("Chocolate Milk\t\t\t$3.99");
        }

        
    public Double printMenuAndGetFunds() {
        return io.readDouble("Please enter an amount of funds: ");
         }
    
    public void printExitMenu() {
             io.print("Exit");
        }

    
    public void displaySelectedItem(String name) {
        io.print(name + " selected!");

    }
    
    public void displayPurchaseSuccessful() {
        io.readString("Purchase successful! Please hit enter to continue: ");
    }
    
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }
    
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    
    public void displayErrorMEssage(String errorMsg) {
        io.print("====ERROR====");
        io.print(errorMsg);
    }
    
    public void displayChange(BigDecimalChange referrence, Double amount) {
        BigDecimalChange reference = new BigDecimalChange(amount);
        io.print("Change = " + reference.getDollars() + " in dollar bill(s)");
        io.print(reference.getQuarters() + " in quarter(s)");
        io.print(reference.getDimes() + " in dime(s)");
        io.print(reference.getNickles() + " in nickle(s)");
        io.print(reference.getPennies() + " in penny(ies)");
    }
    
    public void displayUserFunds(BigDecimal amount) {
        io.print("Current user funds: $" + amount);
    }
    
}
