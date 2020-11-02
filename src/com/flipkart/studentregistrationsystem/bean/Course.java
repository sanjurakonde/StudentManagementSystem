package com.flipkart.studentregistrationsystem.bean;

/**
 * The type Course.
 */
public class Course {
    private String courseName;
    private int courseId;
    private String duration;
    private String description;
    private int fee;
    private int catalogId;

    /**
     * Gets course name.
     *
     * @return the course name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets course name.
     *
     * @param courseName the course name
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Gets duration.
     *
     * @return the duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Sets duration.
     *
     * @param duration the duration
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets fee.
     *
     * @return the fee
     */
    public int getFee() {
        return fee;
    }

    /**
     * Sets fee.
     *
     * @param fee the fee
     */
    public void setFee(int fee) {
        this.fee = fee;
    }

    /**
     * Gets course id.
     *
     * @return the course id
     */
    public int getCourseId() {
        return courseId;
    }

    /**
     * Sets course id.
     *
     * @param courseId the course id
     */
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    /**
     * Gets catalog id.
     *
     * @return the catalog id
     */
    public int getCatalogId() {
        return catalogId;
    }

    /**
     * Sets catalog id.
     *
     * @param catalogId the catalog id
     */
    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }
}
