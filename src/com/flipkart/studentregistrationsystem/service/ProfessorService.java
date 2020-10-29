package com.flipkart.studentregistrationsystem.service;

import com.flipkart.studentregistrationsystem.bean.Professor;
//add public to all the methods in interface
//write comments everywhere
public interface ProfessorService {
    public void viewStudents(Professor professor);
    void getCourseTaught(Professor professor);
    void gradeStudent(Professor professor, int courseId, int studentId, String grade);
    Professor getProfessorDetails(String username);
}
