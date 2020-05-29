package com.sg.classroster.service;

import com.sg.classroster.dao.ClassRosterAuditDAO;
import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.dto.Student;
import java.util.List;

public class ClassRosterServiceLayerImpl implements ClassRosterServiceLayer {

    private ClassRosterDao dao;
    private ClassRosterAuditDAO auditDAO;

    public ClassRosterServiceLayerImpl(ClassRosterDao dao, ClassRosterAuditDAO auditDAO) {
        this.dao = dao;
        this.auditDAO = auditDAO;
    }

    @Override
    public void createStudent(Student student) throws ClassRosterDuplicateIDException, 
            ClassRosterDataValidationException, ClassRosterPersistenceException {
        //check if ID is used
        if (dao.getStudent(student.getStudentID()) != null) {
            throw new ClassRosterDuplicateIDException("ERROR: Student ID " + 
                    student.getStudentID() + " already exists");
        }

        //validate all fields or else throw exception
        validateStudentData(student);

        //if all passed, persist obj
        dao.addStudent(student.getStudentID(), student);

        //record addition
        auditDAO.writeAuditEntry("Student " + student.getStudentID() + " CREATED");
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        return dao.getAllStudents();
    }

    @Override
    public Student getStudent(String studentID) throws ClassRosterPersistenceException {
        return dao.getStudent(studentID);
    }

    @Override
    public Student removeStudent(String studentID) throws ClassRosterPersistenceException {
        Student removedStudent = dao.removeStudent(studentID);
        
        auditDAO.writeAuditEntry("Student " + studentID + " REMOVED");

        return removedStudent;
    }

    /*behaviors*/
    /**
     * Validate that all fields of a Student obj arg have been filled, throw an
     * exception if not
     *
     * @param student {Student} a Student obj prior to its addition to roster
     * @throws ClassRosterDataValidationException if any fields are empty,
     *                                            whitespace, or null throw
     *                                            exception to stop from writing
     *                                            obj to roster in memory
     */
    private void validateStudentData(Student student) throws ClassRosterDataValidationException {
        if (student.getFirstName() == null
                || student.getFirstName().trim().length() == 0
                || student.getLastName() == null
                || student.getLastName().trim().length() == 0
                || student.getCohort() == null
                || student.getCohort().trim().length() == 0) {
            throw new ClassRosterDataValidationException("ERROR: All fields required.");
        }
    }

}
