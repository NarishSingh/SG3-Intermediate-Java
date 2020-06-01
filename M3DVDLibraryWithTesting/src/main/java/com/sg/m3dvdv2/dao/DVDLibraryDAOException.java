/*
exception definition class
 */
package com.sg.m3dvdv2.dao;

public class DVDLibraryDAOException extends Exception {
    public DVDLibraryDAOException(String message){
        super(message);
    }
    
    public DVDLibraryDAOException(String message, Throwable cause){
        super(message, cause);
    }
}
