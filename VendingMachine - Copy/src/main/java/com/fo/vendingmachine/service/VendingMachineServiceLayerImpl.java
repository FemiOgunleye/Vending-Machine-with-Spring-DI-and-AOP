/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fo.vendingmachine.service;

import com.fo.vendingmachine.dao.VendingMachineAuditDao;
import java.util.Map;
import com.fo.vendingmachine.dao.VendingMachineDao;
import com.fo.vendingmachine.dao.VendingMachineDaoFileImpl;
import com.fo.vendingmachine.dao.VendingMachinePersistenceException;
import com.fo.vendingmachine.dto.Item;
import com.fo.vendingmachine.dto.User;
import com.fo.vendingmachine.ui.BigDecimalChange;


/**
 *
 * @author TheFemiFactor
 */
public class VendingMachineServiceLayerImpl implements 
        VendingMachineServiceLayer {
    
    
    private VendingMachineDao dao = new VendingMachineDaoFileImpl();
    private VendingMachineAuditDao auditDao;
    User defaultUser = getUserFunds();
    
    
    
    
    public VendingMachineServiceLayerImpl(VendingMachineDao dao, 
            VendingMachineAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public void purchase(Item item) throws VendingMachineInsufficientFundsException, VendingMachineInsufficientInventoryException, VendingMachinePersistenceException {
        
        this.defaultUser = dao.userAmount();
        validateInventory(item);
        validateUserFunds(item, defaultUser);
        dao.purchase(item);
//        auditDao.writeAuditEntry("Item " + item.getName() + " UPDATED.");
    }    
    
        @Override
    public void purchase(Item item, User user) throws VendingMachineInsufficientFundsException, VendingMachineInsufficientInventoryException, VendingMachinePersistenceException {
        
        this.defaultUser = user;
        validateInventory(item);
        validateUserFunds(item, defaultUser);
        dao.purchase(item);
//        auditDao.writeAuditEntry("Item " + item.getName() + " UPDATED.");
    }  
        
    private void validateInventory(Item item) throws 
             VendingMachineInsufficientInventoryException  {
    
        if(item.getAvailable() < 1 )
        {
            throw new VendingMachineInsufficientInventoryException(
            "Error: Insufficient inventory to complete this purchase.");
        }
        
    }
    
        private void validateUserFunds(Item item, User user) throws 
             VendingMachineInsufficientFundsException      {
            
        if (item.getPrice() > user.getAmountB().doubleValue())
        {
            throw new VendingMachineInsufficientFundsException(
            "Error: Insufficient funds to complete this purchase.");
        }
        
    }
        
        @Override
        public User getUserFunds() {
            return dao.userAmount();
        }
            
}
