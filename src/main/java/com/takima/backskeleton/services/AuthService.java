package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.UserDao;
import com.takima.backskeleton.DTO.UserDto;
import com.takima.backskeleton.models.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final UserDao userDao;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthService(UserDao userDao) {
        this.userDao = userDao;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User register(UserDto request) {
        // Convertir RegisterRequest → UserDto ou User directement
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return userDao.save(user);  // ou ton DAO custom
    }

    public User login(UserDto request) {
        Optional<User> user = userDao.findByEmail(request.getEmail());
        if (user.isEmpty() || !passwordEncoder.matches(request.getPassword(), user.get().getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return user.orElse(null);
    }

}

