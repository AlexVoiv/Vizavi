package com.vizavi.application.services;

import com.vizavi.application.models.dtos.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser (UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserDTO updateUserById (long userId, UserDTO userDTO);
    void deleteUserById (long userId);

}
