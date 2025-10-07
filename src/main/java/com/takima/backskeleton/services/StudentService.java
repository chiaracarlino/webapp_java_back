package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.PortfolioDao;
import com.takima.backskeleton.DTO.StudentDto;
import com.takima.backskeleton.DTO.StudentMapper;
import com.takima.backskeleton.models.Template;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentService {
    private final PortfolioDao studentDao;

    public StudentService(PortfolioDao studentDao) {
        this.studentDao = studentDao;
    }

    public List<Template> findAll() {
        Iterable<Template> it = studentDao.findAll();
        List <Template> users = new ArrayList<>();
        it.forEach(users::add);
        return users ;
    }

    public Template getById(Long id) {
        return studentDao.findById(id).orElseThrow();
    }

    @Transactional
    public void deleteById(Long id) {
        studentDao.deleteById(id);
    }

    @Transactional
    public void addStudent(StudentDto studentDto) {
        Template student;
        try {
            student = StudentMapper.fromDto(studentDto, null);
        } catch (IOException e) {
            throw new RuntimeException("Error with Student image", e);
        }

        studentDao.save(student);
    }

    @Transactional
    public void updateStudent(StudentDto studentDto, Long id) {
        studentDao.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Student doesn't exist"));
        Template student;
        try {
            student = StudentMapper.fromDto(studentDto, id);
        } catch (IOException e) {
            throw new RuntimeException("Error with Student image", e);
        }
        studentDao.save(student);
    }

    public List<Template> searchByMajorAndCourse(int majorId, int courseId) {
        return studentDao.findByMajorIdAndCourseId(majorId, courseId);
    }
}
