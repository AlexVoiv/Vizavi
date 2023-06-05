package com.vizavi.application.controllers;

import com.vizavi.application.models.dtos.UserDTO;
import com.vizavi.application.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody @Valid UserDTO userDTO) {
        UserDTO createdUser = userService.createUser(userDTO);
        return ResponseEntity.ok(createdUser);
    }


    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUserById(@PathVariable long userId, @RequestBody @Valid UserDTO userDTO) {
        return ResponseEntity.ok(userService.updateUserById(userId, userDTO));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
