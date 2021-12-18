package com.example.demosecurity.service;

import com.example.demosecurity.entity.UserEntity;
import com.example.demosecurity.mapper.dto.UserRequest;
import com.example.demosecurity.mapper.dto.UserResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserResponse> findAll();
    UserEntity findById(Long id);
    UserResponse save(UserRequest userRequest);
    UserResponse update(UserRequest userRequest);
    void delete(Long id);
}
