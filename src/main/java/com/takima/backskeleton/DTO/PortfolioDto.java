package com.takima.backskeleton.DTO;

import java.time.LocalDate;

public class PortfolioDto {
    private Long id;
    private String name;
    private String link;
    private String linkedin;
    private LocalDate creationDate;
    private LocalDate editionDate;
    private Long userId;
    private Long templateId;
    private String jsonData;

    public PortfolioDto() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLink() { return link; }
    public void setLink(String link) { this.link = link; }
    public String getLinkedin() { return linkedin; }
    public void setLinkedin(String linkedin) { this.linkedin = linkedin; }
    public LocalDate getCreationDate() { return creationDate; }
    public void setCreationDate(LocalDate creationDate) { this.creationDate = creationDate; }
    public LocalDate getEditionDate() { return editionDate; }
    public void setEditionDate(LocalDate editionDate) { this.editionDate = editionDate; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public Long getTemplateId() { return templateId; }
    public void setTemplateId(Long templateId) { this.templateId = templateId; }
    public String getJsonData() { return jsonData; }
    public void setJsonData(String jsonData) { this.jsonData = jsonData; }

}
