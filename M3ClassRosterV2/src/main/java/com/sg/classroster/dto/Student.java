/*
This is the DTO that holds all the Student info.
 */
package com.sg.classroster.dto;

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

}
