package com.example.demosecurity.mapper;

import com.example.demosecurity.entity.RoleEntity;
import com.example.demosecurity.entity.UserEntity;
import com.example.demosecurity.mapper.dto.UserRequest;
import com.example.demosecurity.mapper.dto.UserResponse;
import com.example.demosecurity.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;

import java.util.HashSet;

@Component
public class UserMapper {
    private final RoleRepository roleRepository;

    @Autowired
    public UserMapper(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public UserEntity mapRequestToEntity(UserRequest userRequest) {
        UserEntity result = new UserEntity();
        result.setUserName(userRequest.getUserName());
        result.setPassword(userRequest.getPassword());
        result.setFullName(userRequest.getFullName());
        result.setStatus(userRequest.getStatus());

        Set<RoleEntity> roleEntitySet = new HashSet<>();
        for (String role: userRequest.getRole()
             ) {
            Optional<RoleEntity> roleEntity = roleRepository.findRoleEntityByCode(role);
            roleEntitySet.add(roleEntity.get());
        }
        result.setRoles(roleEntitySet);
        return result;
    }

    public UserResponse mapEntityToResponse(UserEntity userEntity) {
        UserResponse result = new UserResponse();
        result.setUserName(userEntity.getUserName());
        result.setPassword(userEntity.getPassword());
        result.setFullName(userEntity.getFullName());
        result.setStatus(userEntity.getStatus());

        Set<RoleEntity> roleEntitySet = new HashSet<>();
        for (RoleEntity role: userEntity.getRoles()
        ) {
            roleEntitySet.add(role);
        }
        result.setRoleEntity(roleEntitySet);
        return result;
    }

    public UserEntity mapRequestToEntity(UserEntity result, UserRequest userRequest) {
        result.setUserName(userRequest.getUserName());
        result.setPassword(userRequest.getPassword());
        result.setFullName(userRequest.getFullName());
        result.setStatus(userRequest.getStatus());

        Set<RoleEntity> roleEntitySet = new HashSet<>();
        for (String role: userRequest.getRole()
        ) {
            Optional<RoleEntity> roleEntity = roleRepository.findRoleEntityByCode(role);
            roleEntitySet.add(roleEntity.get());
        }
        result.setRoles(roleEntitySet);
        return result;
    }
}
