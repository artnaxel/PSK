package org.vu.pskdemo.mybatis.model;

public class StudentGroup {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.STUDENTGROUP.ID
     *
     * @mbg.generated Mon Mar 04 22:39:08 EET 2024
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.STUDENTGROUP.CAPACITY
     *
     * @mbg.generated Mon Mar 04 22:39:08 EET 2024
     */
    private Integer capacity;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.STUDENTGROUP.GRADE
     *
     * @mbg.generated Mon Mar 04 22:39:08 EET 2024
     */
    private Integer grade;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.STUDENTGROUP.TITLE
     *
     * @mbg.generated Mon Mar 04 22:39:08 EET 2024
     */
    private String title;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.STUDENTGROUP.ID
     *
     * @return the value of PUBLIC.STUDENTGROUP.ID
     *
     * @mbg.generated Mon Mar 04 22:39:08 EET 2024
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.STUDENTGROUP.ID
     *
     * @param id the value for PUBLIC.STUDENTGROUP.ID
     *
     * @mbg.generated Mon Mar 04 22:39:08 EET 2024
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.STUDENTGROUP.CAPACITY
     *
     * @return the value of PUBLIC.STUDENTGROUP.CAPACITY
     *
     * @mbg.generated Mon Mar 04 22:39:08 EET 2024
     */
    public Integer getCapacity() {
        return capacity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.STUDENTGROUP.CAPACITY
     *
     * @param capacity the value for PUBLIC.STUDENTGROUP.CAPACITY
     *
     * @mbg.generated Mon Mar 04 22:39:08 EET 2024
     */
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.STUDENTGROUP.GRADE
     *
     * @return the value of PUBLIC.STUDENTGROUP.GRADE
     *
     * @mbg.generated Mon Mar 04 22:39:08 EET 2024
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.STUDENTGROUP.GRADE
     *
     * @param grade the value for PUBLIC.STUDENTGROUP.GRADE
     *
     * @mbg.generated Mon Mar 04 22:39:08 EET 2024
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.STUDENTGROUP.TITLE
     *
     * @return the value of PUBLIC.STUDENTGROUP.TITLE
     *
     * @mbg.generated Mon Mar 04 22:39:08 EET 2024
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.STUDENTGROUP.TITLE
     *
     * @param title the value for PUBLIC.STUDENTGROUP.TITLE
     *
     * @mbg.generated Mon Mar 04 22:39:08 EET 2024
     */
    public void setTitle(String title) {
        this.title = title;
    }
}