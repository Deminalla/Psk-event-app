package com.project.psk.controller;

import com.project.psk.model.dto.User.UserCreateDTO;
import com.project.psk.model.dto.User.UserInfoDTO;
import com.project.psk.model.dto.User.UserUpdateDTO;
import com.project.psk.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {
    private final UserService userService;
    @GetMapping("/{userId}")
    ResponseEntity<UserInfoDTO> getById(@PathVariable UUID userId) {
        return ResponseEntity.ok(userService.getById(userId));
    }

    @PostMapping("/newUser")
    ResponseEntity<UserInfoDTO> createUser(@RequestBody UserCreateDTO userCreateDTO) {
        return ResponseEntity.ok(userService.createUser(userCreateDTO));
    }

    @PutMapping("/update/{userId}")
    ResponseEntity<UserInfoDTO> updateUser(@PathVariable UUID userId, @RequestBody UserUpdateDTO userModifyDTO) {
        return ResponseEntity.ok(userService.updateUser(userId, userModifyDTO));
    }

    @DeleteMapping("/delete/{userId}")
    ResponseEntity<String> deleteUser(@PathVariable UUID userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully");
    }
}
