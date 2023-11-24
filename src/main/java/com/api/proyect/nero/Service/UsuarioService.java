package com.api.proyect.nero.Service;


import com.api.proyect.nero.Dto.CrearUsuarioDTO;
import com.api.proyect.nero.Model.UsuarioModel;

public interface UsuarioService {
    UsuarioModel crearUsuario(CrearUsuarioDTO usuarioDTO);
}
