package com.api.proyect.nero.Dto;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@Data
public class UsuarioResponseDTO {
    private UUID id;
    private String name;
    private String email;
    private Date created;
    private Date modified;
    private Date lastLogin;
    private String token;
    private boolean isActive;
    private List<TelefonoDTO> phones;

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
