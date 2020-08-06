/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fo.vendingmachine.controller;

import com.fo.vendingmachine.dao.VendingMachineDao;
import com.fo.vendingmachine.dao.VendingMachinePersistenceException;
import com.fo.vendingmachine.dao.VendingMachineDaoFileImpl;
import com.fo.vendingmachine.dto.Item;
import com.fo.vendingmachine.dto.User;
import com.fo.vendingmachine.service.VendingMachineInsufficientFundsException;
import com.fo.vendingmachine.service.VendingMachineInsufficientInventoryException;
import com.fo.vendingmachine.service.VendingMachineServiceLayer;
import com.fo.vendingmachine.ui.BigDecimalChange;
import com.fo.vendingmachine.ui.UserIO;
import com.fo.vendingmachine.ui.UserIOConsoleImpl;
import com.fo.vendingmachine.ui.VendingMachineView;
import java.math.BigDecimal;
import java.util.Map;

/**
 *
 * @author TheFemiFactor
 */
public class VendingMachineController {
    
    private VendingMachineView view;
    private VendingMachineDao dao;
    private VendingMachineServiceLayer service;
    private BigDecimal funds = BigDecimal.ZERO;

    
    public VendingMachineController(VendingMachineDao dao, 
            VendingMachineView view, VendingMachineServiceLayer service ) {
        
        this.dao = dao;
        this.view = view;
        this.service = service;
    }
    
    
//    public VendingMachineController(VendingMachineServiceLayer service,
//            VendingMachineView view) {
//        this.service = service;
//        this.view = view;
//    }
//    
    public void run() throws 
            VendingMachinePersistenceException, 
            VendingMachineInsufficientFundsException, 
            VendingMachineInsufficientInventoryException 
    {
        
        
        Map<String, Item> items = dao.itemList();
        initialMenu();
        funds = getUserFunds();
        boolean keepGoing = true;
        String menuSelection = "";
        
        try {
        while (keepGoing) {

            menuSelection = getMenuSelection();
            
            switch(menuSelection) {
                case "Chips": 
                    purchaseItem(items.get("Chips"));
                    break;
                case "Cookies":
                    purchaseItem(items.get("Cookies"));
                    break;
                case "Cashews":
                    purchaseItem(items.get("Cashews"));
                    break;
                case "Chewing Gum":
                    purchaseItem(items.get("Chewing Gum"));
                    break;
                case "Coca-Cola":
                    purchaseItem(items.get("Coca-Cola"));
                    break;
                case "Cappuccino":
                    purchaseItem(items.get("Cappuccino"));
                    break;
                case "Chocolate Milk":
                    purchaseItem(items.get("Chocolate Milk"));
                    break;
                case "Exit":
                    convertToChange();
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }

        }
        exitMessage();
    } catch (VendingMachinePersistenceException e) {
        view.displayErrorMEssage(e.getMessage());
    }
}
    
    private BigDecimal getUserFunds() {
        
        funds = BigDecimal.valueOf(view.printMenuAndGetFunds());
        dao.userAmount().setAmountB(funds);
        return dao.userAmount().getAmountB();
    }
    
    private void initialMenu() {
        view.printInitialMenu();
        view.printChips();
        view.printCookies();
        view.printCashews();
        view.printChewingGum();
        view.printCocaCola();
        view.printCappuccino();
        view.printChocolateMilk();
    }
    
    private void menu() throws VendingMachinePersistenceException {
        view.printWelcomeMenu();
        availableMenu("Chips");
        availableMenu("Cookies");
        availableMenu("Cashews");
        availableMenu("Chewing Gum");
        availableMenu("Coca-Cola");
        availableMenu("Cappuccino");
        availableMenu("Chocolate Milk");
    }
    
    private String getMenuSelection() throws VendingMachinePersistenceException {

        menu();
        return view.printMenuAndGetSelection();
    }

    private void availableMenu(String item) throws VendingMachinePersistenceException {
        Map<String, Item> items = dao.itemList();
        dao.printMenuValidation();
        
        switch(item) {
            case "Chips":
                if(items.get(item).getAvailable() > 0)
            { 
                view.printChips();
            }
            break;
            case "Cookies":
                if(items.get(item).getAvailable() > 0)
            { 
                view.printCookies();
            }
            break;
            case "Cashews":
                if(items.get(item).getAvailable() > 0)
            { 
                view.printCashews();
            }
            break;
            case "Chewing Gum":
                if(items.get(item).getAvailable() > 0)
            { 
                view.printChewingGum();
            }
            break;
            case "Coca-Cola":
                if(items.get(item).getAvailable() > 0)
            { 
                view.printCocaCola();
            }
            break;
            case "Cappuccino":
                if(items.get(item).getAvailable() > 0)
            { 
                view.printCappuccino();
            }
            break;
            case "Chocolate Milk":
                if(items.get(item).getAvailable() > 0)
            { 
                view.printChocolateMilk();
            }
            break;
            
                
        }
    }
        
    
    private void purchaseItem(Item item) 
                throws VendingMachinePersistenceException, VendingMachineInsufficientFundsException, VendingMachineInsufficientInventoryException {
        Map<String, Item> items = dao.itemList();
        view.displayUserFunds(dao.userAmount().getAmountB());
        view.displaySelectedItem(item.getName());
        
        dao.printMenuValidation();
        
        boolean hasErrors = false;
            dao.printMenuValidation();
                try {
                    service.purchase(item);
                    view.displayPurchaseSuccessful();
                    dao.userAmount().setAmountB((dao.userAmount().getAmountB()).subtract(BigDecimal.valueOf((item.getPrice()))));
                    view.displayUserFunds(dao.userAmount().getAmountB());
                    hasErrors = false;
                } catch (VendingMachineInsufficientFundsException | VendingMachineInsufficientInventoryException e) {
                    hasErrors = true;
                    view.displayErrorMEssage(e.getMessage());
                }
                
    }
    
    private void convertToChange() {
        BigDecimalChange changeNeeded = new BigDecimalChange(dao.userAmount().getAmountB().doubleValue());
        view.displayChange(changeNeeded, dao.userAmount().getAmountB().doubleValue());
        
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage() {
        view.displayExitBanner();
    }
    
}
