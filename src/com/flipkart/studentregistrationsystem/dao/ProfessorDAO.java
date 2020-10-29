package com.flipkart.studentregistrationsystem.dao;

import com.flipkart.studentregistrationsystem.bean.Course;
import com.flipkart.studentregistrationsystem.bean.Professor;

import java.util.List;

public interface ProfessorDAO {
    public void viewStudents(Professor professor);
    public List<Course> getCourseTaught(Professor professor);
    public void gradeStudent(Professor professor, int courseId, int studentId, String grade );
    Professor getProfessorDetails(String username);
}
