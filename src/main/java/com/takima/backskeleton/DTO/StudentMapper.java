package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Template;

import java.io.IOException;

public class StudentMapper {
    public static Template fromDto(StudentDto dto, Long id) throws IOException {
        return new Template.Builder()
                .id(id)
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .birthdate(dto.getBirthdate())
                .courses(dto.getCourses())
                .major(dto.getMajor())
                .build();
    }

    public static StudentDto toDto (Template student){
        return new StudentDto.StudentDtoBuilder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .birthdate(student.getBirthdate())
                .courses(student.getCourses())
                .major(student.getMajor())
                .build();
    }
}
