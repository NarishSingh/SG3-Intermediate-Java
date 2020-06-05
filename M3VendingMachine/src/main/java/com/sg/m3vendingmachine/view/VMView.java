package com.sg.m3vendingmachine.view;

/**
 *
 * @author naris
 */
public class VMView {

    UserIO io;

    public VMView() {
        this.io = new UserIOImpl();
    }

    /**
     * Print main menu to UI and get user's action
     * @return {int} 0-4 corresponding to menu selection
     */
    public int mainMenuAndSelection() {
        io.print("***THE VENDING MACHINE***");
        io.print("---User---");
        io.print("1 | Buy");
        io.print("2 | Buy by Snack Type");
        io.print("---Admin---");
        io.print("3 | Stock Machine");
        io.print("4 | Cash Box");
        io.print("0 | Exit");

        return io.readInt("Enter Action", 0, 4);
    }

    /*BUY*/
    /**
     * Display Buy banner for UI
     */
    public void displayBuyBanner(){
        io.print("===BUY===");
    }
    
    /*BUY BY TYPE*/
    /**
     * Display Buy By Snack/Drink Type banner for UI
     */
    public void displayBuyByTypeBanner(){
        io.print("===BUY BY SNACK/DRINK TYPE===");
    }
    
    /*STOCKING MACHINE*/
    /**
     * Display Stock Machine banner for UI
     */
    public void displayStockMachineBanner(){
        io.print("===STOCK MACHINE===");
    }
    
    /*CASH BOX*/
    public void displayCashBoxBanner(){
        io.print("===CASH BOX OPERATIONS===");
    }
    
    /*EXIT*/
    /**
     * Display Exit banner in UI
     */
    public void displayExitBanner() {
        io.print("***Thank you***");
    }

    /*EXCEPTION HANDLING/EXIT*/
    /**
     * Display Unknown Command banner in UI
     */
    public void displayUnknownCommandBanner() {
        io.print("Unknown command");
    }

    /**
     * Display error message for issues with IO
     *
     * @param errorMsg {String} error message to user
     */
    public void displayErrorMessage(String errorMsg) {
        io.print("===Error===");
        io.print(errorMsg);
    }
}
