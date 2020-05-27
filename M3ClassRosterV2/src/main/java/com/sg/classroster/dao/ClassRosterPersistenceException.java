/*
This is the error class for our application. It extends Exception.
 */
package com.sg.classroster.dao;

public class ClassRosterPersistenceException extends Exception {

    public ClassRosterPersistenceException(String message) {
        super(message);
    }

    public ClassRosterPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
