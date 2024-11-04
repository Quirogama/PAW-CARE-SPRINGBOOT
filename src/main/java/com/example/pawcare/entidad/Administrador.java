package com.example.pawcare.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
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

    public Administrador() {
    }

    public Administrador(int cedula, String clave) {
        this.cedula = cedula;
        this.clave = clave;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
