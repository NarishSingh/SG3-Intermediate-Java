/*
Service layer changes
-App should stop student creation for an existing ID
-stop student creation if any field is empty
-record to an audit log when students are created or removed from system
 */
package com.sg.classroster;

import com.sg.classroster.controller.ClassRosterController;
import com.sg.classroster.dao.ClassRosterAuditDAO;
import com.sg.classroster.dao.ClassRosterAuditDAOImpl;
import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterDaoImpl;
import com.sg.classroster.service.ClassRosterServiceLayer;
import com.sg.classroster.service.ClassRosterServiceLayerImpl;
import com.sg.classroster.ui.ClassRosterView;
import com.sg.classroster.ui.UserIO;
import com.sg.classroster.ui.UserIOImpl;

public class App {

    public static void main(String[] args) {

        UserIO myIO = new UserIOImpl();
        ClassRosterView myView = new ClassRosterView(myIO);
        ClassRosterDao myDao = new ClassRosterDaoImpl();
        ClassRosterAuditDAO myAuditDao = new ClassRosterAuditDAOImpl();
        ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(myDao, myAuditDao);
        ClassRosterController controller = new ClassRosterController(myService, myView);
        controller.run();
    }

}
