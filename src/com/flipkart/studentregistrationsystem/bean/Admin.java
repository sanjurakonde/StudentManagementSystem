package com.flipkart.studentregistrationsystem.bean;

/**
 * The type Admin.
 */
public class Admin extends User {
    private int adminId;
    private String name;
    private String gender;

    /**
     * Gets admin id.
     *
     * @return the admin id
     */
    public int getAdminId() {
        return adminId;
    }

    /**
     * Sets admin id.
     *
     * @param adminId the admin id
     */
    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets gender.
     *
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets gender.
     *
     * @param gender the gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
}
