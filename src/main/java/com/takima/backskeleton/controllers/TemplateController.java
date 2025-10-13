package com.takima.backskeleton.controllers;

import com.takima.backskeleton.models.Portfolio;
import com.takima.backskeleton.models.Template;
import com.takima.backskeleton.services.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/templates")
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    @PostMapping
    public Template createTemplate(@RequestBody Template template) {
        return templateService.createTemplate(template);
    }

    @GetMapping("/{id}")
    public Optional<Template> getTemplate(@PathVariable Long id) {
        return templateService.getTemplateById(id);
    }

    @GetMapping
    public List<Template> getAllTemplates() {
        return templateService.getAllTemplates();
    }

    @PutMapping("/{id}")
    public Template updateTemplate(@PathVariable Long id, @RequestBody Template template) {
        template.setIdTemplate(id);
        return templateService.updateTemplate(template);
    }

    @PatchMapping("/{id}")
    public Template patchTemplate(@PathVariable Long id, @RequestBody Template partialTemplate) {
        return templateService.patchTemplate(id, partialTemplate);
    }


    @DeleteMapping("/{id}")
    public void deleteTemplate(@PathVariable Long id) {
        templateService.deleteTemplate(id);
    }
}
