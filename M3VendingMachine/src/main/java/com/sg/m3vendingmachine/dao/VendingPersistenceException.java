package com.sg.m3vendingmachine.dao;

public class VendingPersistenceException extends Exception {
    public VendingPersistenceException(String msg){
        super(msg);
    }
    
    public VendingPersistenceException(String msg, Throwable cause){
        super(msg, cause);
    }
}
