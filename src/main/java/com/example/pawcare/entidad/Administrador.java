package com.example.pawcare.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Administrador {

    @Id
    @GeneratedValue
    private Long id;
    
    private String clave;
    
    private int cedula;

    public Administrador(Long id, int cedula, String clave) {
        this.id = id;
        this.cedula = cedula;
        this.clave = clave;
    }
    
    public Administrador(int cedula, String clave) {
        this.cedula = cedula;
        this.clave = clave;
    }
}
