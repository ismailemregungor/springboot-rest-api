package com.ieg.springbootrestapi.controller;

import com.ieg.springbootrestapi.dto.UserAddDTO;
import com.ieg.springbootrestapi.dto.UserGetDTO;
import com.ieg.springbootrestapi.dto.UserUpdateDTO;
import com.ieg.springbootrestapi.service.UserService;
import com.ieg.springbootrestapi.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("v1/user")
    public ResponseEntity<?> add(@RequestBody UserAddDTO userAddDTO) {
        userService.add(userAddDTO);
        return ResponseEntity.ok(new GenericResponse("User added successfully"));
    }

    @PutMapping("v1/user/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody UserUpdateDTO userUpdateDTO) {
        userService.update(id, userUpdateDTO);
        return ResponseEntity.ok(new GenericResponse("User updated successfully"));
    }

    @DeleteMapping("v1/user/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return ResponseEntity.ok(new GenericResponse("User deleted successfully"));
    }

    @GetMapping("v1/user")
    public ResponseEntity<List<UserGetDTO>> getAll() {
        final List<UserGetDTO> users = userService.getAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("v1/user/{id}")
    public ResponseEntity<UserGetDTO> getUserById(@PathVariable Long id) {
        final UserGetDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

}
