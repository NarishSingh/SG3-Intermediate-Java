package com.sg.m3vendingmachine.service;

import com.sg.m3vendingmachine.dao.VMAuditDAO;
import com.sg.m3vendingmachine.dao.VendingPersistenceException;

public class VMAuditDAOImplStub implements VMAuditDAO {
    
    @Override
    public void writeAuditEntry(String entry) throws VendingPersistenceException{
        //do nothing
    }
}
