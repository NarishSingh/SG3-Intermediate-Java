package com.sg.m3vendingmachine.dao;

public class VendingDAOException extends Exception {
    public VendingDAOException(String msg){
        super(msg);
    }
    
    public VendingDAOException(String msg, Throwable cause){
        super(msg, cause);
    }
}
