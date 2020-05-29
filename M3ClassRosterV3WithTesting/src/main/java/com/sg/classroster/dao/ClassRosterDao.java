/*
This interface defines the methods that must be implemented by any class that 
wants to play the role of DAO in the application. You could imagine, however, an 
implementation that only stored student data in memory or one that stored student
data in a database. Each class would be different but all would implement that 
same interface, ensuring that they are all well encapsulated. Note that the 
ClassRosterController only uses this interface to reference the DAO — it is 
completely unaware of the implementation details.

-for impl file
This is the text file-specific implementation of the ClassRosterDao interface.
 */
package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;
import java.util.List;

public interface ClassRosterDao {

    /**
     * Adds student to roster associated w ID. If there is already a student
     * with that ID it will return that student object, otherwise null
     *
     * @param studentID {String} id to associate with the student
     * @param student   {Student} student being added to roster
     * @return {Student|null} Student object for the previously associated ID,
     *         null otherwise
     * @throws ClassRosterPersistenceException {IOException} if roster cannot be written
     *                                 to or loaded
     */
    Student addStudent(String studentID, Student student) throws ClassRosterPersistenceException;

    /**
     * Return List of students in roster
     *
     * @return {List} roster of Student objects
     * @throws ClassRosterPersistenceException {IOException} if roster cannot be loaded
     */
    List<Student> getAllStudents() throws ClassRosterPersistenceException;

    /**
     * Returns student obj associated with a given id
     *
     * @param studentID {String} Id of student to retrieve
     * @return {Student} the student object associated with the given id, null
     *         otherwise
     * @throws ClassRosterPersistenceException {IOException} if roster cannot be loaded
     */
    Student getStudent(String studentID) throws ClassRosterPersistenceException;

    /**
     * Removes student object associated with the id from roster, null if no
     * student exists for that ID
     *
     * @param studentID {String} the id for student to be removed
     * @return {Student|null} student object to be removed, null if no such
     *         student is on roster
     * @throws ClassRosterPersistenceException if roster cannot be loaded or written to
     */
    Student removeStudent(String studentID) throws ClassRosterPersistenceException;
}
