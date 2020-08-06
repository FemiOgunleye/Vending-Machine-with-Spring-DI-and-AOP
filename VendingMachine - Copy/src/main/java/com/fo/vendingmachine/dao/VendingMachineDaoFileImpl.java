/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fo.vendingmachine.dao;

import com.fo.vendingmachine.dto.Item;
import com.fo.vendingmachine.dto.User;
import com.fo.vendingmachine.ui.BigDecimalChange;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author TheFemiFactor
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao {
    
    public static final String INVENTORY_FILE = "inventory.txt";
    public static final String DELIMITER = "::";

    private User defaultUser = new User();
    
    Item chips = new Item("Chips", 2.99, 10);
    Item cookies = new Item("Cookies", 3.99, 10);
    Item cashews = new Item("Cashews", 4.99, 10);
    Item chewingGum = new Item("Chewing Gum", 1.99, 10);
    Item cocaCola = new Item("Coca-Cola", 2.50, 10);
    Item cappuccino = new Item("Cappuccino", 3.79, 10);
    Item chocolateMilk = new Item("Chocolate Milk", 3.99, 10);
    
    private Map<String, Item> items = new HashMap<>();
    
    public Map itemList()
    {
        items.put("Chips", chips);
        items.put("Cookies", cookies);
        items.put("Cashews", cashews);
        items.put("Chewing Gum", chewingGum);
        items.put("Coca-Cola", cocaCola);
        items.put("Cappuccino", cappuccino);
        items.put("Chocolate Milk", chocolateMilk);
        
        return items;
    }
    
private void loadInventory() throws VendingMachinePersistenceException {
        Scanner scanner;
    
    try {
    scanner = new Scanner(
            new BufferedReader(
                        new FileReader(INVENTORY_FILE)));
} catch (FileNotFoundException e) {
    throw new VendingMachinePersistenceException(
            "-_- Could not load inventory data into memory.", e);
}

String currentLine;

String[] currentTokens;

while (scanner.hasNextLine()) {
    currentLine = scanner.nextLine();
    currentTokens = currentLine.split(DELIMITER);
    Item currentItem = new Item(currentTokens[0], 
    Double.parseDouble(currentTokens[1]), Integer.parseInt(currentTokens[2]));
    
    items.put(currentItem.getName(), currentItem);
    
}
    scanner.close();
}
    
private void writeInventory() throws VendingMachinePersistenceException {
    
    PrintWriter out;
    
    try {
        out = new PrintWriter(new FileWriter(INVENTORY_FILE));
    } catch (IOException e) {
        throw new VendingMachinePersistenceException(
                "Could not save Inventory data.", e);
    }
    
    List<Item> itemList = new ArrayList<>(items.values());
    for (Item currentItem : itemList) {
        out.println(currentItem.getName() + DELIMITER
                    + currentItem.getPrice() + DELIMITER
                    + currentItem.getAvailable() + DELIMITER);
        out.flush();
    }
    out.close();
}
    
    @Override
    public Item purchase(Item item) throws VendingMachinePersistenceException {
        
        loadInventory();
        int available = item.getAvailable();
        available = available - 1;
        
        items.get(item.getName()).setAvailable(available);
        writeInventory();
        return items.get(item.getName());
    }
    


        @Override
    public Item purchase(Item item, User user) throws VendingMachinePersistenceException {
        
        loadInventory();
        int available = item.getAvailable();
        available = available - 1;
        
        items.get(item.getName()).setAvailable(available);
        writeInventory();
        return items.get(item.getName());
    }

    @Override
    public User userAmount() {
        return defaultUser;
    }
    
    @Override
    public void printMenuValidation() throws VendingMachinePersistenceException {
        loadInventory();
    }
    
    @Override
    public void updateInventory() throws VendingMachinePersistenceException {
        writeInventory();
    }

    @Override
    public BigDecimalChange change(double changeDue) {
        
        BigDecimalChange changer = new BigDecimalChange(changeDue);
        return changer;
    }
}
