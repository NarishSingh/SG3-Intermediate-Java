package com.sg.m3vendingmachine.controller;

import com.sg.m3vendingmachine.dao.VendingPersistenceException;
import com.sg.m3vendingmachine.dto.Coins;
import com.sg.m3vendingmachine.dto.Item;
import com.sg.m3vendingmachine.service.InsufficientFundsException;
import com.sg.m3vendingmachine.service.ItemDataValidationException;
import com.sg.m3vendingmachine.service.NoSuchItemExistsException;
import com.sg.m3vendingmachine.service.VMService;
import com.sg.m3vendingmachine.view.VMView;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class VMController {

    private VMView view;
    private VMService service;

    public VMController(VMService service, VMView view) {
        this.service = service;
        this.view = view;
    }

    /**
     * App controller
     *
     * @throws NoSuchItemExistsException  if user tries to buy a non-existent
     *                                    item
     * @throws InsufficientFundsException if user enters an insufficient amount
     *                                    of money
     */
    public void run() throws NoSuchItemExistsException, InsufficientFundsException {
        boolean inProgram = true;
        //TODO consider buying and stocking loops for conveniance
//        boolean buying = true;
//        boolean stocking = true;

        try {
            while (inProgram) {
                int menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1: {
                        buyItem();
                        break;
                    }
                    case 2: {
                        stockMachine();
                        break;
                    }
                    case 0: {
                        inProgram = false;
                        break;
                    }
                    default: {
                        unknownCommand();
                    }
                }

            }
            exitMessage();
        } catch (VendingPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    /**
     * Get input for menu choice
     *
     * @return {int} 0-4 for menu actions
     */
    private int getMenuSelection() {
        return view.mainMenuAndSelection();
    }

    /**
     * Display all consumables, get cash and item choice inputs, validate, and
     * finally dispense item and exact change
     */
    private void buyItem() throws VendingPersistenceException, NoSuchItemExistsException, InsufficientFundsException {
        view.displayBuyBanner();

        List<Item> inventory = service.getInventory();
        view.displayInventory(inventory);

        BigDecimal cashIn = view.getCash();

        boolean hasErrors = false;
        Item itemToBuy = null;
        do {
            String itemToBuyString = view.getUserBuySelection();

            try {
                itemToBuy = service.getItem(itemToBuyString);
                hasErrors = false;
            } catch (NoSuchItemExistsException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors || itemToBuy == null);

        hasErrors = false;
        do {
            try {
                Map<Coins, Integer> usersChange = service.sellItem(itemToBuy, cashIn);

                if (usersChange.isEmpty()) {
                    view.displayPurchaseNoChangeBanner(itemToBuy);
                } else {
                    view.displayPurchaseWithChange(itemToBuy, usersChange);
                }

                hasErrors = false;
            } catch (InsufficientFundsException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);
    }

    /**
     * Stock the vending machine with merchandise to sell
     */
    private void stockMachine() throws VendingPersistenceException {
        view.displayStockMachineBanner();
        boolean hasErrors = false;

        do {
            Item newItem = view.getNewItemInfo();

            try {
                service.stockItem(newItem);
                int itemCount = service.inventoryCount();
                view.displayStockMachineSuccessBanner(itemCount);
                hasErrors = false;
            } catch (ItemDataValidationException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);
    }

    /**
     * Display banner for invalid menu choices
     */
    public void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    /**
     * Display exit banner for User exiting the program
     */
    public void exitMessage() {
        view.displayExitBanner();
    }
}
