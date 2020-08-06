/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fo.vendingmachine.ui;

import java.util.Scanner;

/**
 *
 * @author TheFemiFactor
 */
public class UserIOConsoleImpl implements UserIO {
    
    Scanner userInput = new Scanner(System.in);
  
        @Override
    public void print(String prompt) {
         System.out.println(prompt);
    }

    @Override
    public double readDouble(String prompt) {
        
        String userValue = "";
        double value = 0.0;
        System.out.println(prompt);
        
        do {
                    try {
                        userValue = userInput.nextLine();
                        value = Double.parseDouble(userValue); 
                    } catch (NumberFormatException ex) {
                        System.out.println(prompt);
        } 
            } while ( value == 0.0);
        
        return value;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        System.out.println(prompt);
        String userValue = userInput.nextLine();
        double value = Double.parseDouble(userValue);
        while(value < min || value > max)
            { System.out.println("Please enter a value between " + min + " and"
                    + " " + max); 
            }
        return value;

    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        String userValue = userInput.nextLine();
        float value = Float.parseFloat(userValue);
        return value;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        System.out.println(prompt);
        String userValue = userInput.nextLine();
        float value = Float.parseFloat(userValue);
        while(value < min || value > max)
            { System.out.println("Please enter a value between " + min + " and"
                    + " " + max); 
            }
        return value;
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        String userValue = userInput.nextLine();
        int value = Integer.parseInt(userValue);
        return value;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        
        System.out.println(prompt);
        Scanner userInput = new Scanner(System.in);
        
        String userValue = userInput.nextLine();
        int value = Integer.parseInt(userValue);
        while(value < min || value > max)
            { System.out.println("Please enter a value between " + min + " and"
                    + " " + max); 
            }
        return value;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        String userValue = userInput.nextLine();
        long value = Long.parseLong(userValue);
        return value;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        System.out.println(prompt);
        String userValue = userInput.nextLine();
        long value = Long.parseLong(userValue);
        while(value < min || value > max)
            { System.out.println("Please enter a value between " + min + " and"
                    + " " + max); 
            } 
        return value;
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        String userValue = userInput.nextLine();
        return userValue;
    }
    
}

