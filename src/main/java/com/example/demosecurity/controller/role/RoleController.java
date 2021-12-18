package com.example.demosecurity.controller.role;

import com.example.demosecurity.entity.RoleEntity;
import com.example.demosecurity.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {
    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    public ResponseEntity<List<RoleEntity>> findAll() {
        return ResponseEntity.ok(roleService.findAll());
    }
}
