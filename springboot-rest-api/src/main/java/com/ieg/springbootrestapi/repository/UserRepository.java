package com.ieg.springbootrestapi.repository;

import com.ieg.springbootrestapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}

