/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fo.vendingmachine.dao;

/**
 *
 * @author TheFemiFactor
 */
public interface VendingMachineAuditDao {
    
    public void writeAuditEntry(String entry) throws 
            VendingMachinePersistenceException;
    
}
