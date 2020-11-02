package com.flipkart.studentregistrationsystem.app;

import com.flipkart.studentregistrationsystem.bean.Admin;
import com.flipkart.studentregistrationsystem.bean.Professor;
import com.flipkart.studentregistrationsystem.bean.Student;
import com.flipkart.studentregistrationsystem.exceptions.UserNotFoundException;
import com.flipkart.studentregistrationsystem.service.*;
import com.flipkart.studentregistrationsystem.utils.DBUtils;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class SMSApp {
    private static Logger logger = Logger.getLogger(SMSApp.class);
    static Scanner scanner = new Scanner(System.in);

    public static boolean loggedIn;
    public static boolean showMenu;

    public static void main(String args[])
    {
        logger.info("*** Welcome to Student Management System ***");
        try {
            SMSApp.showMainUserMenu();
        } catch (UserNotFoundException exception) {
            exception.printStackTrace();
        }
        logger.info("**See you later, Bye**");
        scanner.close();
    }

    /*
     Show menu for user
     */
    public static void showMainUserMenu() throws UserNotFoundException {
        showMenu = true;
        int choice;
        do {
            logger.info("Enter 1 to login");
            logger.info("Enter 2  to register as a Student");
            logger.info("Enter 3  to register as a Professor");
            logger.info("Enter 4  to register as a Admin");
            logger.info("Enter any other number to exit ");
            choice = Integer.parseInt(scanner.nextLine());
            switch(choice) {
                case 1:
                    new SMSApp().login();
                    break;

                case 2:
                    try {
                        new SMSApp().registerStudent();
                        break;
                    }catch(Exception e) {
                        logger.error(e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        new SMSApp().registerProfessor();
                        break;
                    }catch(Exception e) {
                        logger.error(e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        new SMSApp().registerAdmin();
                        break;
                    }catch(Exception e) {
                        logger.error(e.getMessage());
                    }
                    break;
                default:
                    showMenu = false;
                    loggedIn = false;
                    DBUtils.closeConnection();
                    logger.error("--------------------Exiting--------------------");
                    break;
            }
        }while(showMenu);
    }

    /*
     Gathers required information to register a student
     */
    public void registerStudent() {
        Student student = new Student();
        logger.info("Enter student name");
        student.setStudentName(scanner.nextLine());
        logger.info("Enter student's user name");
        student.setUserName(scanner.nextLine());
        logger.info("Enter password");
        String password = scanner.nextLine();
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

        Authenticate authenticate = new AuthenticateImpl();
        authenticate.registerStudent(student, password);

    }
    /*
    Gathers information for registering a professor
     */
    public void registerProfessor()
    {
        Professor professor = new Professor();
        logger.info("Enter professor name:");
        professor.setName(scanner.nextLine());
        logger.info("Enter professor username:");
        professor.setUserName(scanner.nextLine());
        logger.info("Enter password");
        String password = scanner.nextLine();
        logger.info("Enter gender: 'm' for male and 'f' for female");
        professor.setGender(scanner.nextLine());

        Authenticate authenticate = new AuthenticateImpl();
        authenticate.registerProfessor(professor, password);
    }

    /*
    Gather information for registering an Admin
     */
    public void registerAdmin()
    {
        Admin admin = new Admin();
        logger.info("Enter admin username:");
        admin.setUserName(scanner.nextLine());
        logger.info("Enter admin name:");
        admin.setName(scanner.nextLine());
        logger.info("Enter password");
        String password = scanner.nextLine();
        logger.info("Enter gender: 'm' for male and 'f' for female");
        admin.setGender(scanner.nextLine());

        Authenticate authenticate = new AuthenticateImpl();
        authenticate.registerAdmin(admin, password);
    }

    /*
      Gathers username and password for logging in a user
     */
    public void login() throws UserNotFoundException {
//		boolean loggedOut = true;
        do {
            logger.info("Enter username");
            String username = scanner.nextLine();
            logger.info("Enter password");
            String password = scanner.nextLine();
            logger.info("Select Role: Enter 1 for Student, 2 for Professor, 3 for Admin: ");
            int role = scanner.nextInt();
            Authenticate authenticate = new AuthenticateImpl();
            try {
                String roleType = authenticate.logIn(username,password);

                //logger.info("Successfully logged in as " + role);
                //logger.info("Logged in at: " + DateTimeUtil.getDateTime());
                switch(role) {
                    case 1:
                        if(roleType == "Student")
                        {
                            loggedIn = true;
                        } else {
                            logger.error("Login failed!!, please try again");
                            break;
                        }
                        logger.info("Successfully logged in as Student");
                        StudentClient studentClient = new StudentClient();
                        StudentService studentService = new StudentServiceImpl();

                        // get student details from db
                        Student student = studentService.getStudentDetails(username);

                        // displayMenu and perform student menu operations
                        studentClient.displayMenu(student);
                        break;

                    case 2:
                        if(roleType == "Professor")
                        {
                            loggedIn = true;
                        } else {
                            logger.error("Login failed!!, please try again");
                            break;
                        }
                        logger.info("Successfully logged in as Professor");
                        ProfessorClient professorClient = new ProfessorClient();
                        ProfessorService professorService = new ProfessorServiceImpl();

                        // get professor details from db
                        Professor professor = professorService.getProfessorDetails(username);

                        // displayMenu and perform professor menu operations
                        professorClient.displayMenu(professor);
                        break;

                    case 3:
                        if(roleType == "Admin")
                        {
                            loggedIn = true;
                        } else {
                            logger.error("Login failed!!, please try again");
                            break;
                        }
                        logger.info("Successfully logged in as Admin");
                        AdminClient adminClient = new AdminClient();
                        adminClient.displayMenu();
                        break;

                    default:
                        logger.debug("No such user");
                        SMSApp.logout();
                }

            } catch (Exception e) {
                logger.error(e.getMessage());
            }

        }while(loggedIn);
    }

    /*
     Logout method
     */
    public static void logout() {
        SMSApp.loggedIn = false;
        //logger.info("--------------------Logged out at: " + DateTimeUtil.getDateTime() + "--------------------");
        try {
            SMSApp.showMainUserMenu();
        } catch (UserNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
