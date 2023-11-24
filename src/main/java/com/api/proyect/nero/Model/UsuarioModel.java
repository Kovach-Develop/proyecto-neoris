package com.api.proyect.nero.Model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class UsuarioModel {
        @Id
        @GeneratedValue(generator = "uuid2")
        @GenericGenerator(name = "uuid2", strategy = "uuid2")
        private UUID id;

        private String name;
        private String email;
        private String password;
        private Date created;
        private Date modified;
        private Date lastLogin;
        @Column(unique = true)
        private String token;
        private boolean isActive;

        @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        private List<TelefonoModel> phones;
        public void setIsActive(boolean isActive) {
                this.isActive = isActive;
        }
}
