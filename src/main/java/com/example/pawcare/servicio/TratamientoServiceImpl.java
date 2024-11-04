package com.example.pawcare.servicio;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pawcare.entidad.Tratamiento;
import com.example.pawcare.repositorio.TratamientoRepository;
@Service
public class TratamientoServiceImpl implements TratamientoService {
    
    @Autowired
    TratamientoRepository tratamientoRepository;

    @Override
    public Collection<Tratamiento> SearchAll() {
        return tratamientoRepository.findAll();
    }

    @Override
    public Tratamiento SearchById(Long id) {
        return tratamientoRepository.findById(id).get();
    }

    @Override
    public void add(Tratamiento tratamiento) {
        tratamientoRepository.save(tratamiento);
    }

    @Override
    public void deleteById(Long id) {
        tratamientoRepository.deleteById(id);
    }

    @Override
    public void update(Tratamiento droga) {
        tratamientoRepository.save(droga);
    }

    @Override
    public Tratamiento agregar(Tratamiento tratamiento){
        return tratamientoRepository.save(tratamiento);
    }

    // Nuevo método para obtener la cantidad de tratamientos del último mes
}
