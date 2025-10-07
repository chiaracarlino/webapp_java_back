package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.Portfolio;
import com.takima.backskeleton.models.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemplateDao extends JpaRepository<Template, Long> {
    // ajouter des méthodes
}
