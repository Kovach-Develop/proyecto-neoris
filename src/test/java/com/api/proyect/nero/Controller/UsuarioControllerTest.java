package com.api.proyect.nero.Controller;

import com.api.proyect.nero.Dto.CrearUsuarioDTO;
import com.api.proyect.nero.Model.UsuarioModel;
import com.api.proyect.nero.Service.TokenService;
import com.api.proyect.nero.Service.UsuarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

class UsuarioControllerTest {
    @Mock
    UsuarioService usuarioService;
    @Mock
    TokenService tokenService;
    @InjectMocks
    UsuarioController usuarioController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegistrarUsuario() {
        when(usuarioService.crearUsuario(any())).thenReturn(new UsuarioModel());

        ResponseEntity<?> result = usuarioController.registrarUsuario(new CrearUsuarioDTO());
        Assertions.assertEquals(result, result);
    }

    @Test
    void testObtenerToken() {
        when(tokenService.generarToken()).thenReturn("generarTokenResponse");

        ResponseEntity<String> result = usuarioController.obtenerToken();
        Assertions.assertEquals(result, result);
    }
}
