package com.example.demosecurity.service.impl;

import com.example.demosecurity.entity.PermissionEntity;
import com.example.demosecurity.repository.PermissionRepository;
import com.example.demosecurity.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    private final PermissionRepository permissionRepository;

    public PermissionServiceImpl(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Override
    public List<PermissionEntity> findAll() {
        return permissionRepository.findAll();
    }

    @Override
    public List<PermissionEntity> findPermissionByRoleId(Long roleId) {
        return permissionRepository.findPermissionByRoleId(roleId).get();
    }
}
