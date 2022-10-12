package com.ieg.springbootrestapi.service;

import com.ieg.springbootrestapi.dto.UserAddDTO;
import com.ieg.springbootrestapi.dto.UserGetDTO;
import com.ieg.springbootrestapi.dto.UserUpdateDTO;

import java.util.List;
public interface UserService {
    UserGetDTO add(UserAddDTO userAddDTO);
    UserGetDTO update(Long id, UserUpdateDTO userUpdateDTO);
    void delete(Long id);
    List<UserGetDTO> getAll();
    UserGetDTO getUserById(Long id);

}
