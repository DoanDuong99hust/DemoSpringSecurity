package com.example.demosecurity.service;

import com.example.demosecurity.entity.RoleEntity;
import com.example.demosecurity.mapper.dto.RoleResponse;

import java.util.List;

public interface RoleService {
    List<RoleResponse> findAll();
    RoleResponse findRoleByName(String name);
}
