package com.example.apispringboot;

import org.springframework.stereotype.Service;

/**
 * Servicio para validar tokens de autenticación
 */

@Service
public class SecurityService {

    /**
     * Valida un token de autenticación
     */
    public boolean validateToken(String token){return (token.equals("TokenVictor"));}
}
