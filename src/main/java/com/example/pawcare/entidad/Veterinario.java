package com.example.pawcare.entidad;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Veterinario {
    @Id	
    @GeneratedValue
    private Long id;

    private String nombre;
    private int cedula;
    private String especialidad;
    private String clave;

    private String imagen;

    private int numAtenciones;
    
    @JsonIgnore
    @OneToMany(mappedBy = "veterinario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tratamiento> tratamientos = new ArrayList<>();

    public Veterinario(Long id, String nombre, int cedula, String especialidad, String imagen, int numAtenciones, String clave) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.especialidad = especialidad;
        this.imagen = imagen;
        this.numAtenciones = numAtenciones;
        this.clave = clave;
    }

    public Veterinario(String nombre, int cedula, String especialidad, String imagen, int numAtenciones, String clave) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.especialidad = especialidad;
        this.imagen = imagen;
        this.numAtenciones = numAtenciones;
        this.clave = clave;
    }
}
