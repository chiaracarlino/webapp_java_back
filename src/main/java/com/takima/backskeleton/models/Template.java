package com.takima.backskeleton.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "template")
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTemplate;

    @Column(nullable = false)
    private String nameTemplate;

    @OneToMany(mappedBy = "template", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Portfolio> portfolios;

    // Getters et setters
    public Long getIdTemplate() { return idTemplate; }
    public void setIdTemplate(Long idTemplate) { this.idTemplate = idTemplate; }
    public String getNameTemplate() { return nameTemplate; }
    public void setNameTemplate(String nameTemplate) { this.nameTemplate = nameTemplate; }
    public List<Portfolio> getPortfolios() { return portfolios; }
    public void setPortfolios(List<Portfolio> portfolios) { this.portfolios = portfolios; }
}
