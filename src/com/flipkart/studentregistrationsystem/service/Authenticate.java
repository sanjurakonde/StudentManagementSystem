package com.flipkart.studentregistrationsystem.service;

import com.flipkart.studentregistrationsystem.bean.Admin;
import com.flipkart.studentregistrationsystem.bean.Professor;
import com.flipkart.studentregistrationsystem.bean.Student;
import com.flipkart.studentregistrationsystem.bean.User;

/**
 * The interface Authenticate.
 */
public interface Authenticate {
    /**
     * Log in string.
     *
     * @param username the username
     * @param password the password
     * @return the string
     */
    String logIn(String username, String password);

    /**
     * Log out.
     *
     * @param user the user
     */
    void logOut(User user);

    /**
     * Register student.
     *
     * @param student  the student
     * @param password the password
     */
    void registerStudent(Student student, String password);

    /**
     * Register professor.
     *
     * @param professor the professor
     * @param password  the password
     */
    void registerProfessor(Professor professor, String password);

    /**
     * Register admin.
     *
     * @param admin    the admin
     * @param password the password
     */
    public void registerAdmin(Admin admin, String password);
}
