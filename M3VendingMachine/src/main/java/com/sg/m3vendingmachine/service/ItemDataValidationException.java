package com.sg.m3vendingmachine.service;

public class ItemDataValidationException extends Exception {

    public ItemDataValidationException(String msg) {
        super(msg);
    }

    public ItemDataValidationException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
