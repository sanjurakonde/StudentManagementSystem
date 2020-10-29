package com.flipkart.studentregistrationsystem.service;

import com.flipkart.studentregistrationsystem.bean.Course;
import com.flipkart.studentregistrationsystem.bean.Professor;
import com.flipkart.studentregistrationsystem.bean.User;

import java.util.ArrayList;

public interface AdminService {
    boolean approveUser(User user);
    boolean deleteUser(int userId);
    boolean addCourse(Course course);
    boolean deleteCourse(Course course);
    void assignProfessor(Professor professor, int courseId);
    void viewUsers();
}
