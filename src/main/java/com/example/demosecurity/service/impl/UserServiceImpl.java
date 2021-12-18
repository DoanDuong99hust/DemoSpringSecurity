package com.example.demosecurity.service.impl;

import com.example.demosecurity.entity.UserEntity;
import com.example.demosecurity.mapper.UserMapper;
import com.example.demosecurity.mapper.dto.UserRequest;
import com.example.demosecurity.mapper.dto.UserResponse;
import com.example.demosecurity.repository.UserRepository;
import com.example.demosecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserEntity> findAll() {
        List<UserEntity> userEntities = new ArrayList<>();
        for (UserEntity user: userRepository.findAll()
             ) {
            userEntities.add(user);
        }
        return userEntities;
    }

    @Override
    public UserEntity findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    @Transactional
    public UserResponse save(UserRequest userRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity = userMapper.mapRequestToEntity(userRequest);
        return userMapper.mapEntityToResponse(userRepository.save(userEntity));
    }

    @Override
    @Transactional
    public UserResponse update(UserRequest userRequest) {
        UserEntity userEntity = new UserEntity();
        if (userRequest.getUserId() != null) {
            Optional<UserEntity> oldUserEntity = userRepository.findById(userRequest.getUserId());
            userEntity = userMapper.mapRequestToEntity(oldUserEntity.get(), userRequest);
        }
        return userMapper.mapEntityToResponse(userRepository.save(userEntity));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepository.delete(userRepository.findById(id).get());
    }
}
