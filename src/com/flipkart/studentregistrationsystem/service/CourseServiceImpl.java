package com.flipkart.studentregistrationsystem.service;

import com.flipkart.studentregistrationsystem.bean.Course;
import com.flipkart.studentregistrationsystem.dao.CatalogueDAO;
import com.flipkart.studentregistrationsystem.dao.CatalogueDAOImpl;
import org.apache.log4j.Logger;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    CatalogueDAO catalogueDAO = new CatalogueDAOImpl();
    private static Logger logger = Logger.getLogger(CourseServiceImpl.class);
    @Override
    public void viewCourse(Course course) {
        catalogueDAO.viewCourseFromCatalog(course.getCourseId());
    }

    @Override
    public void listCourses() {
        List<Course> courses = catalogueDAO.viewCatalog();
        logger.debug("Course Id\tCourse Name\tFees\tCourse Description");

        courses.forEach(course ->  logger.info(course.getCourseId() + "\t\t" + course.getCourseName() + " \t\t"  + course.getFee() + "\t" + course.getDescription()));
    }
}
