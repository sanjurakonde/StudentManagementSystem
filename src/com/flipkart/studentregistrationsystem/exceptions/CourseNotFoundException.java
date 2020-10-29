package com.flipkart.studentregistrationsystem.exceptions;

public class CourseNotFoundException extends Exception {
    public String toString()
    {
        return "Course not found!";
    }
}
