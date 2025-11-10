package com.takima.backskeleton.controllers;
import org.springframework.http.HttpStatus;
import com.takima.backskeleton.DTO.LoginResponse;
import com.takima.backskeleton.DTO.LoginRequest;
import com.takima.backskeleton.DTO.RegisterRequest;
import com.takima.backskeleton.DTO.UserDto;
import com.takima.backskeleton.models.User;
import com.takima.backskeleton.services.AuthService;
import com.takima.backskeleton.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import com.takima.backskeleton.DAO.UserDao;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final AuthService authService;
    private final UserDao userDao;
    public AuthController(AuthService authService, UserDao userDao) {
        this.authService = authService;
        this.userDao = userDao;
    }
    

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody UserDto request) {
        System.out.println("🔵 Login endpoint appelé");
        System.out.println("📧 Email reçu: " + (request != null ? request.getEmail() : "NULL"));
        System.out.println("🔐 Password présent: " + (request != null && request.getPassword() != null));
        
        try {
            LoginResponse response = authService.login(request);
            System.out.println("✅ Login réussi pour: " + request.getEmail());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println("❌ Erreur login: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<LoginResponse> register(@RequestBody UserDto request) {
        System.out.println("🔵 Register endpoint appelé");
        System.out.println("=== REGISTER START ===");
        System.out.println("FirstName: " + request.getFirstName());
        System.out.println("LastName: " + request.getLastName());
        System.out.println("Email: " + request.getEmail());
        System.out.println("Password présent: " + (request.getPassword() != null));
        
        //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //String hashedPassword = encoder.encode(request.getPassword());
        //
        try {
            LoginResponse response = authService.register(request);
            System.out.println("✅ Register réussi");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println("❌ Erreur register: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/test")
    public String test() {
        System.out.println("🔵 Test endpoint appelé");
        return "Backend fonctionne !";
    }

    @GetMapping("/test-bcrypt")
    public String testBCrypt() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = "azerty123";
        
        String hash1 = "$2a$10$NQUN8QqYV7c5xJ3j9qQXDOR4xqKqHJxPcRZxnHvL5i5Gp2yNXvqwC";
        String hash2 = "$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy";
        
        boolean match1 = encoder.matches(password, hash1);
        boolean match2 = encoder.matches(password, hash2);
        
        return "Hash1 (Chiara) matches 'azerty123': " + match1 + "<br>" +
            "Hash2 (nouveau) matches 'azerty123': " + match2;
    }
}
/*
    @PostMapping("/debug-register")
    public String debugRegister(@RequestBody UserDto request) {
        System.out.println("=== DEBUG REGISTER ===");
        System.out.println("Email: " + request.getEmail());
        System.out.println("Password reçu: " + request.getPassword());
        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashedPassword = encoder.encode(request.getPassword());
        System.out.println("Password hashé: " + hashedPassword);
        
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(hashedPassword);
        
        System.out.println("Avant save - Password dans User: " + user.getPassword());
        
        User saved = userDao.save(user);
        
        System.out.println("Après save - Password dans User: " + saved.getPassword());
        
        return "OK - Vérifiez en BDD";
    }
}


    

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody UserDto userDto) {
        User user = authService.register(userDto);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User credentials) {
        User user = userService.getUserByEmail(credentials.getEmail());

        if (user == null) {
            return ResponseEntity.status(404).body("User not found");
        }

        if (!user.getPassword().equals(credentials.getPassword())) {
            return ResponseEntity.status(401).body("Invalid password");
        }

        return ResponseEntity.ok(user);
    }
    */


