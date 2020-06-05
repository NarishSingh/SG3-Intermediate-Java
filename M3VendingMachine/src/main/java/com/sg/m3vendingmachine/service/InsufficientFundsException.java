/*
When user doesn't deposit enough money
 */
package com.sg.m3vendingmachine.service;

public class InsufficientFundsException extends Exception {

    public InsufficientFundsException(String msg) {
        super(msg);
    }

    public InsufficientFundsException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
