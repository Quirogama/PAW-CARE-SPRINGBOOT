package com.example.pawcare.servicio;

import java.util.Collection;

import com.example.pawcare.entidad.Tratamiento;

public interface TratamientoService {
    public Tratamiento SearchById(Long id);
    public Collection<Tratamiento> SearchAll();
    public void add(Tratamiento tratamiento);
    public void deleteById(Long id);
    public void update(Tratamiento tratamiento);
    public Tratamiento agregar(Tratamiento tratamiento);
    public Tratamiento SearchByMascotaId(Long id);
}
