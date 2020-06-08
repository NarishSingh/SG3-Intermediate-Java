package com.sg.m3vendingmachine.dao;

import com.sg.m3vendingmachine.dto.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VMDAOImpl implements VMDAO {

    private List<Item> inventory = new ArrayList<>();
    public final String INVENTORY_FILE;
    public static final String DELIMITER = "::";

    /*CTORS*/
    //production
    public VMDAOImpl() {
        INVENTORY_FILE = "inventory.txt";
    }

    //testing
    public VMDAOImpl(String inventoryTextFile) {
        this.INVENTORY_FILE = inventoryTextFile;
    }

    /*INTERFACE IMPL*/
    @Override
    public void addItem(Item snackDrink) throws VendingPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeItem(Item snackDrink) throws VendingPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Item> getInventory() throws VendingPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Item dispenseItemChange(Item snackDrink, BigDecimal userCashIn) throws VendingPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*DATA (UN)MARSHALLING*/
    /**
     * Marshall data from an item obj in inventory to text
     *
     * @param anItem {Item} Item obj in inventory with all fields filled in
     * @return {String} the obj as a delimited String
     */
    private String marshallItem(Item anItem) {
        String itemAsText = anItem.getName() + DELIMITER;
        itemAsText += anItem.getCost().toString();

        return itemAsText;
    }

    /**
     * Unmarshall data from a delimited line of text into constructing a item
     * obj
     *
     * @param itemAsText {String} delimited by ::
     * @return {Item} obj constructed with all fields filled
     */
    private Item unmarshallItem(String itemAsText) {
        String[] itemTokens = itemAsText.split(DELIMITER);

        String itemName = itemTokens[0];
        BigDecimal itemCost = new BigDecimal(itemTokens[1]);

        Item itemFromFile = new Item(itemName, itemCost);

        return itemFromFile;
    }

    /**
     * Read in file and construct items in inventory from lines of delimited
     * text
     *
     * @throws VendingPersistenceException if cannot read in file
     */
    private void loadInventory() throws VendingPersistenceException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(INVENTORY_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingPersistenceException("Couldn't load inventory from file", e);
        }

        String currentLine;
        Item currentItem;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentItem = unmarshallItem(currentLine);

            inventory.add(currentItem);
        }

        scanner.close();
    }

    /**
     * Write all items in inventory to INVENTORY_FILE
     *
     * @throws VendingPersistenceException if cannot write to file
     */
    private void writeInventory() throws VendingPersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(INVENTORY_FILE));
        } catch (IOException e) {
            throw new VendingPersistenceException("Could not write to inventory file", e);
        }

        String itemAsText;
        
        for (Item item : inventory) {
            itemAsText = marshallItem(item);
                    out.println(itemAsText);
                    out.flush();
        }

        /*
        inventory.stream()
                .forEach(Item -> {
                    itemAsText = marshallItem(Item); //FIXME what does this mean
                    out.println(itemAsText);
                    out.flush();
                });
                */

        out.close();
    }
}
