package com.takima.backskeleton.controllers;

import com.takima.backskeleton.models.Portfolio;
import com.takima.backskeleton.models.Template;
import com.takima.backskeleton.services.TemplateService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequestMapping("majors")
@RestController
public class MajorController {
    private final TemplateService majorService;

    public MajorController(TemplateService majorService) {
        this.majorService = majorService;
    }

    @GetMapping("")
    public List<Portfolio> findAll() {
        return majorService.findAll();
    }

    @GetMapping("/{id}/students")
    public List<Template> getStudentsOfMajor(@PathVariable Long id) {
        return majorService.getStudentsOfMajor(id);
    }
}
