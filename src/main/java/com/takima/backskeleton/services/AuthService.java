package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.UserDao;
import com.takima.backskeleton.DTO.UserDto;
import com.takima.backskeleton.DTO.LoginResponse;
import com.takima.backskeleton.DTO.UserResponse;
import com.takima.backskeleton.models.User;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService {
    private final UserDao userDao;

    public AuthService(UserDao userDao) {
        this.userDao = userDao;
    }

    public LoginResponse register(UserDto request) {
        // Vérifier que l'email n'existe pas déjà
        Optional<User> existingUser = userDao.findByEmail(request.getEmail());
        
        if (existingUser.isPresent()) {
            System.out.println("❌ Email déjà utilisé: " + request.getEmail());
            throw new RuntimeException("Email already exists");
        }
        
        // Créer le nouvel utilisateur
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());  // ✅ Mot de passe en clair

        // Sauvegarder en BDD
        User savedUser = userDao.save(user);
        System.out.println("✅ Utilisateur créé: " + savedUser.getEmail());
        
        // Générer token et réponse
        String token = generateToken(savedUser);
        UserResponse userResponse = new UserResponse(
            savedUser.getIdUser(),
            savedUser.getFirstName(),
            savedUser.getLastName(),
            savedUser.getEmail()
        );
        
        return new LoginResponse(token, userResponse);
    }

    public LoginResponse login(UserDto request) {
        System.out.println("🔵 Tentative login: " + request.getEmail());
        
        Optional<User> userOpt = userDao.findByEmail(request.getEmail());
        
        if (userOpt.isEmpty()) {
            System.out.println("❌ Utilisateur non trouvé: " + request.getEmail());
            throw new RuntimeException("Invalid credentials");
        }
        
        User user = userOpt.get();
        
        // ✅ Comparaison simple des mots de passe en clair
        if (!request.getPassword().equals(user.getPassword())) {
            System.out.println("❌ Mot de passe incorrect");
            throw new RuntimeException("Invalid credentials");
        }
        
        System.out.println("✅ Login réussi !");
        
        // Générer token et réponse
        String token = generateToken(user);
        UserResponse userResponse = new UserResponse(
            user.getIdUser(),
            user.getFirstName(),
            user.getLastName(),
            user.getEmail()
        );
        
        return new LoginResponse(token, userResponse);
    }

    private String generateToken(User user) {
        return "token_" + user.getIdUser() + "_" + UUID.randomUUID().toString();
    }
}