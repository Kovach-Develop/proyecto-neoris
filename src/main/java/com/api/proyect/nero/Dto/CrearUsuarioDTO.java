package com.api.proyect.nero.Dto;

import lombok.Data;

import java.util.List;

@Data
public class CrearUsuarioDTO {
    private String name;
    private String email;
    private String password;
    private List<TelefonoDTO> phones;
}