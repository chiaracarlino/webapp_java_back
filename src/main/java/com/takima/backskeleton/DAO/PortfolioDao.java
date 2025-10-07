package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.Portfolio;
import com.takima.backskeleton.models.Template;
import com.takima.backskeleton.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortfolioDao extends JpaRepository<Portfolio, Long> {
    List<Portfolio> findByUser(User user);
    Portfolio findByLink(String link);
}
