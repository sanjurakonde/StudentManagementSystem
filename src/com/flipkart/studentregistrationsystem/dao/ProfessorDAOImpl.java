package com.flipkart.studentregistrationsystem.dao;

import com.flipkart.studentregistrationsystem.bean.Course;
import com.flipkart.studentregistrationsystem.bean.Professor;
import com.flipkart.studentregistrationsystem.bean.Student;
import com.flipkart.studentregistrationsystem.constant.SQLQueriesConstants;
import com.flipkart.studentregistrationsystem.exceptions.UserNotFoundException;
import com.flipkart.studentregistrationsystem.utils.DBUtils;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAOImpl implements ProfessorDAO {
    private static Logger logger = Logger.getLogger(ProfessorDAOImpl.class);
    static Connection connection = DBUtils.getConnection();

    /*
    view details of students who are taught by a particular professor
     */
    @Override
    public void viewStudents(Professor professor) {
        PreparedStatement stmt = null;
        List<Student> studentList = new ArrayList<Student>();

        try {
            stmt = connection.prepareStatement(SQLQueriesConstants.GET_STUDENTS_TAUGHT);
            stmt.setInt(1, professor.getProfessorId());
            ResultSet rs = stmt.executeQuery();
            if(rs != null) {
                logger.info("--------------Student List--------------");
                logger.info("Course Id \t Student Id\tStudent Name\tgender\tSemester");
                while(rs.next()) {
                    logger.info(rs.getInt("courseId") + "\t\t" + rs.getInt("studentId") + "\t\t" + rs.getString("studentName") + "\t\t" + rs.getString("gender") + "\t" + rs.getInt("semester"));
                }
                logger.info("----------------------------------------");
            }
        }catch(SQLException se){
            logger.error(se.getMessage());
        }catch(Exception e){
            logger.error(e.getMessage());
        }
    }

    /*
    returns a list of courses which are taught by a particular professor
     */
    @Override
    public List<Course> getCourseTaught(Professor professor) {
        List<Course> courseList = new ArrayList<Course>();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(SQLQueriesConstants.GET_COURSE_TAUGHT_BY_PROFESSOR);
            stmt.setInt(1, professor.getProfessorId());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                Course course = new Course();
                course.setCourseId(rs.getInt(1));
                course.setCourseName(rs.getString(2));
                course.setDescription(rs.getString(3));
                courseList.add(course);
            }

        }catch(SQLException se){
            logger.error(se.getMessage());
        }catch(Exception e){
            logger.error(e.getMessage());
        }
        return courseList;
    }

    /*
    grade student for a course
     */
    @Override
    public void gradeStudent(Professor professor, int courseId, int studentId, String grade) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(SQLQueriesConstants.GRADE_STUDENT_QUERY);
            stmt.setString(1, grade);
            stmt.setInt(2, studentId);
            stmt.setInt(3, courseId);
            int rowsUpdated = stmt.executeUpdate();
            if(rowsUpdated > 0) {
                logger.info("Uploaded grade");
            }
            else {
                logger.info("Couldn't upload try again");
            }
            stmt.close();
        }catch(SQLException se){
            logger.error(se.getMessage());
        }catch(Exception e){
            logger.error(e.getMessage());
        }
    }

    @Override
    public Professor getProfessorDetails(String username) {
        Professor professor = new Professor();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(SQLQueriesConstants.GET_PROFESSOR_DETAILS_QUERY);
            stmt.setString(1,username);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                professor.setName(rs.getString(2));
                professor.setProfessorId(rs.getInt(1));
                professor.setGender(rs.getString(3));
            }
            else {
                throw new UserNotFoundException();
            }

        }catch(SQLException se){
            logger.error(se.getMessage());
        }catch(UserNotFoundException ue) {
            logger.error(ue.getMessage());
        }catch(Exception e){
            logger.error(e.getMessage());
        }
        return professor;
    }
}
