package com.example.Course.registration.System.repository;

import com.example.Course.registration.System.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course,String> {//<Entity type,primary key>
}
