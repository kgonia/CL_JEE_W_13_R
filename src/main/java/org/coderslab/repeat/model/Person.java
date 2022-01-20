package org.coderslab.repeat.model;

public class Person {

    public Person(String firstName, String lastName, String courseName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseName = courseName;
    }

    private String firstName;

    private String lastName;

    private String courseName;

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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
