package com.example.Course.registration.System.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CourseRegistry {
    public CourseRegistry(String name, String courseName,String emailId) {
        this.name = name;
        this.emailId = emailId;
        this.courseName = courseName;
    }
    public CourseRegistry(){
        //default constructor
    }


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private int id;
    private String name;
    private String emailId;
    private String courseName;

    //Hibernate is fetch this data to table so getter and setter method needed
    //Data is transfer only through getter and setter

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
