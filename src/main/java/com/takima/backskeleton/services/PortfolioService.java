package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.PortfolioDao;
import com.takima.backskeleton.models.Portfolio;
import com.takima.backskeleton.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioDao portfolioDAO;

    public Portfolio createPortfolio(Portfolio portfolio) {
        return portfolioDAO.save(portfolio);
    }

    public List<Portfolio> getPortfoliosByUser(User user) {
        return portfolioDAO.findByUser(user);
    }

    public void deletePortfolio(Long id) {
        portfolioDAO.deleteById(id);
    }

    public Portfolio updatePortfolio(Portfolio portfolio) {
        return portfolioDAO.save(portfolio);
    }
}