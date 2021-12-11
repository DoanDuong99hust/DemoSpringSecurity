package com.example.demosecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.example.demosecurity.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    protected UserDetailsService userDetailsService() {
        UserDetails duongUser = User.builder()
                .username("duong")
                .password(passwordEncoder.encode("pass"))
                .roles(STUDENT.name()) //ROLE_STUDENT
                .build();

        UserDetails shisuiUser = User.builder()
                .username("shisui")
                .password(passwordEncoder.encode("pass"))
                .roles(ADMIN.name()) //ROLE_ADMIN
                .build();

        UserDetails doanUser = User.builder()
                .username("doan")
                .password(passwordEncoder.encode("pass"))
                .roles(ADMINTRAINEE.name()) //ROLE_ADMINTRAINEE
                .build();

        return new InMemoryUserDetailsManager(
                duongUser,
                shisuiUser,
                doanUser
        );
    }
}
