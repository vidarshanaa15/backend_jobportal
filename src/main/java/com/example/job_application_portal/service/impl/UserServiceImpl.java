package com.example.job_application_portal.service.impl;

import com.example.job_application_portal.dto.UserDto;
import com.example.job_application_portal.entity.User;
import com.example.job_application_portal.exception.ResourceNotFoundException;
import com.example.job_application_portal.mapper.UserMapper;
import com.example.job_application_portal.repository.UserRepository;
import com.example.job_application_portal.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);  // mapping dto to entity
        User savedUser = userRepository.save(user);  // saving data in db
        return UserMapper.mapToUserDto(savedUser);  // returning dto
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User ID " + userId + " does not exist"));
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> UserMapper.mapToUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long userId, UserDto updatedUser) {

        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User ID " + userId + " does not exist")
        );

        user.setName(updatedUser.getName());
        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());
        user.setEmail(updatedUser.getEmail());
        user.setCity(updatedUser.getCity());
        user.setState(updatedUser.getState());
        user.setPcode(updatedUser.getPcode());
        user.setUser_type(updatedUser.getUser_type());

        User updatedUserObj = userRepository.save(user);

        return UserMapper.mapToUserDto(updatedUserObj);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User ID " + userId + " does not exist")
        );
        userRepository.deleteById(userId);
    }
}
