package com.example.pawcare.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pawcare.entidad.Mascota;
import com.example.pawcare.repositorio.MascotaRepository;
@Service
public class MascotaServiceImpl implements MascotaService {
    
    @Autowired
    MascotaRepository mascotaRepository;

    @Override
    public Mascota SearchById(Long id) {
        // TODO Auto-generated method stub
        return mascotaRepository.findById(id).get();
    }
    @Override
    public List<Mascota> SearchAll() {
        // TODO Auto-generated method stub
        return mascotaRepository.findAll();
    }

    @Override
    public List<Mascota> SearchByClienteId(Long id) {
        // TODO Auto-generated method stub
        return mascotaRepository.findByClienteId(id);
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        mascotaRepository.deleteById(id);
    }
    @Override
    public void add(Mascota mascota) {
        // TODO Auto-generated method stub
        mascotaRepository.save(mascota);
    }
    @Override
    public void update(Mascota mascota) {
        // TODO Auto-generated method stub
        mascotaRepository.save(mascota);
    }

    // Implementación del método para obtener la cantidad total de mascotas
    @Override
    public Long getTotalMascotas() {
        return mascotaRepository.count();
    }
}