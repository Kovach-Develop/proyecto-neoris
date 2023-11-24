package com.api.proyect.nero.Model;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class TelefonoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private String citycode;
    private String countrycode;
}