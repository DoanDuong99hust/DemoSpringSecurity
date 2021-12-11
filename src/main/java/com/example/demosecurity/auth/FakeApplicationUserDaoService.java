package com.example.demosecurity.auth;

import com.example.demosecurity.security.ApplicationUserRole;
import com.google.common.collect.Lists;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.demosecurity.security.ApplicationUserRole.*;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDAO{
    private final PasswordEncoder passwordEncoder;

    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    public List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
            new ApplicationUser(
                    "duong",
                    passwordEncoder.encode("pass"),
                    STUDENT.getGrantedAuthorities(),
                    true,
                    true,
                    true,
                    true
            ),new ApplicationUser(
                    "shisui",
                    passwordEncoder.encode("pass"),
                    ADMIN.getGrantedAuthorities(),
                    true,
                    true,
                    true,
                    true
            ),new ApplicationUser(
                    "doan",
                    passwordEncoder.encode("pass"),
                    ADMINTRAINEE.getGrantedAuthorities(),
                    true,
                    true,
                    true,
                    true
            )
        );
        return applicationUsers;
    }
}
