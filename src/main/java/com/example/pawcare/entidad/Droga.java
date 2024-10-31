package com.example.pawcare.entidad;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Droga {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private float precioCompra;
    private float precioVenta;
    private int unidadesDisp;
    private int unidadesVendidas;
    @ManyToOne
    private Mascota mascota;

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

    public Droga() {
    }

    public Droga(String nombre, float precioCompra, float precioVenta, int unidadesDisp, int unidadesVendidas) {
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.unidadesDisp = unidadesDisp;
        this.unidadesVendidas = unidadesVendidas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getUnidadesDisp() {
        return unidadesDisp;
    }

    public void setUnidadesDisp(int unidadesDisp) {
        this.unidadesDisp = unidadesDisp;
    }

    public int getUnidadesVendidas() {
        return unidadesVendidas;
    }

    public void setUnidadesVendidas(int unidadesVendidas) {
        this.unidadesVendidas = unidadesVendidas;
    }

    public List<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamientos.add(tratamiento);
    }
}
