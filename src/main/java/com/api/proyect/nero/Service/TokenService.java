package com.api.proyect.nero.Service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TokenService {

    public String generarToken() {
        String tokenId = UUID.randomUUID().toString();

        return tokenId;
    }
}
