package com.api.proyect.nero.Service;


import com.api.proyect.nero.Dto.CrearUsuarioDTO;
import com.api.proyect.nero.Dto.TelefonoDTO;
import com.api.proyect.nero.Model.TelefonoModel;
import com.api.proyect.nero.Model.UsuarioModel;
import com.api.proyect.nero.Repository.TelefonoRepository;
import com.api.proyect.nero.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TelefonoRepository telefonoRepository;

    public UsuarioModel crearUsuario(CrearUsuarioDTO usuarioDTO) {
        // Validaciones de formato y duplicados
        if (!isValidEmail(usuarioDTO.getEmail())) {
            throw new IllegalArgumentException("Formato de correo incorrecto");
        }

        if (!isValidPassword(usuarioDTO.getPassword())) {
            throw new IllegalArgumentException("Formato de contraseña incorrecto");
        }

        if (usuarioRepository.findByEmail(usuarioDTO.getEmail()) != null) {
            throw new IllegalArgumentException("El correo ya está registrado");
        }

        // Crear la instancia de UsuarioModel y configurar las fechas y token
        UsuarioModel usuario = new UsuarioModel();
        usuario.setName(usuarioDTO.getName());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setPassword(usuarioDTO.getPassword());

        usuario.setId(UUID.randomUUID());
        usuario.setCreated(new Date());
        usuario.setModified(new Date());
        usuario.setLastLogin(usuario.getCreated());
        usuario.setToken(UUID.randomUUID().toString());
        usuario.setIsActive(true);

        // Inicializar la lista de teléfonos
        usuario.setPhones(new ArrayList<>());

        // Guardar el usuario
        UsuarioModel savedUsuario = usuarioRepository.save(usuario);

        if (usuarioDTO.getPhones() != null) {
            for (TelefonoDTO telefonoDTO : usuarioDTO.getPhones()) {
                TelefonoModel telefono = new TelefonoModel();
                telefono.setNumber(telefonoDTO.getNumber());
                telefono.setCitycode(telefonoDTO.getCitycode());
                telefono.setCountrycode(telefonoDTO.getCountrycode());

                savedUsuario.getPhones().add(telefono);

                // Guardar el teléfono
                telefonoRepository.save(telefono);
            }
        }

        return savedUsuario;
    }


    private boolean isValidEmail(String email) {
        return true;
    }

    private boolean isValidPassword(String password) {
        return true;
    }

}

