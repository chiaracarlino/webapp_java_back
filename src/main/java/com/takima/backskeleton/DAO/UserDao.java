package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    // méthode personnalisée pour le login
    Optional<User> findByEmail(String email);
}


