package com.sg.classroster.dao;

import java.io.*;
import java.time.LocalDateTime;

public class ClassRosterAuditDAOImpl implements ClassRosterAuditDAO {

    public static final String AUDIT_FILE = "audit.txt";

    @Override
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException e) {
            throw new ClassRosterPersistenceException("Could not persist audit info", e);
        }

        LocalDateTime timestamp = LocalDateTime.now();

        out.println(timestamp.toString() + " : " + entry);
        out.flush();
    }

}
