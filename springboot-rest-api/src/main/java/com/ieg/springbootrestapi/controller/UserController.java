package com.ieg.springbootrestapi.controller;

import com.ieg.springbootrestapi.dto.UserViewDTO;
import com.ieg.springbootrestapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("v1/user/{id}")
    public ResponseEntity<UserViewDTO> getUserById(@PathVariable Long id) {
        final UserViewDTO userViewDTO = userService.getUserById(id);
        return ResponseEntity.ok(userViewDTO);
    }
}
