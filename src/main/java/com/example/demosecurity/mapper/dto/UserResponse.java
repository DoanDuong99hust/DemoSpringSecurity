package com.example.demosecurity.mapper.dto;

import com.example.demosecurity.entity.RoleEntity;
import lombok.Data;
import java.util.*;

@Data
public class UserResponse {
    private String userName;

    private String password;

    private String fullName;

    private Integer status;

    private Set<RoleEntity> roleEntity;
}
