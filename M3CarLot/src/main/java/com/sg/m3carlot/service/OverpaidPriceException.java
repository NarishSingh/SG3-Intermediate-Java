package com.sg.m3carlot.service;

/**
 *
 * @author naris
 */
class OverpaidPriceException extends Exception {

    public OverpaidPriceException(String message) {
        super(message);
    }

    public OverpaidPriceException(String message, Throwable cause) {
        super(message, cause);
    }

}
