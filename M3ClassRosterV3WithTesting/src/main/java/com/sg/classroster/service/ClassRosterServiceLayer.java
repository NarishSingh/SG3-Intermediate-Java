package com.sg.classroster.service;

import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.dto.Student;
import java.util.List;

public interface ClassRosterServiceLayer {

    /**
     * Create student obj and add to roster if passes validation - all fields
     * must be filled and ID must be unique
     *
     * @param student {Student} new student entry
     * @throws ClassRosterDuplicateIDException    if ID is not unique
     * @throws ClassRosterDataValidationException if fields are not completely
     *                                            filled
     * @throws ClassRosterPersistenceException    if validation fails, will not
     *                                            persist obj
     */
    void createStudent(Student student) throws ClassRosterDuplicateIDException,
            ClassRosterDataValidationException, ClassRosterPersistenceException;

    /**
     * Get a list of all students active on roster
     *
     * @return {List} students and their respective info
     * @throws ClassRosterPersistenceException if cannot load roster from memory
     */
    List<Student> getAllStudents() throws ClassRosterPersistenceException;

    /**
     * Get info on a single student active on roster
     *
     * @param studentID {String} the unique ID for a current student
     * @return {Student} the obj pertaining to that ID key
     * @throws ClassRosterPersistenceException if cannot load student from
     *                                         roster in memory
     */
    Student getStudent(String studentID) throws ClassRosterPersistenceException;

    /**
     * Remove a single student from roster
     *
     * @param studentID {String} the unique ID for a current student
     * @return {Student} the now removed obj pertaining to that ID key
     * @throws ClassRosterPersistenceException if cannot load and/or remove
     *                                         student from roster in memory
     */
    Student removeStudent(String studentID) throws ClassRosterPersistenceException;
}
