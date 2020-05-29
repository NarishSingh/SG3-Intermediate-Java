package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;
import java.io.FileWriter;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author naris
 */
public class ClassRosterDaoImplTest extends ClassRosterDaoImpl {

    ClassRosterDao testDAO;

    public ClassRosterDaoImplTest(String testFile){
        super(testFile);
    }

    @BeforeEach
    public void setUp() throws Exception {
        String testFile = "testroster.txt";
        new FileWriter(testFile); //create file or scrub of any data
        testDAO = new ClassRosterDaoImplTest(testFile); //FIXME ctor doesn't take any arg's
    }

    /**
     * Test of addStudent() of DAO and getter methods of DTO - add a student and
     * check if obj is created correctly
     *
     * @throws Exception
     */
    @Test
    public void testAddGetStudent() throws Exception {
        //Arrange
        String studentID = "0001";
        Student student = new Student(studentID);
        student.setFirstName("Ada");
        student.setLastName("Lovelace");
        student.setCohort("Java-May-1845");

        //Act
        testDAO.addStudent(studentID, student);
        Student retrievedStudent = testDAO.getStudent(studentID);

        //Assert
        assertEquals(student.getStudentID(), retrievedStudent.getStudentID());
        assertEquals(student.getFirstName(), retrievedStudent.getFirstName());
        assertEquals(student.getLastName(), retrievedStudent.getLastName());
        assertEquals(student.getCohort(), retrievedStudent.getCohort());
    }

    /**
     * Test of getAllStudents() of DAO, using addStudent() and setters of DTO -
     * add 2 students then get List of all students
     *
     * @throws Exception
     */
    @Test
    public void testAddGetAllStudents() throws Exception {
        //ARRANGE
        //1st
        Student firstStudent = new Student("0001");
        firstStudent.setFirstName("Ada");
        firstStudent.setLastName("Lovelace");
        firstStudent.setCohort("Java-May-1845");

        //2nd
        Student secondStudent = new Student("0002");
        secondStudent.setFirstName("Charles");
        secondStudent.setLastName("Babbage");
        secondStudent.setCohort(".NET-May-1845");

        //ACT
        testDAO.addStudent(firstStudent.getStudentID(), firstStudent);
        testDAO.addStudent(secondStudent.getStudentID(), secondStudent);

        List<Student> allStudents = testDAO.getAllStudents();

        //ASSERT
        //list or general
        assertNotNull(allStudents, "List shouldn't be null");
        assertEquals(2, allStudents.size(), "List should have 2 students");

        //specific
        assertTrue(testDAO.getAllStudents().contains(firstStudent), "List should include Ada");
        assertTrue(testDAO.getAllStudents().contains(secondStudent), "List should include Charles");
    }

    /**
     * Test of removeStudent() of DAO, using setters, addStudent(), and
     * getAllStudents() - Add 2 students, remove one and check list, remove the
     * 2nd and check list again, check if list is empty at end
     *
     * @throws Exception
     */
    @Test
    public void testRemoveStudent() throws Exception {
        //ARRANGE
        //1st
        Student firstStudent = new Student("0001");
        firstStudent.setFirstName("Ada");
        firstStudent.setLastName("Lovelace");
        firstStudent.setCohort("Java-May-1845");

        //2nd
        Student secondStudent = new Student("0002");
        secondStudent.setFirstName("Charles");
        secondStudent.setLastName("Babbage");
        secondStudent.setCohort(".NET-May-1845");

        //ACT/ASSERT
        //Add
        testDAO.addStudent(firstStudent.getStudentID(), firstStudent);
        testDAO.addStudent(secondStudent.getStudentID(), secondStudent);

        //Remove
        Student removedStudent = testDAO.removeStudent(firstStudent.getStudentID());

        //List
        List<Student> allStudents = testDAO.getAllStudents();

        //removed first and check
        assertEquals(removedStudent, firstStudent, "Ada should've been removed");
        assertNotNull(allStudents, "List shouldn't be null");
        assertEquals(1, allStudents.size(), "All students should only have 1 student");

        assertFalse(allStudents.contains(firstStudent), "List should NOT include Ada");
        assertTrue(testDAO.getAllStudents().contains(secondStudent), "List should include Charles");

        //remove second and check
        removedStudent = testDAO.removeStudent(secondStudent.getStudentID());
        assertEquals(removedStudent, secondStudent, "Charles should've been removed");

        allStudents = testDAO.getAllStudents();

        assertTrue(allStudents.isEmpty(), "List should be empty");

        //both should be null
        Student retrievedStudent = testDAO.getStudent(firstStudent.getStudentID());
        assertNull(retrievedStudent, "Ada removed - should be null");

        retrievedStudent = testDAO.getStudent(secondStudent.getStudentID());
        assertNull(retrievedStudent, "Charles removed - should be null");
    }
}
