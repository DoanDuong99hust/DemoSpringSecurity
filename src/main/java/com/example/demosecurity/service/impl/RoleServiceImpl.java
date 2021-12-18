package com.example.demosecurity.service.impl;

import com.example.demosecurity.entity.RoleEntity;
import com.example.demosecurity.mapper.RoleMapper;
import com.example.demosecurity.mapper.dto.RoleResponse;
import com.example.demosecurity.repository.RoleRepository;
import com.example.demosecurity.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public List<RoleResponse> findAll() {
        List<RoleResponse> roleResponses = new ArrayList<>();
        for (RoleEntity item: roleRepository.findAll()
             ) {
            roleResponses.add(roleMapper.mapEntityToResponse(item));
        }
        return roleResponses;
    }

    @Override
    public RoleResponse findRoleByName(String name) {
        RoleResponse roleResponse = roleMapper.mapEntityToResponse(roleRepository.findRoleEntityByName(name).get());
        return roleResponse;
    }

}
