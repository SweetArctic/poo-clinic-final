package com.clinica.proyecto.security;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

@Service
public class AuthTokenService {
    private final Map<String, String> tokens = new ConcurrentHashMap<>();

    public String createToken(String username) {
        String token = UUID.randomUUID().toString();
        tokens.put(token, username);
        return token;
    }

    public boolean isValid(String token) {
        return token != null && tokens.containsKey(token);
    }

    public void invalidate(String token) {
        tokens.remove(token);
    }
}

