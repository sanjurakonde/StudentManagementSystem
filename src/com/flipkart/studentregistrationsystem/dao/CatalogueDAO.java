package com.flipkart.studentregistrationsystem.dao;

import com.flipkart.studentregistrationsystem.bean.Course;

import java.util.ArrayList;

public interface CatalogueDAO {
    public ArrayList<Course> viewCatalog();
    public Course viewCourseFromCatalog(int courseId);
}
