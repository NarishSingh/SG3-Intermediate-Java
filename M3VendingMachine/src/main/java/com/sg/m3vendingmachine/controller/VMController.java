package com.sg.m3vendingmachine.controller;

import com.sg.m3vendingmachine.dao.VendingPersistenceException;
import com.sg.m3vendingmachine.dto.Item;
import com.sg.m3vendingmachine.service.ItemDataValidationException;
import com.sg.m3vendingmachine.service.VMService;
import com.sg.m3vendingmachine.view.VMView;

public class VMController {

    private VMView view;
    private VMService service;

    public VMController(VMService service, VMView view) {
        this.service = service;
        this.view = view;
    }

    /**
     * App controller
     */
    public void run() {
        boolean inProgram = true;
        boolean buying = true;
//        boolean buyingByType = true;
        boolean stocking = true;

        try {
            while (inProgram) {
                int menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1: {
                        while (buying) {
                            //buy
                        }
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
     * Stock the vending machine with merchandise to sell
     */
    private void stockMachine() throws VendingPersistenceException {
        view.displayStockMachineBanner();
        boolean hasErrors = false;

        do {
            Item newItem = view.getNewItemInfo();

            try {
                service.stockItem(newItem);
                view.displayStockMachineSuccessBanner();
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
