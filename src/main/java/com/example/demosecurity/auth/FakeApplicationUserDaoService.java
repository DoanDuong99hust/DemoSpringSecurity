package com.example.demosecurity.auth;

import com.example.demosecurity.entity.UserEntity;
import com.example.demosecurity.mapper.UserMapper;
import com.example.demosecurity.mapper.dto.UserResponse;
import com.example.demosecurity.service.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDAO{
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    public List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = new ArrayList<>();
        for (UserEntity item: userService.findUsers()
             ) {
            Set<SimpleGrantedAuthority> roles = new HashSet<>();
            item.getRoles().stream().forEach(
                    role -> roles.add(new SimpleGrantedAuthority("ROLE_" + role.getCode()))
            );

            ApplicationUser applicationUser = new ApplicationUser(
                    item.getUserName(),
                    passwordEncoder.encode(item.getPassword()),
                    roles,
                    true,
                    true,
                    true,
                    true
            );
            applicationUsers.add(applicationUser);
        }
        return applicationUsers;
    }
}
