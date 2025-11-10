package com.takima.backskeleton.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "portfolio")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPortfolio;

    @Column(nullable = false)
    private String namePortfolio;

    @Column(nullable = false, unique = true)
    private String link;

    @Column(nullable = false)
    private String linkedin;

    @Column(nullable = false)
    private String templateName;

    @Column(nullable = false)
    private LocalDate creationDate = LocalDate.now();

    @Column(nullable = false)
    private LocalDate editionDate = LocalDate.now();

    // Relation avec User
    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    @JsonBackReference
    private User user;

    //json
    @Column(columnDefinition = "TEXT")
    private String jsonData;

    // Getters et setters
    public Long getIdPortfolio() { return idPortfolio; }
    public void setIdPortfolio(Long idPortfolio) { this.idPortfolio = idPortfolio; }
    public String getNamePortfolio() { return namePortfolio; }
    public void setNamePortfolio(String namePortfolio) { this.namePortfolio = namePortfolio; }
    public String getLink() { return link; }
    public void setLink(String link) { this.link = link; }
    public String getLinkedin() { return linkedin; }
    public void setLinkedin(String linkedin) { this.linkedin = linkedin; }
    public String getTemplateName() { return templateName; }
    public void setTemplateName(String templateName) { this.templateName = templateName; }
    public LocalDate getCreationDate() { return creationDate; }
    public void setCreationDate(LocalDate creationDate) { this.creationDate = creationDate; }
    public LocalDate getEditionDate() { return editionDate; }
    public void setEditionDate(LocalDate editionDate) { this.editionDate = editionDate; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public String getJsonData() { return jsonData; }
    public void setJsonData(String jsonData) { this.jsonData = jsonData; }

    @PrePersist
    protected void onCreate() {
        creationDate = LocalDate.now();
        editionDate = LocalDate.now();
    }

    @PreUpdate
    protected void onUpdate() {
        editionDate = LocalDate.now();
    }
}