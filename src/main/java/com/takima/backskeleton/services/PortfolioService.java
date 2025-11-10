package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.PortfolioDao;
import com.takima.backskeleton.models.Portfolio;
import com.takima.backskeleton.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioDao portfolioDAO;

    public Portfolio createPortfolio(Portfolio portfolio) {
        return portfolioDAO.save(portfolio);
    }

    public Optional<Portfolio> getPortfolioById(Long id) {
        return portfolioDAO.findById(id);
    }

    public List<Portfolio> getPortfoliosByUser(User user) {
        return portfolioDAO.findAll()
                .stream()
                .filter(p -> p.getUser().equals(user))
                .toList();
    }

    public void deletePortfolio(Long id) {
        portfolioDAO.deleteById(id);
    }

    public Portfolio updatePortfolio(Portfolio portfolio) {
        return portfolioDAO.save(portfolio);
    }

    public Portfolio patchPortfolio(Long id, Portfolio partialPortfolio) {
        Portfolio existingPortfolio = portfolioDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));

        if (partialPortfolio.getNamePortfolio() != null) existingPortfolio.setNamePortfolio(partialPortfolio.getNamePortfolio());

        if (partialPortfolio.getLink() != null) existingPortfolio.setLink(partialPortfolio.getLink());

        if (partialPortfolio.getLinkedin() != null) existingPortfolio.setLinkedin(partialPortfolio.getLinkedin());

        if (partialPortfolio.getCreationDate() != null) existingPortfolio.setCreationDate(partialPortfolio.getCreationDate());

        if (partialPortfolio.getEditionDate() != null) existingPortfolio.setEditionDate(partialPortfolio.getEditionDate());

        if (partialPortfolio.getUser() != null) existingPortfolio.setUser(partialPortfolio.getUser());

        if (partialPortfolio.getTemplateName() != null) existingPortfolio.setTemplateName(partialPortfolio.getTemplateName());

        if (partialPortfolio.getJsonData() != null) existingPortfolio.setJsonData(partialPortfolio.getJsonData());

        return portfolioDAO.save(existingPortfolio);
    }
}