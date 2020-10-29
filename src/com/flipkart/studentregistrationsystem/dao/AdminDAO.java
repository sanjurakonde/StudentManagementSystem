package com.flipkart.studentregistrationsystem.dao;

import com.flipkart.studentregistrationsystem.bean.Course;
import com.flipkart.studentregistrationsystem.bean.Professor;
import com.flipkart.studentregistrationsystem.bean.User;

import java.util.ArrayList;

public interface AdminDAO {
    boolean approveUser(User user);
    boolean deleteUser(int userId);
    boolean addCourse(Course course);
    boolean deleteCourse(Course course);
    ArrayList<User> viewUsers();
    void assignProfessor(Professor professor, int courseId);
}
