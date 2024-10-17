package com.example.pawcare.servicio;

import java.util.List;

import com.example.pawcare.entidad.Mascota;

public interface MascotaService {

    public Mascota SearchById(Long id);

    public List<Mascota> SearchAll();

    public List<Mascota> SearchByClienteId(Long id);

    public void add(Mascota mascota);
    public void deleteById(Long id);
    public void update(Mascota mascota);

    public Long getTotalMascotas();
}