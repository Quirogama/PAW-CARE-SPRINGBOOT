package com.example.pawcare.DTOs;

import lombok.Data;

@Data
public class ClienteDTO {
    private String nombre;
    private String correo;
    private int cedula;
    private int celular;
}
