package com.flipkart.studentregistrationsystem.service;

import com.flipkart.studentregistrationsystem.bean.Course;
import com.flipkart.studentregistrationsystem.bean.Student;
import com.flipkart.studentregistrationsystem.dao.StudentDAO;
import com.flipkart.studentregistrationsystem.dao.StudentDAOImpl;
import com.flipkart.studentregistrationsystem.exceptions.CourseNotFoundException;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class StudentServiceImpl implements StudentService {
    private static Logger logger = Logger.getLogger(StudentServiceImpl.class);
    StudentDAO studentDAO = new StudentDAOImpl();
    @Override
    public void viewRegisteredCourses(Student student) {
        ArrayList<Course> courseList = studentDAO.viewRegisteredCourses(student);
        if(courseList.size() == 0) {
            logger.info("No registered courses");
        }
        else {
            logger.info("Course Id\tCourse Name");
            courseList.forEach(course -> logger.info(course.getCourseId() +  "\t\t " + course.getCourseName()));
        }
    }

    @Override
    public void selectCourse(Student student, int courseId) throws CourseNotFoundException {
        try {
            studentDAO.selectCourse(student, courseId);
        }catch(CourseNotFoundException exception) {
            logger.error(exception.getMessage());
        }catch(Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void dropCourse(int courseId, int studentId) throws CourseNotFoundException {
        try {
            studentDAO.dropCourse(courseId, studentId);
        }catch(CourseNotFoundException exception) {
            logger.error(exception.getMessage());
        }catch(Exception e) {
            logger.error(e.getMessage());
        }

    }

    @Override
    public int numberOfRegisteredCourse(Student student) {
        return studentDAO.numberOfRegisteredCourse(student);
    }

    @Override
    public void viewGrades(Student student) {
        studentDAO.viewGrades(student).forEach(
                (k,v) -> logger.info(k + "\t" + v)
        );
    }

    @Override
    public int calculateTotalFee(Student student) {
        return studentDAO.calculateTotalFee(student);
    }

    @Override
    public void makePayment(Student student, int paymentMethod, int fees) {
        logger.info(studentDAO.makePayment(student, paymentMethod, fees));
    }

    @Override
    public Student getStudentDetails(String name) {
        return studentDAO.getStudentDetails(name);
    }
}
