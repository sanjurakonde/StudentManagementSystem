package com.flipkart.studentregistrationsystem.service;

import com.flipkart.studentregistrationsystem.bean.Admin;
import com.flipkart.studentregistrationsystem.bean.Professor;
import com.flipkart.studentregistrationsystem.bean.Student;
import com.flipkart.studentregistrationsystem.bean.User;
import com.flipkart.studentregistrationsystem.dao.AuthenticateDAO;
import com.flipkart.studentregistrationsystem.dao.AuthenticateDAOImpl;

public class AuthenticateImpl implements  Authenticate {

    AuthenticateDAO authenticate = new AuthenticateDAOImpl();
    @Override
    public String logIn(String username, String password) {
        return authenticate.logIn(username, password);
    }

    @Override
    public void logOut(User user) {
        authenticate.logOut(user);
    }

    @Override
    public void registerStudent(Student student, String password) {
        authenticate.registerStudent(student, password);
    }

    @Override
    public void registerProfessor(Professor professor, String password) {
        authenticate.registerProfessor(professor, password);
    }

    @Override
    public void registerAdmin(Admin admin, String password) {
        authenticate.registerAdmin(admin, password);
    }
}
