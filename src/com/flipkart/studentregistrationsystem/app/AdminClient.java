package com.flipkart.studentregistrationsystem.app;

import com.flipkart.studentregistrationsystem.bean.Admin;
import com.flipkart.studentregistrationsystem.bean.Course;
import com.flipkart.studentregistrationsystem.bean.Professor;
import com.flipkart.studentregistrationsystem.bean.Student;
import com.flipkart.studentregistrationsystem.service.*;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class AdminClient {
    private static Logger logger = Logger.getLogger(AdminClient.class);
    AdminService adminService = new AdminServiceImpl();
    Authenticate authenticate = new AuthenticateImpl();
    CourseService courseService = new CourseServiceImpl();
    Scanner scanner = new Scanner(System.in);

    /*
     Display menu for the admin
     */
    public void displayMenu() {

        int choice;
        do {
            showChoices();
            choice = scanner.nextInt();
            scanner.nextLine();
            logger.info(choice);
            switch(choice) {
                case 1:
                    courseService.listCourses();
                    break;
                case 2:
                    adminService.viewUsers();
                    break;
                case 3:
                    assignProfessor();
                    break;
                case 4:
                    registerNewUser();
                    break;
                case 5:
                    deleteUser();
                    break;
                case 6:
                    addNewCourse();
                    break;
                case 7:
                    deleteCourse();
                    break;
                case 0:
                    SMSApp.logout();
            }

        }while(SMSApp.loggedIn);
        scanner.close();
    }

    /*
     Show available choices
     */
    void showChoices() {
        logger.info("Enter your choice:");
        logger.info("1. To view courses in catalog");
        logger.info("2. To view users");
        logger.info("3. Assign course to a professor");
        logger.info("4. Register a new user");
        logger.info("5. Delete a user");
        logger.info("6. Add a new course to catalog");
        logger.info("7. Drop a course from catalog");
        logger.info("0. To logout");
    }

    /*
     Gather required inputs to assign a course with a professor
     */
    void assignProfessor() {

        logger.info("Enter professor Id");
        int professorId = Integer.parseInt(scanner.nextLine());
        Professor professor = new Professor();
        professor.setProfessorId(professorId);
        logger.info("Enter course Id");
        int courseId = Integer.parseInt(scanner.nextLine());

        adminService.assignProfessor(professor, courseId);
    }

    /*
     Gather required inputs to add new courses
     */
    void addNewCourse() {

        Course course = new Course();
        logger.info("Enter course Id");
        int courseId = Integer.parseInt(scanner.nextLine());
        course.setCourseId(courseId);
        logger.info("Enter course Name");
        String courseName = scanner.nextLine();
        course.setCourseName(courseName);
        logger.info("Enter catalog Id");
        int catalogId = Integer.parseInt(scanner.nextLine());
        course.setCatalogId(catalogId);
        logger.info("Enter Description");
        String description = scanner.nextLine();
        course.setDescription(description);
        logger.info("Enter fee for the course");
        int fees = Integer.parseInt(scanner.nextLine());
        course.setFee(fees);

        adminService.addCourse(course);
    }

    /*
     Gather course id to delete a course
     */
    void deleteCourse() {
        logger.info("Enter course Id");
        Course course = new Course();
        int courseId = Integer.parseInt(scanner.nextLine());
        course = new Course();
        course.setCourseId(courseId);
        adminService.deleteCourse(course);
    }

    /*
     Gather required inputs to add a new user
     */
    void registerNewUser() {

        logger.info("Enter 1 to add a new admin");
        logger.info("Enter 2 to add a new professor");
        logger.info("Enter 3 to add a new student");
        int option = Integer.parseInt(scanner.nextLine());
        String password;
        switch(option) {

            case 1:
                Admin admin = new Admin();
                logger.info("Enter admin username:");
                admin.setUserName(scanner.nextLine());
                logger.info("Enter admin name:");
                admin.setName(scanner.nextLine());
                logger.info("Enter password");
                password = scanner.nextLine();
                logger.info("Enter gender: 'm' for male and 'f' for female");
                String gender = scanner.nextLine();
                if(gender.equals("m")) {
                    admin.setGender("male");
                }
                else {
                    admin.setGender("female");
                }
                authenticate.registerAdmin(admin, password);
                break;

            case 2:
                Professor professor = new Professor();
                logger.info("Enter professor name:");
                professor.setName(scanner.nextLine());
                logger.info("Enter professor username:");
                professor.setUserName(scanner.nextLine());
                logger.info("Enter password");
                password = scanner.nextLine();
                logger.info("Enter gender: 'm' for male and 'f' for female");
                gender = scanner.nextLine();
                if(gender.equals("m")) {
                    professor.setGender("male");
                }
                else {
                    professor.setGender("female");
                }

                authenticate.registerProfessor(professor, password);
                break;

            case 3:
                Student student = new Student();
                logger.info("Enter student name");
                student.setStudentName(scanner.nextLine());
                logger.info("Enter student's user name");
                student.setUserName(scanner.nextLine());
                logger.info("Enter password");
                password = scanner.nextLine();
                logger.info("Enter gender: 'm' for male and 'f' for female");
                student.setGender(scanner.nextLine());
                logger.info("Enter semester:");
                student.setSemester(Integer.parseInt(scanner.nextLine()));
                logger.info("If you have scholarship enter 1, else enter 0");
                int scholarShip = Integer.parseInt(scanner.nextLine());
                if(scholarShip == 1)
                    student.setHasScholarship(true);
                else
                    student.setHasScholarship(false);
                authenticate.registerStudent(student, password);
                break;
        }
    }

    /*
    deletes the user
     */
    void deleteUser() {
        logger.info("Enter user id:");
        AdminService adminService = new AdminServiceImpl();
        adminService.deleteUser(Integer.parseInt(scanner.nextLine()));
    }
}
