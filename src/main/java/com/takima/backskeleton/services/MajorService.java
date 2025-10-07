package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.MajorDao;
import com.takima.backskeleton.models.Portfolio;
import com.takima.backskeleton.models.Template;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MajorService {
    private final MajorDao majorDao;

    public MajorService(MajorDao majorDao) {
        this.majorDao = majorDao;
    }

    public List<Portfolio> findAll() {
        Iterable<Portfolio> it = majorDao.findAll();
        List <Portfolio> majors = new ArrayList<>();
        it.forEach(majors::add);
        return majors;
    }

    public List<Template> getStudentsOfMajor(Long id) {
        return majorDao.getAllStudentsFromMajor(id);
    }
}
