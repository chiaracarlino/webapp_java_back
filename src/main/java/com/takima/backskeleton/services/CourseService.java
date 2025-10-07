package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.UserDao;
import com.takima.backskeleton.models.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseService {
    private final UserDao courseDao;

    public CourseService(UserDao courseDao) {
        this.courseDao = courseDao;
    }

    public List<User> findAll() {
        return courseDao.findAll();
    }
}
