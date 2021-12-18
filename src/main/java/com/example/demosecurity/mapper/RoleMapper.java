package com.example.demosecurity.mapper;

import com.example.demosecurity.entity.PermissionEntity;
import com.example.demosecurity.entity.RoleEntity;
import com.example.demosecurity.entity.UserEntity;
import com.example.demosecurity.mapper.dto.RoleResponse;
import com.example.demosecurity.repository.UserRepository;
import com.example.demosecurity.service.PermissionService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleMapper {

    private final PermissionService permissionService;
    private final UserRepository userRepository;

    public RoleMapper(PermissionService permissionService, UserRepository userRepository) {
        this.permissionService = permissionService;
        this.userRepository = userRepository;
    }

    public RoleResponse mapEntityToResponse(RoleEntity roleEntity) {
        RoleResponse result = new RoleResponse();
        result.setRoleId(roleEntity.getRoleId());
        result.setCode(roleEntity.getCode());
        result.setName(roleEntity.getName());

        List<PermissionEntity> permissionEntities = new ArrayList<>();
        for (PermissionEntity item: permissionService.findPermissionByRoleId(roleEntity.getRoleId())
             ) {
            permissionEntities.add(item);
        }
        result.setPermissionList(permissionEntities);
        return result;
    }
}
