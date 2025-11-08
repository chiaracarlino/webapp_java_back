package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Portfolio;
import com.takima.backskeleton.models.User;

public class PortfolioMapper {

    public static PortfolioDto toDTO(Portfolio portfolio) {
        if (portfolio == null) return null;
        PortfolioDto dto = new PortfolioDto();
        dto.setId(portfolio.getIdPortfolio());
        dto.setName(portfolio.getNamePortfolio());
        dto.setLink(portfolio.getLink());
        dto.setLinkedin(portfolio.getLinkedin());
        dto.setCreationDate(portfolio.getCreationDate());
        dto.setEditionDate(portfolio.getEditionDate());
        dto.setUserId(portfolio.getUser() != null ? portfolio.getUser().getIdUser() : null);
        dto.setTemplateName(portfolio.getTemplateName());
        dto.setJsonData(portfolio.getJsonData());
        return dto;
    }

    public static Portfolio toEntity(PortfolioDto dto, User user) {
        if (dto == null) return null;
        Portfolio portfolio = new Portfolio();
        portfolio.setIdPortfolio(dto.getId());
        portfolio.setNamePortfolio(dto.getName());
        portfolio.setLink(dto.getLink());
        portfolio.setLinkedin(dto.getLinkedin());
        portfolio.setCreationDate(dto.getCreationDate());
        portfolio.setEditionDate(dto.getEditionDate());
        portfolio.setUser(user);
        portfolio.setTemplateName(dto.getTemplateName());
        portfolio.setJsonData(dto.getJsonData());
        return portfolio;
    }
}

