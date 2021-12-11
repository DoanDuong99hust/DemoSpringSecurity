package com.example.demosecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import static com.example.demosecurity.security.ApplicationUserPermission.*;
import static com.example.demosecurity.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // Cross Site Request Forgery: https://owasp.org/www-community/attacks/csrf
                // how spring security generate csrf token
                // use when client send a request to server using web browser(chrome, firefox)
//                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/api/**").hasRole(STUDENT.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic(); // Basic Auth
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails duongUser = User.builder()
                .username("duong")
                .password(passwordEncoder.encode("pass"))
                .authorities(STUDENT.getGrantedAuthorities()) // Add authority to STUDENT
                .build();

        UserDetails shisuiUser = User.builder()
                .username("shisui")
                .password(passwordEncoder.encode("pass"))
                .authorities(ADMIN.getGrantedAuthorities()) // Add authority to ADMIN
                .build();

        UserDetails doanUser = User.builder()
                .username("doan")
                .password(passwordEncoder.encode("pass"))
                .authorities(ADMINTRAINEE.getGrantedAuthorities()) // Add authority to ADMINTRAINEE
                .build();
        return new InMemoryUserDetailsManager(
                duongUser,
                shisuiUser,
                doanUser
        );
    }
}
