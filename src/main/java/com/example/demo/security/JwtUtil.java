package com.example.demo.security;

import io.jsonwebtoken.Claims;
import java.util.Map;

public class JwtUtil {
    public String generateToken(Map<String, Object> claims, String username) {
        return "JWT_TOKEN";
    }
    
    public String getUsername(String token) {
        return getClaims(token).getSubject();
    }
    
    public Claims getClaims(String token) {
        return null;
    }
    
    public boolean isTokenValid(String token, String username) {
        return getUsername(token).equals(username);
    }
    
    public long getExpirationMillis() {
        return 3600000L;
    }
}