package com.ieg.springbootrestapi.service;

import com.ieg.springbootrestapi.dto.UserViewDTO;
public interface UserService {
    UserViewDTO getUserById(Long id);

}
