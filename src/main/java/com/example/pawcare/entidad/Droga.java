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
public class Droga {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private float precioCompra;
    private float precioVenta;
    private int unidadesDisp;
    private int unidadesVendidas;

    @JsonIgnore
    @OneToMany(mappedBy = "droga", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tratamiento> tratamientos = new ArrayList<>();

    public Droga(Long id, String nombre, float precioCompra, float precioVenta, int unidadesDisp, int unidadesVendidas) {
        this.id = id;
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.unidadesDisp = unidadesDisp;
        this.unidadesVendidas = unidadesVendidas;
    }

    public Droga(String nombre, float precioCompra, float precioVenta, int unidadesDisp, int unidadesVendidas) {
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.unidadesDisp = unidadesDisp;
        this.unidadesVendidas = unidadesVendidas;
    }
}
