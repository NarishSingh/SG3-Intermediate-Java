package com.sg.m3carlot.service;

/**
 *
 * @author naris
 */
class UnderpaidPriceException extends Exception {

    public UnderpaidPriceException(String message) {
        super(message);
    }

    public UnderpaidPriceException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
