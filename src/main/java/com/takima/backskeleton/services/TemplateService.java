package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.TemplateDao;
import com.takima.backskeleton.models.Portfolio;
import com.takima.backskeleton.models.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TemplateService {

    @Autowired
    private TemplateDao templateDAO;

    // CRUD simple

    public Template createTemplate(Template template) {
        return templateDAO.save(template);
    }

    public Optional<Template> getTemplateById(Long id) {
        return templateDAO.findById(id);
    }

    public List<Template> getAllTemplates() {
        return templateDAO.findAll();
    }

    public void deleteTemplate(Long id) {
        templateDAO.deleteById(id);
    }

    public Template updateTemplate(Template template) {
        return templateDAO.save(template); // save met à jour si id existant
    }

    public Template patchTemplate(Long id, Template partialTemplate) {
        Template existingTemplate = templateDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Template not found"));

        if (partialTemplate.getNameTemplate() != null) existingTemplate.setNameTemplate(partialTemplate.getNameTemplate());

        return templateDAO.save(existingTemplate);
    }

}