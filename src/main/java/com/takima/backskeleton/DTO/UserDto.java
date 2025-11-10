package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.User;
import com.takima.backskeleton.models.Portfolio;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;
import java.util.List;
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;


    public UserDto() {}

    public UserDto(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @JsonProperty("prenom")
    public void setPrenom(String prenom) {
        System.out.println("🔵 setPrenom appelé avec: " + prenom);
        this.firstName = prenom;
    }

    @JsonProperty("nom")
    public void setNom(String nom) {
        System.out.println("🔵 setNom appelé avec: " + nom);
        this.lastName = nom;
    }

}