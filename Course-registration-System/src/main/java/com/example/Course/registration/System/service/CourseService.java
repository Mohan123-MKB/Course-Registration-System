package com.example.Course.registration.System.service;

import com.example.Course.registration.System.model.Course;
import com.example.Course.registration.System.model.CourseRegistry;
import com.example.Course.registration.System.repository.CourseRegistryRepo;
import com.example.Course.registration.System.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service //all objects are available in IOC container for course service so just injecting in controller
public class CourseService {

    @Autowired
    CourseRepo courseRepo;

    @Autowired
    CourseRegistryRepo courseRegistryRepo; //it is interface so all object is available in IOC container
    // because spring will create object for that interface and inside create class who implements interface
    // then create objects for that class that only inject by AutoWired.
    public List<Course> availableCourses() {
        return courseRepo.findAll();
        //data get from database with help of JPA so this will return to controller layer
        //then controller layer will return data to clients
    }

    public List<CourseRegistry> enrolledStudents() {
        return courseRegistryRepo.findAll();//to get list of course registry
    }

    public void enrollCourse(String name, String emailId, String courseName) {
        CourseRegistry courseRegistry=new CourseRegistry(name,emailId,courseName);
        courseRegistryRepo.save(courseRegistry); //from user enter details will be stored and saved in database through repository
    }
}
