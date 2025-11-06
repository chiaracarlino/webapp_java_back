package com.takima.backskeleton.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserResponse {
    @JsonProperty("id")
    private Long id;
    
    @JsonProperty("prenom")
    private String prenom;
    
    @JsonProperty("nom")
    private String nom;
    
    @JsonProperty("email")
    private String email;

    // Constructeur à partir d'un User
    public UserResponse(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.prenom = firstName;  // firstName → prenom
        this.nom = lastName;      // lastName → nom
        this.email = email;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}