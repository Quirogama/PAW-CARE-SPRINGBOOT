package com.example.pawcare.servicio;

import java.util.List;

import com.example.pawcare.entidad.Cliente;
import com.example.pawcare.entidad.Mascota;

public interface ClienteService {
    public Cliente SearchById(Long id);
    public List<Cliente> SearchAll();
    public void add(Cliente cliente);
    public void deleteById(Long id);
    public void update(Cliente cliente);
    public Cliente SearchByCedula(int cedula);
    public void addMascota(Mascota mascota, int cedula);    
}
