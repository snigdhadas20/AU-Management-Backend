package com.project.aumanagement.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.project.aumanagement.enums.Role;


@Component
@Service
public interface IJwtTokenProviderService {
    String createToken(String username, Role role);
    Authentication validateUserAndGetAuthentication(String token);
    String getUsername(String token);
    String parseToken(HttpServletRequest req);
    boolean validateToken(String token);

}