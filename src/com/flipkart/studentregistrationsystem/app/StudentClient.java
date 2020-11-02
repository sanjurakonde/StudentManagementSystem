package com.flipkart.studentregistrationsystem.app;

import com.flipkart.studentregistrationsystem.bean.Course;
import com.flipkart.studentregistrationsystem.bean.Student;
import com.flipkart.studentregistrationsystem.exceptions.CourseNotFoundException;
import com.flipkart.studentregistrationsystem.service.CourseService;
import com.flipkart.studentregistrationsystem.service.CourseServiceImpl;
import com.flipkart.studentregistrationsystem.service.StudentService;
import com.flipkart.studentregistrationsystem.service.StudentServiceImpl;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class StudentClient {
    private static Logger logger = Logger.getLogger(StudentClient.class);

    public Student student;
    StudentService studentService = new StudentServiceImpl();
    CourseService courseService = new CourseServiceImpl();
    Scanner scanner = new Scanner(System.in);

    /*
     Displays the Student Menu with choices for student
     */
    public void displayMenu(Student student) throws CourseNotFoundException {
        int choice;
        do {
            this.student = student;
            showChoices();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    courseService.listCourses();
                    break;

                case 2:
                    chooseCourse();
                    break;

                case 3:
                    dropCourse();
                    break;

                case 4:
                    studentService.viewRegisteredCourses(student);
                    break;

                case 5:
                    payFees();
                    break;

                case 6:
                    printReportCard();
                    break;

                case 0:
                    SMSApp.logout();
            }

        }while(SMSApp.loggedIn);
        scanner.close();


    }

    /*
     Show choices
     */
    void showChoices() {
        logger.info("Enter your choice:");
        logger.info("1. To view available courses");
        logger.info("2. To choose a course");
        logger.info("3. To drop a course");
        logger.info("4. View registered courses");
        logger.info("5. Pay fees");
        logger.info("6. View grades");
        logger.info("0. To logout");
    }

    /*
     Gets course id to add for student
     */
    void chooseCourse() throws CourseNotFoundException {
        if(studentService.numberOfRegisteredCourse(student) >= 4) {
            logger.info("You cannot add courses as you have already selected 4 courses");
        }
        else {
            logger.info("Enter courseId");
            int courseId = Integer.parseInt(scanner.nextLine());
            studentService.selectCourse(student, courseId);
        }

    }

    /*
     Gets course id to delete from student's registered courses
     */
    void dropCourse() throws CourseNotFoundException {
        Course course = new Course();
        logger.info("Enter course id:");
        int courseId = Integer.parseInt(scanner.nextLine());
        course.setCourseId(courseId);
        studentService.dropCourse(courseId, student.getId());
    }

    /*
     print report card for student
     */
    void printReportCard() {
        logger.info("--------Report Card--------");
        logger.info("Course\tGrade");
        studentService.viewGrades(student);
        logger.info("---------------------------");
    }

    /*
     Get amount to be paid and make payment
     */
    void payFees() {
        int fee = studentService.calculateTotalFee(student);
        logger.info("Want to continue to pay Rs."+ fee + " press 'y' to continue...");
        if(scanner.nextLine().equals("y")) {
            logger.info("Enter 1 to pay with credit card.");
            logger.info("Enter 2 to pay with debit card.");
            logger.info("Enter 3 to pay as cash.");
            int choice = Integer.parseInt(scanner.nextLine());
            if(choice >= 1 && choice <= 3) {
                studentService.makePayment(student, choice, fee);
            }
            else {
                logger.info("Cannot do such payment!!");
            }
        }
        else {
            logger.info("Payment not done.");
        }
    }
}
