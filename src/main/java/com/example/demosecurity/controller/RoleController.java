package com.example.demosecurity.controller;

import com.example.demosecurity.entity.RoleEntity;
import com.example.demosecurity.mapper.dto.RoleResponse;
import com.example.demosecurity.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {
    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<RoleResponse>> findAll() {
        return ResponseEntity.ok(roleService.findAll());
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<RoleResponse> findRoleByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(roleService.findRoleByName(name));
    }
}
