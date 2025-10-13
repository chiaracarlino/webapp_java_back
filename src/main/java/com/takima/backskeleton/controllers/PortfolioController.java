package com.takima.backskeleton.controllers;

import com.takima.backskeleton.DTO.PortfolioDto;
import com.takima.backskeleton.models.Portfolio;
import com.takima.backskeleton.models.Template;
import com.takima.backskeleton.models.User;
import com.takima.backskeleton.services.PortfolioService;
import com.takima.backskeleton.services.TemplateService;
import com.takima.backskeleton.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users/{userId}/portfolios")
@CrossOrigin(origins = "http://localhost:4200")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @Autowired
    private UserService userService;

    @Autowired
    private TemplateService templateService;

    @PostMapping
    public Portfolio createPortfolio(@PathVariable Long userId, @RequestBody PortfolioDto dto) {
        User user = userService.getUserById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Template template = templateService.getTemplateById(dto.getTemplateId())
                .orElseThrow(() -> new RuntimeException("Template not found"));

        Portfolio portfolio = new Portfolio();
        portfolio.setNamePortfolio(dto.getName());
        portfolio.setLink(dto.getLink());
        portfolio.setLinkedin(dto.getLinkedin());
        portfolio.setUser(user);
        portfolio.setTemplate(template);

        return portfolioService.createPortfolio(portfolio);
    }



    @GetMapping
    public List<Portfolio> getPortfoliosByUser(@PathVariable Long userId) {
        User user = userService.getUserById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return portfolioService.getPortfoliosByUser(user);
    }

    @GetMapping("/{portfolioId}")
    public Portfolio getPortfolio(@PathVariable Long userId, @PathVariable Long portfolioId) {
        return portfolioService.getPortfolioById(portfolioId)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));
    }

    @PutMapping("/{portfolioId}")
    public Portfolio updatePortfolio(@PathVariable Long userId, @PathVariable Long portfolioId, @RequestBody Portfolio partialPortfolio) {
        Portfolio existing = portfolioService.getPortfolioById(portfolioId)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));

        if (partialPortfolio.getNamePortfolio() != null) existing.setNamePortfolio(partialPortfolio.getNamePortfolio());
        if (partialPortfolio.getLink() != null) existing.setLink(partialPortfolio.getLink());
        if (partialPortfolio.getLinkedin() != null) existing.setLinkedin(partialPortfolio.getLinkedin());
        if (partialPortfolio.getTemplate() != null) existing.setTemplate(partialPortfolio.getTemplate());

        return portfolioService.createPortfolio(existing); // save existant
    }



    @PatchMapping("/{portfolioId}")
    public Portfolio patchPortfolio(@PathVariable Long userId, @PathVariable Long portfolioId, @RequestBody Portfolio partialPortfolio) {
        return portfolioService.patchPortfolio(portfolioId, partialPortfolio);
    }

    @DeleteMapping("/{portfolioId}")
    public void deletePortfolio(@PathVariable Long userId, @PathVariable Long portfolioId) {
        portfolioService.deletePortfolio(portfolioId);
    }
}
