package com.api.proyect.nero.Controller;

import com.api.proyect.nero.Dto.CrearUsuarioDTO;
import com.api.proyect.nero.Model.UsuarioModel;
import com.api.proyect.nero.Service.TokenService;
import com.api.proyect.nero.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TokenService tokenService;

    public UsuarioController(UsuarioService usuarioService, TokenService tokenService) {
        this.usuarioService = usuarioService;
        this.tokenService = tokenService;
    }

    @PostMapping("/registro")
    public ResponseEntity<?> registrarUsuario(@RequestBody CrearUsuarioDTO usuario) {
        try {
            UsuarioModel nuevoUsuario = usuarioService.crearUsuario(usuario);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(nuevoUsuario);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @GetMapping("/token")
    public ResponseEntity<String> obtenerToken() {
        String token = tokenService.generarToken();
        return ResponseEntity.ok(token);
    }
}
