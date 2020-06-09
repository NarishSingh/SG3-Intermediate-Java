package com.sg.m3vendingmachine.service;

import com.sg.m3vendingmachine.dao.VMAuditDAO;
import com.sg.m3vendingmachine.dao.VMDAO;
import com.sg.m3vendingmachine.dao.VendingPersistenceException;
import com.sg.m3vendingmachine.dto.Coins;
import com.sg.m3vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class VMServiceImpl implements VMService {

    private VMDAO dao;
    private VMAuditDAO auditDAO;

    /*CTOR*/
    public VMServiceImpl(VMDAO dao, VMAuditDAO auditDAO) {
        this.dao = dao;
        this.auditDAO = auditDAO;
    }

    /*INTERFACE IMPL*/
    @Override
    public void stockItem(Item snackDrink) throws ItemDataValidationException, VendingPersistenceException {
        validateNewItemData(snackDrink);
        dao.addItem(snackDrink);
        auditDAO.writeAuditEntry("ITEM: \"" + snackDrink.getName() + "\" - $" + snackDrink.getCost().toString() + " ADDED");
    }

    @Override
    public List<Item> getInventory() throws VendingPersistenceException {
        return dao.getInventory();
    }

    @Override
    public Item getItem(String itemName) throws VendingPersistenceException, NoSuchItemExistsException {
        try {
            return dao.getItem(itemName);
        } catch (NoSuchItemExistsException e) {
            throw new NoSuchItemExistsException("No such item in inventory", e);
        }

    }

    @Override
    public Map<Coins, Integer> sellItem(Item snackDrink, BigDecimal userCashIn) throws NoSuchItemExistsException, InsufficientFundsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Validate that a new item has a valid name and price above 0
     *
     * @param item {Item} an item constructed from view
     * @throws ItemDataValidationException
     */
    private void validateNewItemData(Item item) throws ItemDataValidationException {
        if (item.getName() == null
                || item.getName().trim().length() == 0
                || item.getCost().compareTo(new BigDecimal("0.01")) <= 0) {
            throw new ItemDataValidationException("ERROR: invalid item, must have valid name and cost");
        }
    }
}
