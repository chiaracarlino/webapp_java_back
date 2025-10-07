package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.PortfolioDao;
import com.takima.backskeleton.DTO.StudentDto;
import com.takima.backskeleton.DTO.StudentMapper;
import com.takima.backskeleton.models.Portfolio;
import com.takima.backskeleton.models.Template;
import com.takima.backskeleton.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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