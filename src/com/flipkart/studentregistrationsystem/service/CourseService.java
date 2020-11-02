package com.flipkart.studentregistrationsystem.service;

import com.flipkart.studentregistrationsystem.bean.Course;

import java.util.List;

/**
 * The interface Course service.
 */
public interface CourseService {
    /**
     * View course.
     *
     * @param course the course
     */
    void viewCourse(Course course);

    /**
     * List courses.
     */
    void listCourses();
}
