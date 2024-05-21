package com.project.psk.controller;

import com.project.psk.model.dto.User.UserInfoDTO;
import com.project.psk.model.dto.User.UserModifyDTO;
import com.project.psk.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/email/{email}")
    ResponseEntity<UserInfoDTO> getByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.getByEmail(email));
    }

    @PostMapping("/newUser")
    ResponseEntity<UserInfoDTO> createUser(@RequestBody UserModifyDTO userModifyDTO) {
        return ResponseEntity.ok(userService.createUser(userModifyDTO));
    }

    @PutMapping("/update/{userId}")
    ResponseEntity<UserInfoDTO> updateUser(@PathVariable UUID userId, @RequestBody UserModifyDTO userModifyDTO) {
        return ResponseEntity.ok(userService.updateUser(userId, userModifyDTO));
    }

    @DeleteMapping("/delete/{userId}")
    ResponseEntity<String> deleteUser(@PathVariable UUID userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully");
    }
}
