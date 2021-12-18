package com.example.demosecurity.mapper.dto;

import com.example.demosecurity.entity.RoleEntity;
import lombok.Data;

import java.util.Set;

@Data
public class UserRequest {
    private Long userId;
    private String userName;

    private String password;

    private String fullName;

    private Integer status;

    private Set<String> role;
}
