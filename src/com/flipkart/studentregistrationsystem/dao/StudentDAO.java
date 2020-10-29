package com.flipkart.studentregistrationsystem.dao;

import com.flipkart.studentregistrationsystem.bean.Course;
import com.flipkart.studentregistrationsystem.bean.Student;
import com.flipkart.studentregistrationsystem.exceptions.CourseNotFoundException;

import java.util.ArrayList;
import java.util.Map;

public interface StudentDAO {
    ArrayList<Course> viewRegisteredCourses(Student student);
    void selectCourse(Student student, int courseId) throws CourseNotFoundException;
    void dropCourse(int courseId, int studentId) throws CourseNotFoundException;
    int numberOfRegisteredCourse(Student student);
    Map<String, String> viewGrades(Student student);
    int calculateTotalFee(Student student);
    String makePayment(Student student, int paymentMethod, int fees);
    Student getStudentDetails(String name);
}
