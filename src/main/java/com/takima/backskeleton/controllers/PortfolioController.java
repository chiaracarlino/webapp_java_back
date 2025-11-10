package com.takima.backskeleton.controllers;

import com.takima.backskeleton.DTO.PortfolioDto;
import com.takima.backskeleton.models.Portfolio;
import com.takima.backskeleton.models.User;
import com.takima.backskeleton.services.PortfolioService;
import com.takima.backskeleton.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/portfolios")
@CrossOrigin(origins = "*")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @Autowired
    private UserService userService;

    @PostMapping
    public Portfolio createPortfolio(@PathVariable Long userId, @RequestBody PortfolioDto dto) {
        System.out.println(" Create portfolio endpoint appelé");
        
        try {
            User user = userService.getUserById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found"));
            
            System.out.println(" User trouvé: " + user.getEmail());

            Portfolio portfolio = new Portfolio();
            portfolio.setNamePortfolio(dto.getName());
            portfolio.setTemplateName(dto.getTemplateName());
            portfolio.setLink(dto.getLink());
            portfolio.setLinkedin(dto.getLinkedin());
            portfolio.setUser(user);
            portfolio.setJsonData(dto.getJsonData());

            Portfolio saved = portfolioService.createPortfolio(portfolio);
            System.out.println(" Portfolio créé avec ID: " + saved.getIdPortfolio());
            
            return saved;
        } catch (Exception e) {
            System.out.println(" Erreur: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    @GetMapping
    public List<Portfolio> getPortfoliosByUser(@PathVariable Long userId) {
       
        User user = userService.getUserById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        List<Portfolio> portfolios = portfolioService.getPortfoliosByUser(user);
        
        return portfolios;
    }

    @GetMapping("/{portfolioId}")
    public Portfolio getPortfolio(@PathVariable Long userId, @PathVariable Long portfolioId) {
        Portfolio portfolio = portfolioService.getPortfolioById(portfolioId)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));

        if (!portfolio.getUser().getIdUser().equals(userId)) {
            throw new RuntimeException("This portfolio does not belong to this user");
        }

        return portfolio;
    }

    @PutMapping("/{portfolioId}")
    public Portfolio updatePortfolio(@PathVariable Long userId, @PathVariable Long portfolioId, @RequestBody Portfolio partialPortfolio) {
        Portfolio existing = portfolioService.getPortfolioById(portfolioId)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));

        if (partialPortfolio.getNamePortfolio() != null) {
            existing.setNamePortfolio(partialPortfolio.getNamePortfolio());
        }
        if (partialPortfolio.getLink() != null) {
            existing.setLink(partialPortfolio.getLink());
        }
        if (partialPortfolio.getLinkedin() != null) {
            existing.setLinkedin(partialPortfolio.getLinkedin());
        }
        if (partialPortfolio.getTemplateName() != null) {
            existing.setTemplateName(partialPortfolio.getTemplateName());
        }

        return portfolioService.createPortfolio(existing);
    }

    @PatchMapping("/{portfolioId}")
    public Portfolio patchPortfolio(@PathVariable Long userId, @PathVariable Long portfolioId, @RequestBody Portfolio partialPortfolio) {
        return portfolioService.patchPortfolio(portfolioId, partialPortfolio);
    }

    @DeleteMapping("/{portfolioId}")
    public void deletePortfolio(@PathVariable Long userId, @PathVariable Long portfolioId) {
        System.out.println("🗑️ Suppression portfolio: " + portfolioId);
        portfolioService.deletePortfolio(portfolioId);
    }
}