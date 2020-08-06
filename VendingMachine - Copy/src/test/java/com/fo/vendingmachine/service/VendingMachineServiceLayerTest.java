/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fo.vendingmachine.service;

import com.fo.vendingmachine.dao.VendingMachineAuditDao;
import com.fo.vendingmachine.dao.VendingMachineAuditDaoStubImpl;
import com.fo.vendingmachine.dao.VendingMachineDao;
import com.fo.vendingmachine.dao.VendingMachineDaoStubImpl;
import com.fo.vendingmachine.dao.VendingMachinePersistenceException;
import com.fo.vendingmachine.dto.Item;
import com.fo.vendingmachine.dto.User;
import java.math.BigDecimal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author TheFemiFactor
 */
public class VendingMachineServiceLayerTest {
    
    private VendingMachineServiceLayer service;
    private VendingMachineDao dao;
    
    public VendingMachineServiceLayerTest() {
//        VendingMachineDao dao = new VendingMachineDaoStubImpl();
//       VendingMachineAuditDao auditDao = new VendingMachineAuditDaoStubImpl();
//    
//        service = new VendingMachineServiceLayerImpl(dao, auditDao);

        ApplicationContext ctx = 
                new ClassPathXmlApplicationContext("applicationContext.xml");
        service = 
            ctx.getBean("serviceLayer", VendingMachineServiceLayerImpl.class);
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of purchase method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testInsufficientInventory() throws Exception {
        
        Item newItem = new Item("calzones", 9.99, 0);
        User defaultUser = new User();
        defaultUser.setAmount(10);
        try {
            
            
            service.purchase(newItem);
            fail("Expected InsufficientInventoryException was not thrown.");
        } catch (VendingMachineInsufficientInventoryException e) {
            return;
        }
    }
    
    public void testInsufficientFunds() throws Exception {
        
        Item newItem = new Item("calzones", 9.99, 3);
        User defaultUser = new User();
        BigDecimal nine = new BigDecimal("9");
        defaultUser.setAmountB(nine);
        
        
        try {
            service.purchase(newItem, defaultUser);
            fail("Expected InsufficientFundsException was not thrown.");
        } catch (VendingMachineInsufficientFundsException e) {
            return;
        }
   
    }
    
}
