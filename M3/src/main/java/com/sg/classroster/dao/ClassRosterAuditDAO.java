/*
will keep records of all student additions and removals
 */
package com.sg.classroster.dao;

public interface ClassRosterAuditDAO {

    /**
     * Create a time stamped entry of student addition or removal from roster
     *
     * @param entry {String} Student obj info to be recorded
     * @throws ClassRosterPersistenceException if cannot write to file
     */
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException;
}
