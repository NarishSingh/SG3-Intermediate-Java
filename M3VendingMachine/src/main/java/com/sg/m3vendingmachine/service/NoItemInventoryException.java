/*
When user tries to purchase an item with 0 inventory
*/
package com.sg.m3vendingmachine.service;

/**
 *
 * @author naris
 */
public class NoItemInventoryException extends Exception {
    public NoItemInventoryException(String msg){
        super(msg);
    }
    
    public NoItemInventoryException(String msg, Throwable cause){
        super(msg, cause);
    }
}
