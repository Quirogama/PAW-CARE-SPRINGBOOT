package com.example.pawcare.entidad;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
public class Cliente {

    @OneToOne(cascade=CascadeType.ALL)
    private UserEntity userEntity;

    @Column(name = "NAME")
    private String nombre;
    private String correo;
    private int cedula;
    private int celular;

    @Transient
    private String clave;


    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "cliente")
    private List<Mascota> mascotas = new ArrayList<>();

    public Cliente(Long id, String nombre, String correo, int cedula, int celular, String clave) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.cedula = cedula;
        this.celular = celular;
        this.clave = clave;
    }

    public Cliente() {
    }

    public Cliente(String nombre, String correo, int cedula, int celular, String clave) {
        this.nombre = nombre;
        this.correo = correo;
        this.cedula = cedula;
        this.celular = celular;
        this.clave = clave;
    }
}