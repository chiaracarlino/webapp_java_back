package com.takima.backskeleton.controllers;

import com.takima.backskeleton.models.User;
import com.takima.backskeleton.services.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequestMapping("courses")
@RestController
public class CourseController {
    private final UserService courseService;

    public CourseController(UserService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("")
    public List<User> getAllCourses() {
        return courseService.findAll();
    }
}
