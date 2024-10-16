package com.example.pawcare.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pawcare.entidad.Veterinario;
import com.example.pawcare.repositorio.VeterinarioRepository;

@Service
public class VeterinarioServiceImpl implements VeterinarioService {
    
    @Autowired
    VeterinarioRepository veterinarioRepository;

    @Override
    public Veterinario SearchById(Long id) {
        return veterinarioRepository.findById(id).get();
    }

    @Override
    public List<Veterinario> SearchAll() {
        return veterinarioRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        veterinarioRepository.deleteById(id);
    }

    @Override
    public void add(Veterinario veterinario) {
        veterinarioRepository.save(veterinario);
    }

    @Override
    public void update(Veterinario veterinario) {
        veterinarioRepository.save(veterinario);
    }

    @Override
    public Veterinario SearchByCedula(int cedula) {
        return veterinarioRepository.findByCedula(cedula);
    }
}
