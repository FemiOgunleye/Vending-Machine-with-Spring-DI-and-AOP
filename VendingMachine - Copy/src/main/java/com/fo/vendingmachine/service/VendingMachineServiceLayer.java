/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fo.vendingmachine.service;

import com.fo.vendingmachine.dao.VendingMachinePersistenceException;
import com.fo.vendingmachine.dto.Item;
import com.fo.vendingmachine.dto.User;
import com.fo.vendingmachine.ui.BigDecimalChange;

/**
 *
 * @author TheFemiFactor
 */
public interface VendingMachineServiceLayer {
    
public void purchase (Item item) throws 
                            VendingMachineInsufficientFundsException, 
                            VendingMachineInsufficientInventoryException, 
                            VendingMachinePersistenceException;

public void purchase (Item item, User user) throws 
                            VendingMachineInsufficientFundsException, 
                            VendingMachineInsufficientInventoryException, 
                            VendingMachinePersistenceException;

public User getUserFunds();

}