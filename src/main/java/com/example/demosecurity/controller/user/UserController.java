package com.example.demosecurity.controller.user;

import com.example.demosecurity.entity.UserEntity;
import com.example.demosecurity.mapper.dto.UserRequest;
import com.example.demosecurity.mapper.dto.UserResponse;
import com.example.demosecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/get-users")
    public ResponseEntity<List<UserEntity>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping(value = "/create")
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.save(userRequest));
    }

    @PutMapping(value = "/update/{userId}")
    public ResponseEntity<UserResponse> update(@PathVariable("userId") Long userId, @RequestBody UserRequest userRequest) {
        userRequest.setUserId(userId);
        return ResponseEntity.ok(userService.update(userRequest));
    }

    @DeleteMapping(value = "/delete/{userId}")
    public void delete(@PathVariable("userId") Long id) {
        userService.delete(id);
    }
}
