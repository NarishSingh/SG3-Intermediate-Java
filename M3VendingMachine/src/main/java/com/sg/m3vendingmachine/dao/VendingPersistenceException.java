/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.m3vendingmachine.dao;

/**
 *
 * @author naris
 */
public class VendingPersistenceException extends Exception {
    public VendingPersistenceException(String msg){
        super(msg);
    }
    
    public VendingPersistenceException(String msg, Throwable cause){
        super(msg, cause);
    }
}
