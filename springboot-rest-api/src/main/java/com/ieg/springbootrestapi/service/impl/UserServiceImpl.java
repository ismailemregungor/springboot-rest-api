package com.ieg.springbootrestapi.service.impl;

import com.ieg.springbootrestapi.dto.UserViewDTO;
import com.ieg.springbootrestapi.exception.NotFoundException;
import com.ieg.springbootrestapi.model.User;
import com.ieg.springbootrestapi.repository.UserRepository;
import com.ieg.springbootrestapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public UserViewDTO getUserById(Long id) {
        final User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
        return UserViewDTO.of(user);
    }
}
