/*
For service, we don't want to test any actual persistence (job of DAO)
Will use stubbed versions of DAO
 */
package com.sg.classroster.service;

import com.sg.classroster.dao.ClassRosterAuditDAO;
import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.dto.Student;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author naris
 */
public class ClassRosterServiceLayerImplTest {

    private ClassRosterServiceLayer service;

    public ClassRosterServiceLayerImplTest() {
        ClassRosterDao dao = new ClassRosterDaoStubImpl();
        ClassRosterAuditDAO auditDAO = new ClassRosterAuditDaoStubImpl();

        service = new ClassRosterServiceLayerImpl(dao, auditDAO);
    }

    @Test
    public void testCreateValidStudent() {
        //ARRANGE
        Student student = new Student("0002");
        student.setFirstName("Charles");
        student.setLastName("Babbage");
        student.setCohort(".NET-May-1845");

        //ACT
        try {
            service.createStudent(student); //should work
        } catch (ClassRosterDuplicateIDException
                | ClassRosterDataValidationException
                | ClassRosterPersistenceException e) {
            //ASSERT
            fail("Valid student. No exception should be thrown");
        }
    }

    @Test
    public void testCreateDuplicateIDStudent() {
        //ARRANGE
        Student student = new Student("0001");
        student.setFirstName("Charles");
        student.setLastName("Babbage");
        student.setCohort(".NET-May-1845");

        //ACT
        try {
            service.createStudent(student); //shouldn't work, should throw dupe exception
            fail("Expected Duplication Exception not throw");
        } catch (ClassRosterDataValidationException
                | ClassRosterPersistenceException e) {
            //ASSERT - we want an exception to be thrown, as we cannot add another 0002
            fail("Wrong exception thrown");
        } catch (ClassRosterDuplicateIDException e) {
            return; //what was expected
        }
    }

    @Test
    public void testCreateStudentInvalidData() throws Exception {
        //ARRANGE
        Student student = new Student("0002");
        student.setFirstName(""); //invalid input
        student.setLastName("Babbage");
        student.setCohort(".NET-May-1845");

        //ACT
        try {
            service.createStudent(student); //shouldn't work, should throw dupe exception
            fail("Expected Validation Exception not throw");
        } catch (ClassRosterDuplicateIDException
                | ClassRosterPersistenceException e) {
            //ASSERT - we want an exception to be thrown, as we cannot add another 0002
            fail("Wrong exception thrown");
        } catch (ClassRosterDataValidationException e) {
            return; //what was expected
        }
    }

    @Test
    public void testGetAllStudents() throws Exception {
        //ARRANGE
        Student testClone = new Student("0001");
        testClone.setFirstName("Ada");
        testClone.setLastName("Lovelace");
        testClone.setCohort("Java-May-1845");

        //ACT & ASSERT
        assertEquals(1, service.getAllStudents().size(), "Should only have 1 student");
        assertTrue(service.getAllStudents().contains(testClone), "This one student should be Ada");
    }

    @Test
    public void testGetStudent() throws Exception {
        //ARRANGE
        Student testClone = new Student("0001");
        testClone.setFirstName("Ada");
        testClone.setLastName("Lovelace");
        testClone.setCohort("Java-May-1845");

        //ACT & ASSERT
        Student shouldBeAda = service.getStudent("0001");
        assertNotNull(shouldBeAda, "Getting 0001 should not be null");
        assertEquals(testClone, shouldBeAda, "Student stored under 0001 should be Ada");

        Student shouldBeNull = service.getStudent("0042");
        assertNull(shouldBeNull, "Getting 0042 should be null");
    }

    @Test
    public void testRemoveStudent() throws Exception {
        //ARRANGE
        Student testClone = new Student("0001");
        testClone.setFirstName("Ada");
        testClone.setLastName("Lovelace");
        testClone.setCohort("Java-May-1845");

        //ACT & ASSERT
        Student shouldBeAda = service.removeStudent("0001");
        assertNotNull(shouldBeAda, "Removing 0001 should not be null");
        assertEquals(testClone, shouldBeAda, "Student removed from 0001 should be Ada");

        Student shouldBeNull = service.removeStudent("0042");
        assertNull(shouldBeNull, "Removing 0042 should be null");
    }
}
