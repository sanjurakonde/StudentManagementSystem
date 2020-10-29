package com.flipkart.studentregistrationsystem.service;

import com.flipkart.studentregistrationsystem.bean.Course;
import com.flipkart.studentregistrationsystem.bean.Professor;
import com.flipkart.studentregistrationsystem.bean.User;
import com.flipkart.studentregistrationsystem.dao.AdminDAO;
import com.flipkart.studentregistrationsystem.dao.AdminDAOImpl;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdminServiceImpl implements AdminService {
    private static Logger logger = Logger.getLogger(AdminServiceImpl.class);
    AdminDAO adminDAO = new AdminDAOImpl();

    @Override
    public boolean approveUser(User user) {
        try {
            return adminDAO.approveUser(user);
        }catch(Exception exception) {
            logger.error(exception.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteUser(int userId) {
        try {
            return adminDAO.deleteUser(userId);
        }catch(Exception exception) {
            logger.error(exception.getMessage());
        }
        return false;
    }

    @Override
    public boolean addCourse(Course course) {
        try {
            return adminDAO.addCourse(course);
        }catch(Exception exception) {
            logger.error(exception.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteCourse(Course course) {
        try {
            return adminDAO.deleteCourse(course);
        }catch(Exception exception) {
            logger.error(exception.getMessage());
        }
        return false;
    }

    @Override
    public void assignProfessor(Professor professor, int courseId) {
        try {
            adminDAO.assignProfessor(professor, courseId);
        }catch(Exception exception) {
            logger.error(exception.getMessage());
        }
    }

    @Override
    public void viewUsers() {
        try {
            List<User> userList = adminDAO.viewUsers();
            logger.info("--Professors are:--");
            printUsersBasedOnRole(userList, "Professor");

            logger.info("--Students are:--");
            printUsersBasedOnRole(userList, "Student");

            logger.info("--Admins are:--");
            printUsersBasedOnRole(userList, "Admin");
        }catch(Exception exception) {
            logger.error(exception.getMessage());
        }
    }

    public void printUsersBasedOnRole(List<User> userList, String role) {
        userList.stream().filter(user -> user.getRole().equals(role))
                .collect(Collectors.toList())
                .forEach(user -> logger.info(user.getId() + "\t" + user.getUserName()));
    }
}
