package com.sg.classroster.controller;

import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.dto.Student;
import com.sg.classroster.service.ClassRosterDataValidationException;
import com.sg.classroster.service.ClassRosterDuplicateIDException;
import com.sg.classroster.service.ClassRosterServiceLayer;
import com.sg.classroster.ui.ClassRosterView;
import java.util.List;

public class ClassRosterController {

    private ClassRosterView view;
    private ClassRosterServiceLayer service;

    /*ctors using dependency injection*/
    public ClassRosterController(ClassRosterServiceLayer service, ClassRosterView view) {
        this.service = service;
        this.view = view;
    }

    /**
     * App controller - control method calls based on user inputs
     */
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;

        try {
            while (keepGoing) {
                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1: {
                        listStudents();
                        break;
                    }
                    case 2: {
                        createStudent();
                        break;
                    }
                    case 3: {
                        viewStudent();
                        break;
                    }
                    case 4: {
                        removeStudent();
                        break;
                    }
                    case 5: {
                        keepGoing = false;
                        break;
                    }
                    default: {
                        unknownCommand();
                    }
                }

                exitMessage();
            }
        } catch (ClassRosterPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    /**
     * Get user input for Menu
     *
     * @return {int} 1-5 for menu actions
     */
    private int getMenuSelection() {
        return view.printMenuGetSelection();
    }

    /**
     * Display banners for student obj creation. Construct new Student obj and
     * fill fields. Validate, then add to class roster
     *
     * @throws ClassRosterPersistenceException if ID already used or fields not
     *                                         completely filled
     */
    private void createStudent() throws ClassRosterPersistenceException {
        view.displayCreateStudentBanner();
        boolean hasErrors = false;

        do {
            Student currentStudent = view.getNewStudentInfo();

            try {
                service.createStudent(currentStudent);
                view.displayCreateSuccessBanner();
                hasErrors = false;
            } catch (ClassRosterDuplicateIDException
                    | ClassRosterDataValidationException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);
        
        //useful to return the student obj sometimes, will see this later
    }

    /**
     * Display banners for class roster listing. Retrieve and display class
     * roster from values in students HashMap DAO.
     *
     * @throws ClassRosterPersistenceException
     */
    private void listStudents() throws ClassRosterPersistenceException {
        view.displayDisplayAllBanner();
        List<Student> studentList = service.getAllStudents();
        view.displayStudentList(studentList);
    }

    /**
     * Display banners for student view listing. Get user input for the
     * student's ID, then retrieve and display their info
     *
     * @throws ClassRosterPersistenceException
     */
    public void viewStudent() throws ClassRosterPersistenceException {
        view.displayDisplayStudentBanner();
        String studentID = view.getStudentIDChoice();
        Student student = service.getStudent(studentID);
        view.displayStudent(student);
    }

    /**
     * Display banners for removing a student from roster. Get user input for
     * the student's ID, then remove from students HashMap DAO
     *
     * @throws ClassRosterPersistenceException
     */
    private void removeStudent() throws ClassRosterPersistenceException {
        view.displayRemoveStudentBanner();
        String studentID = view.getStudentIDChoice();
        service.removeStudent(studentID);
        view.displayRemoveSuccessBanner();
    }

    /**
     * Display banner for an invalid Menu choice
     */
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    /**
     * Display banner for exiting app
     */
    private void exitMessage() {
        view.displayExitBanner();
    }
}
