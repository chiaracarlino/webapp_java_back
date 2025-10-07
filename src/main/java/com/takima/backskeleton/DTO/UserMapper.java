package com.takima.backskeleton.DTO;

import com.takima.backskeleton.DTO.UserDto;
import com.takima.backskeleton.models.User;

public class UserMapper {

    public static UserDto toDTO(User user) {
        if (user == null) return null;
        return new UserDto(user.getIdUser(), user.getFirstName(), user.getLastName(), user.getEmail());
    }

    public static User toEntity(UserDto dto) {
        if (dto == null) return null;
        User user = new User();
        user.setIdUser(dto.getId());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        return user;
    }
}

