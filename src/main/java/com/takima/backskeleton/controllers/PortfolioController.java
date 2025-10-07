package com.takima.backskeleton.controllers;

import com.takima.backskeleton.models.Portfolio;
import com.takima.backskeleton.models.User;
import com.takima.backskeleton.services.PortfolioService;
import com.takima.backskeleton.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/portfolios")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @Autowired
    private UserService userService;

    @PostMapping("/{userId}")
    public Portfolio createPortfolio(@PathVariable Long userId, @RequestBody Portfolio portfolio) {
        Optional<User> userOpt = userService.getUserById(userId);
        if (userOpt.isPresent()) {
            portfolio.setUser(userOpt.get());
            return portfolioService.createPortfolio(portfolio);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @GetMapping("/{id}")
    public Optional<Portfolio> getPortfolio(@PathVariable Long id) {
        return portfolioService.getPortfoliosByUser(null) // ici tu pourrais créer une méthode getById
                .stream().filter(p -> p.getIdPortfolio().equals(id)).findFirst();
    }

    @GetMapping("/user/{userId}")
    public List<Portfolio> getPortfoliosByUser(@PathVariable Long userId) {
        Optional<User> userOpt = userService.getUserById(userId);
        return userOpt.map(portfolioService::getPortfoliosByUser).orElse(null);
    }

    @PutMapping("/{id}")
    public Portfolio updatePortfolio(@PathVariable Long id, @RequestBody Portfolio portfolio) {
        portfolio.setIdPortfolio(id);
        return portfolioService.updatePortfolio(portfolio);
    }

    @DeleteMapping("/{id}")
    public void deletePortfolio(@PathVariable Long id) {
        portfolioService.deletePortfolio(id);
    }
}