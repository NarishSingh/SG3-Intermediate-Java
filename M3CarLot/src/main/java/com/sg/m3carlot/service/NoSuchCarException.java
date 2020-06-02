package com.sg.m3carlot.service;

/**
 *
 * @author naris
 */
class NoSuchCarException extends Exception {

    public NoSuchCarException(String msg) {
        super(msg);
    }

    public NoSuchCarException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
