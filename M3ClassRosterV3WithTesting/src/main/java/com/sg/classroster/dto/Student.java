/*
This is the DTO that holds all the Student info.
 
now with methods for testing
*/
package com.sg.classroster.dto;

import java.util.Objects;

/**
 *
 * @author Narish
 */
public class Student {

    /*fields*/
    private String firstName;
    private String lastName;
    private String studentID;
    private String cohort; //language + cohort month/yr

    /*ctor*/
    public Student(String studentID) {
        this.studentID = studentID;
    }

    /*getter/setter*/
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCohort() {
        return cohort;
    }

    public void setCohort(String cohort) {
        this.cohort = cohort;
    }

    /*getter - read only*/
    public String getStudentID() {
        return studentID;
    }

    /*Testing methods*/
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.firstName);
        hash = 89 * hash + Objects.hashCode(this.lastName);
        hash = 89 * hash + Objects.hashCode(this.studentID);
        hash = 89 * hash + Objects.hashCode(this.cohort);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.studentID, other.studentID)) {
            return false;
        }
        if (!Objects.equals(this.cohort, other.cohort)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Student{" + "firstName=" + firstName + ", lastName=" + lastName
                + ", studentID=" + studentID + ", cohort=" + cohort + '}';
    }

}
