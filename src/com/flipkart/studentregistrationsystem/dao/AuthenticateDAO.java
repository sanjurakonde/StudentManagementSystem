package com.flipkart.studentregistrationsystem.dao;

import com.flipkart.studentregistrationsystem.bean.Admin;
import com.flipkart.studentregistrationsystem.bean.Professor;
import com.flipkart.studentregistrationsystem.bean.Student;
import com.flipkart.studentregistrationsystem.bean.User;

public interface AuthenticateDAO {
    String logIn(String username, String password);
    void logOut(User user);
    void registerStudent(Student student, String password);
    void registerProfessor(Professor professor, String password);
    public void registerAdmin(Admin admin, String password);
}
