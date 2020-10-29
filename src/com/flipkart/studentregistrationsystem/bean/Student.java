package com.flipkart.studentregistrationsystem.bean;

public class Student extends User {
    private int studentId;
    private String StudentName;
    private String address;
    private String contact;
    private boolean hasScholarship;
    private String gender;
    private int semester;
    private int isRegistered;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        this.StudentName = studentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public boolean isHasScholarship() {
        return hasScholarship;
    }

    public void setHasScholarship(boolean hasScholarship) {
        this.hasScholarship = hasScholarship;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getIsRegistered() {
        return isRegistered;
    }

    public void setIsRegistered(int isRegistered) {
        this.isRegistered = isRegistered;
    }
}
