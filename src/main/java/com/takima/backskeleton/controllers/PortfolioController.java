package com.takima.backskeleton.controllers;

import com.takima.backskeleton.models.Portfolio;
import com.takima.backskeleton.models.Template;
import com.takima.backskeleton.models.User;
import com.takima.backskeleton.services.PortfolioService;
import com.takima.backskeleton.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users/{userId}/portfolios")
@CrossOrigin
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @Autowired
    private UserService userService;

    @PostMapping
    public Portfolio createPortfolio(@PathVariable Long userId, @RequestBody Portfolio portfolio) {
        User user = userService.getUserById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        portfolio.setUser(user);
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
    public Portfolio updatePortfolio(@PathVariable Long userId, @PathVariable Long portfolioId, @RequestBody Portfolio portfolio) {
        portfolio.setIdPortfolio(portfolioId);
        return portfolioService.updatePortfolio(portfolio);
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
