package com.jtdev.all_study;

public class DatabaseTeacher {

    private String TeacherID;
    private String fullTeacherName;
    private String teacherEmailAddress;
    private String teacherPassword;

    public String getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(String teacherID) {
        TeacherID = teacherID;
    }

    public String getFullTeacherName() {
        return fullTeacherName;
    }

    public void setFullTeacherName(String fullTeacherName) {
        this.fullTeacherName = fullTeacherName;
    }

    public String getTeacherEmailAddress() {
        return teacherEmailAddress;
    }

    public void setTeacherEmailAddress(String teacherEmailAddress) {
        this.teacherEmailAddress = teacherEmailAddress;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    public DatabaseTeacher(String teacherID, String fullTeacherName, String teacherEmailAddress, String teacherPassword) {
        this.TeacherID = teacherID;
        this.fullTeacherName = fullTeacherName;
        this.teacherEmailAddress = teacherEmailAddress;
        this.teacherPassword = teacherPassword;
    }
}
