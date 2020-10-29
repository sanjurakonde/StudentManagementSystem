package com.flipkart.studentregistrationsystem.service;

import com.flipkart.studentregistrationsystem.bean.Student;
import com.flipkart.studentregistrationsystem.exceptions.CourseNotFoundException;

public interface StudentService {
    void viewRegisteredCourses(Student student);
    void selectCourse(Student student, int courseId) throws CourseNotFoundException;
    void dropCourse(int courseId, int studentId) throws CourseNotFoundException;
    int numberOfRegisteredCourse(Student student);
    void viewGrades(Student student);
    int calculateTotalFee(Student student);
    void makePayment(Student student, int paymentMethod, int fees);
    Student getStudentDetails(String name);
}
