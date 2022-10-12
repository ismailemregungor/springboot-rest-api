package com.ieg.springbootrestapi.service.impl;

import com.ieg.springbootrestapi.dto.UserAddDTO;
import com.ieg.springbootrestapi.dto.UserGetDTO;
import com.ieg.springbootrestapi.dto.UserUpdateDTO;
import com.ieg.springbootrestapi.exception.NotFoundException;
import com.ieg.springbootrestapi.model.User;
import com.ieg.springbootrestapi.repository.UserRepository;
import com.ieg.springbootrestapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    @Transactional
    public UserGetDTO add(UserAddDTO userAddDTO) {
        final User user = userRepository
                .save(new User(userAddDTO.getFirstName(), userAddDTO.getLastName()));
        return UserGetDTO.of(user);
    }
    @Override
    @Transactional
    public UserGetDTO update(Long id, UserUpdateDTO userUpdateDTO) {
        final User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
        user.setFirstName(userUpdateDTO.getFirstName());
        user.setLastName(userUpdateDTO.getLastName());
        final User updatedUser = userRepository.save(user);
        return UserGetDTO.of(updatedUser);
    }
    @Override
    @Transactional
    public void delete(Long id) {
        final User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
        userRepository.deleteById(user.getId());
    }
    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<UserGetDTO> getAll() {
        return userRepository.findAll().stream().map(UserGetDTO::of).collect(Collectors.toList());
    }
    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public UserGetDTO getUserById(Long id) {
        final User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
        return UserGetDTO.of(user);
    }
}
