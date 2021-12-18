package com.example.demosecurity.service.impl;

import com.example.demosecurity.entity.RoleEntity;
import com.example.demosecurity.repository.RoleRepository;
import com.example.demosecurity.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleEntity> findAll() {
        List<RoleEntity> roleEntities = new ArrayList<>();
        roleRepository.findAll().stream().forEach(roleEntity -> roleEntities.add(roleEntity));
        return roleEntities;
    }
}
