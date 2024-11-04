package com.example.pawcare.entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Mascota {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String peso;
    private String raza;
    private String enfermedad;
    private String estado;
    private int edad;
    private String imagen;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = true)
    private Cliente cliente;

    @OneToOne(mappedBy = "mascota")
    private Tratamiento tratamiento;

    // Constructor actualizado para incluir el nuevo atributo
    public Mascota(Long id, String nombre, String peso, String raza, String enfermedad, String estado, int edad, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
        this.raza = raza;
        this.enfermedad = enfermedad;
        this.estado = estado;
        this.edad = edad;
        this.imagen = imagen;
    }

    public Mascota(String nombre, String peso, String raza, String enfermedad, String estado, int edad, String imagen) {
        this.nombre = nombre;
        this.peso = peso;
        this.raza = raza;
        this.enfermedad = enfermedad;
        this.estado = estado;
        this.edad = edad;
        this.imagen = imagen;
    }
}