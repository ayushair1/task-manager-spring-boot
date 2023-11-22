package com.consultadd.Taskmanager.service;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JWTService {
//    String extractUserName(String token);

//    String generateToken(UserDetails userDetails);

    public String generateToken(UserDetails userDetails);
    public String refreshToken(Map<String,Object> extraClaims, UserDetails userDetails);
    public Boolean validateToken(String token, UserDetails userDetails);
    public String extractUsername(String token);
}
