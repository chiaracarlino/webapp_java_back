package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.User;
import com.takima.backskeleton.models.Portfolio;

import java.time.Instant;
import java.util.List;
public class StudentDto {
    private String firstName;
    private String lastName;
    private Instant birthdate;
    private List<User> courses;
    private Portfolio major;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Instant getBirthdate() {
        return birthdate;
    }

    public List<User> getCourses() {
        return courses;
    }

    public Portfolio getMajor() {
        return major;
    }

    public static final class StudentDtoBuilder {
        private String firstName;
        private String lastName;
        private Instant birthdate;
        private List<User> courses;
        private Portfolio major;

        public StudentDtoBuilder() {
        }

        public static StudentDtoBuilder aStudentDto() {
            return new StudentDtoBuilder();
        }

        public StudentDtoBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public StudentDtoBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public StudentDtoBuilder birthdate(Instant birthdate) {
            this.birthdate = birthdate;
            return this;
        }

        public StudentDtoBuilder courses(List<User> courses) {
            this.courses = courses;
            return this;
        }

        public StudentDtoBuilder major(Portfolio major) {
            this.major = major;
            return this;
        }

        public StudentDto build() {
            StudentDto studentDto = new StudentDto();
            studentDto.lastName = this.lastName;
            studentDto.major = this.major;
            studentDto.firstName = this.firstName;
            studentDto.birthdate = this.birthdate;
            studentDto.courses = this.courses;
            return studentDto;
        }
    }
}
