package com.api.proyect.nero.Utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.UUID;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    // URL específica a la que se aplicará el interceptor
    private static final String URL_ESPECIFICA = "/api/usuarios/registro";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Verificar si la URL coincide con la URL específica
        String requestURI = request.getRequestURI();
        if (!requestURI.equals(URL_ESPECIFICA)) {
            // Si la URL no coincide, permitir la solicitud sin verificar el token
            return true;
        }

        // Si la URL coincide, realizar la lógica de verificación del token
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            String uuid = token.substring(7);
            try {
                UUID.fromString(uuid);
                return true;
            } catch (IllegalArgumentException e) {
            }
        }

        // Si el token no es válido, enviar una respuesta de error
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token UUID no válido o no presente");
        return false;
    }
}