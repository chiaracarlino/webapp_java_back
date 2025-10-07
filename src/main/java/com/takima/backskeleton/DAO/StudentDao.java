package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<Template, Long> {
    @Query("SELECT s FROM Template s JOIN s.courses c WHERE c.id= :courseId AND s.major.id = :majorId ")
    List<Template> findByMajorIdAndCourseId(int majorId, int courseId);
}
