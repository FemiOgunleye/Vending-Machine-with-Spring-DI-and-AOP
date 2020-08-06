/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fo.vendingmachine.dao;

import com.fo.vendingmachine.dto.Item;
import com.fo.vendingmachine.dto.User;
import com.fo.vendingmachine.ui.BigDecimalChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author TheFemiFactor
 */
public class VendingMachineDaoStubImpl implements VendingMachineDao {

    Item onlyItem;
    Map<String, Item> itemList = new HashMap<>();
    User defaultUser;
    
    public VendingMachineDaoStubImpl() {
        onlyItem = new Item("cantaloupes", 2.50, 10);
        
        itemList.put("cantaloupes", onlyItem);
    }
    
    @Override
    public Item purchase(Item item) throws VendingMachinePersistenceException {
        if (onlyItem.getAvailable() < 1 ) {
            return null;
        } else return onlyItem;
    }

    @Override
    public Map itemList() {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public void printMenuValidation() throws VendingMachinePersistenceException {
        // do nothing
    }

    @Override
    public void updateInventory() throws VendingMachinePersistenceException {
        // do nothing
    }

    @Override
    public User userAmount() {
        return this.defaultUser;
    }

    @Override
    public BigDecimalChange change(double changeDue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Item purchase(Item item, User user) throws VendingMachinePersistenceException {
        if (onlyItem.getPrice() < user.getAmount() ) {
            return null;
        } else return onlyItem;
    }
    
}
