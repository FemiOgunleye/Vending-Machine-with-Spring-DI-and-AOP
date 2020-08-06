/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fo.vendingmachine.dao;

import com.fo.vendingmachine.dto.Item;
import com.fo.vendingmachine.dto.User;
import com.fo.vendingmachine.ui.BigDecimalChange;
import java.math.BigDecimal;
import java.util.Map;


/**
 *
 * @author TheFemiFactor
 */
public interface VendingMachineDao {
    
    /**
     * Calls Item object associated with item name, subtracts from the available
     * int and returns the item object.
     * @param name of item to be purchased and modified.
     * @param item object called.
     * @return Item object that was purchased.
     * @throws com.fo.vendingmachine.dao.VendingMachinePersistenceException
     */
    Item purchase(Item item) throws VendingMachinePersistenceException;
    
    Item purchase(Item item, User user) throws VendingMachinePersistenceException;
    
    Map itemList();
    
    public User userAmount();

    public BigDecimalChange change(double changeDue);
    
    public void printMenuValidation() throws VendingMachinePersistenceException;
    
    public void updateInventory() throws VendingMachinePersistenceException;
}
