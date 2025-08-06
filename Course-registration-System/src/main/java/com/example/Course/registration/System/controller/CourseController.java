package com.example.Course.registration.System.controller;
import com.example.Course.registration.System.model.Course;
import com.example.Course.registration.System.model.CourseRegistry;
import com.example.Course.registration.System.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController//server la irunthu data va edukarom
@CrossOrigin(origins = "http://localhost:5500")
public class CourseController {

    @Autowired //just injecting object of course service because all object is available in IOC
    CourseService courseService;

    @GetMapping("courses")// API endpoints(clients request) list of courses available in database display and show to browser/user display
    public List<Course> availableCourses(){
        return courseService.availableCourses(); //this controller layer return all available data to clients
    //this above line return all available courses to frontends/browser to user (mapping course display)
    }

    @GetMapping("courses/enrolled")//api endpoint
    public List<CourseRegistry> enrolledStudents(){
        return courseService.enrolledStudents();
    }
    @PostMapping("/courses/register")//user request data stored in server so data va server la irunthu edukarom then it enrolled student la database la store agidum.
        public String enrollCourse(@RequestParam("name") String name,
                                   @RequestParam("emailId") String emailId,
                                   @RequestParam("courseName") String courseName){
        courseService.enrollCourse(name,emailId,courseName);
        return "Congratulations! "+name+ " " +"Enrollment successful for "+courseName;
    }
}
