package com.vizavi.application.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vizavi.application.models.entities.User;
import com.vizavi.application.repositories.UserRepository;
import com.vizavi.application.models.dtos.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ObjectMapper objectMapper) {
        this.userRepository = userRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User userToSave = objectMapper.convertValue(userDTO, User.class);
        User savedUser = userRepository.save(userToSave);
        log.info("User created: {}", userDTO);
        return objectMapper.convertValue(savedUser, UserDTO.class);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> objectMapper.convertValue(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUserById(long userId, UserDTO userDTO) {
        User existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser != null) {
            User updatedUser = objectMapper.convertValue(userDTO, User.class);
            updatedUser.setId(existingUser.getId());
            User savedUser = userRepository.save(updatedUser);
            log.info("User updated: {}", userDTO);
            return objectMapper.convertValue(savedUser, UserDTO.class);
        }
        return null;
    }

    @Override
    public void deleteUserById(long userId) {
        log.info("User with id {} was deleted.", userId);
        userRepository.deleteById(userId);
    }
}
