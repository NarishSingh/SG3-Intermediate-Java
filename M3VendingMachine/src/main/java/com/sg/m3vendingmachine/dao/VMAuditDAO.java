package com.sg.m3vendingmachine.dao;

public interface VMAuditDAO {
    
    public void writeAuditEntry(String entry) throws VendingPersistenceException;
}
