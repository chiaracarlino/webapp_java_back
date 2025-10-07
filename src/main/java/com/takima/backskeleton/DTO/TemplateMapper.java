package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Template;

public class TemplateMapper {

    public static TemplateDto toDTO(Template template) {
        if (template == null) return null;
        return new TemplateDto(template.getIdTemplate(), template.getNameTemplate());
    }

    public static Template toEntity(TemplateDto dto) {
        if (dto == null) return null;
        Template template = new Template();
        template.setIdTemplate(dto.getId());
        template.setNameTemplate(dto.getName());
        return template;
    }
}

