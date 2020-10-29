package com.flipkart.studentregistrationsystem.exceptions;

public class UserNotFoundException extends Exception {
    public String toString()
    {
        return "User Not found!!";
    }
}
