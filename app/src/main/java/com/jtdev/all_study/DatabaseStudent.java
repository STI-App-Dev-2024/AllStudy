package com.jtdev.all_study;

public class DatabaseStudent {
    private String StudentID;
    private String fullName;
    private String emailAddress;
    private String Password;

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public DatabaseStudent(String studentID, String fullName, String emailAddress, String password) {
        this.StudentID = studentID;
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        Password = password;
    }
}
