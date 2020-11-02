package com.flipkart.studentregistrationsystem.app;

import com.flipkart.studentregistrationsystem.bean.Professor;
import com.flipkart.studentregistrationsystem.service.CourseService;
import com.flipkart.studentregistrationsystem.service.CourseServiceImpl;
import com.flipkart.studentregistrationsystem.service.ProfessorService;
import com.flipkart.studentregistrationsystem.service.ProfessorServiceImpl;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class ProfessorClient {
    private static Logger logger = Logger.getLogger(ProfessorClient.class);
    ProfessorService professorService = new ProfessorServiceImpl();
    CourseService courseService = new CourseServiceImpl();
    Scanner scanner = new Scanner(System.in);

    /*
     Display menu for professor
     */
    public void displayMenu(Professor professor) {

        int choice;
        do {
            logger.info("Enter your choice:");
            logger.info("1. To view available courses");
            logger.info("2. To view courses taught");
            logger.info("3. To view students in a course");
            logger.info("4. Grade a student");
            logger.info("0. To logout");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    courseService.listCourses();
                    break;
                case 2:
                    professorService.getCourseTaught(professor);
                    break;
                case 3:
                    professorService.viewStudents(professor);
                    break;
                case 4:
                    logger.info("Enter course Id: ");
                    int courseId = Integer.parseInt(scanner.nextLine());

                    logger.info("Enter student Id: ");
                    int studentId = Integer.parseInt(scanner.nextLine());
                    logger.info("Enter grades:");
                    String grades = scanner.nextLine();
                    professorService.gradeStudent(professor, courseId, studentId, grades);
                    break;
                case 0:
                    SMSApp.logout();
            }

        } while (SMSApp.loggedIn);
        scanner.close();
    }
}
