package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.UserDao;
import com.takima.backskeleton.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDao userDAO;

    // CRUD simple

    public User createUser(User user) {
        return userDAO.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userDAO.findById(id);
    }

    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    public User patchUser(Long id, User partialUser) {
        User existingUser = userDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (partialUser.getFirstName() != null) {
            existingUser.setFirstName(partialUser.getFirstName());
        }
        if (partialUser.getLastName() != null) {
            existingUser.setLastName(partialUser.getLastName());
        }
        if (partialUser.getEmail() != null) {
            existingUser.setEmail(partialUser.getEmail());
        }
        if (partialUser.getPassword() != null) {
            existingUser.setPassword(partialUser.getPassword());
        }

        return userDAO.save(existingUser);
    }


    public void deleteUser(Long id) {
        userDAO.deleteById(id);
    }

    public User updateUser(User user) {
        return userDAO.save(user); // save fait update si id existant
    }
}
