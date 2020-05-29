/*
These methods will not interact with file persistence
 */
package com.sg.classroster.service;

import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.dto.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author naris
 */
public class ClassRosterDaoStubImpl implements ClassRosterDao {

    public Student onlyStudent;

    /*ctors*/
    public ClassRosterDaoStubImpl() {
        onlyStudent = new Student("0001");
        onlyStudent.setFirstName("Ada");
        onlyStudent.setLastName("Lovelace");
        onlyStudent.setCohort("Java-May-1845");
    }

    public ClassRosterDaoStubImpl(Student testStudent) {
        this.onlyStudent = testStudent;
    }

    /*stubs*/
    @Override
    public Student addStudent(String studentID, Student student) throws ClassRosterPersistenceException {
        if (studentID.equals(onlyStudent.getStudentID())) {
            return onlyStudent;
        } else {
            return null;
        }
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        List<Student> studentList = new ArrayList<>();
        studentList.add(onlyStudent);

        return studentList;
    }

    @Override
    public Student getStudent(String studentID) throws ClassRosterPersistenceException {
        if (studentID.equals(onlyStudent.getStudentID())) {
            return onlyStudent;
        } else {
            return null;
        }
    }

    @Override
    public Student removeStudent(String studentID) throws ClassRosterPersistenceException {
        if (studentID.equals(onlyStudent.getStudentID())) {
            return onlyStudent;
        } else {
            return null;
        }
    }
}
