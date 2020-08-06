/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fo.vendingmachine.dao;

import com.fo.vendingmachine.dto.Item;
import com.fo.vendingmachine.dto.User;
import com.fo.vendingmachine.ui.BigDecimalChange;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author TheFemiFactor
 */
public class VendingMachineDaoTest {
    
    private VendingMachineDao dao = new VendingMachineDaoFileImpl();
    
    public VendingMachineDaoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() throws Exception {
//        Map<String, Item>items = dao.itemList();
//        for (int i = 0; i < items.size(); i++) {
//            items.clear();
//        }
       
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of purchase method, of class VendingMachineDao.
     */
    @Test
    public void testPurchase() throws Exception {
        Map<String, Item> items = dao.itemList();
        Item item = new Item("Carp", 15.99, 2);
        items.put("Carp", item);  
        dao.purchase(item);
        assertEquals(items.get(item.getName()).getAvailable(), 1);
        
    }

    /**
     * Test of itemList method, of class VendingMachineDao.
     */
    @Test
    public void testItemList() {
    }

    /**
     * Test of userAmount method, of class VendingMachineDao.
     */
    @Test
    public void testUserAmount() {
    }

    /**
     * Test of change method, of class VendingMachineDao.
     */
    @Test
    public void testChange() {
    }

    /**
     * Test of printMenuValidation method, of class VendingMachineDao.
     */
    @Test
    public void testPrintMenuValidation() throws Exception {
    }
    
}
