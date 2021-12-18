package com.example.demosecurity.service;

import com.example.demosecurity.entity.PermissionEntity;

import java.util.List;

public interface PermissionService {
    List<PermissionEntity> findAll();
    List<PermissionEntity> findPermissionByRoleId(Long roleId);
}
