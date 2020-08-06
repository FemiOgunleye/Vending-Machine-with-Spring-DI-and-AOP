/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fo.vendingmachine;

import com.fo.vendingmachine.controller.VendingMachineController;
import com.fo.vendingmachine.dao.VendingMachineAuditDao;
import com.fo.vendingmachine.dao.VendingMachineAuditDaoFileImpl;
import com.fo.vendingmachine.dao.VendingMachineDao;
import com.fo.vendingmachine.dao.VendingMachinePersistenceException;
import com.fo.vendingmachine.dao.VendingMachineDaoFileImpl;
import com.fo.vendingmachine.service.VendingMachineInsufficientFundsException;
import com.fo.vendingmachine.service.
        VendingMachineInsufficientInventoryException;
import com.fo.vendingmachine.service.VendingMachineServiceLayer;
import com.fo.vendingmachine.service.VendingMachineServiceLayerImpl;
import com.fo.vendingmachine.ui.UserIO;
import com.fo.vendingmachine.ui.UserIOConsoleImpl;
import com.fo.vendingmachine.ui.VendingMachineView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author TheFemiFactor
 */
public class App {
    
    public static void main(String[] args) throws 
            VendingMachinePersistenceException, 
            VendingMachineInsufficientFundsException, 
            VendingMachineInsufficientInventoryException {
        
//        UserIO myIo = new UserIOConsoleImpl();
//        VendingMachineView myView = new VendingMachineView(myIo);
//        VendingMachineDao myDao = new VendingMachineDaoFileImpl();
//        VendingMachineAuditDao myAuditDao= new VendingMachineAuditDaoFileImpl();
//        VendingMachineServiceLayer myService = 
//                new VendingMachineServiceLayerImpl(myDao, myAuditDao);
//        VendingMachineController controller =
//                new VendingMachineController(myDao, myView, myService);
//        controller.run();


        ApplicationContext ctx = 
                new ClassPathXmlApplicationContext("applicationContext.xml");
        VendingMachineController controller = 
                ctx.getBean("controller", VendingMachineController.class);
        controller.run();
    }
    
}
