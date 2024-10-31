package com.example.job_application_portal.mapper;

import com.example.job_application_portal.dto.UserDto;
import com.example.job_application_portal.entity.User;

public class UserMapper {
    // mapping from entity to dto
    public static UserDto mapToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getCity(),
                user.getState(),
                user.getPcode(),
                user.getUser_type()
        );
    }

    // mapping from dto to entity
    public static User mapToUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getEmail(),
                userDto.getCity(),
                userDto.getState(),
                userDto.getPcode(),
                userDto.getUser_type()
        );
    }
}
