/*
Stub versions of Audit Dao so we can test service without actual DAO
*/
package com.sg.classroster.service;

import com.sg.classroster.dao.ClassRosterAuditDAO;
import com.sg.classroster.dao.ClassRosterPersistenceException;

/**
 *
 * @author naris
 */
public class ClassRosterAuditDaoStubImpl implements ClassRosterAuditDAO {
    
    /*stubs*/
    @Override
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException{
        //do nothing
    }
    
    
}
