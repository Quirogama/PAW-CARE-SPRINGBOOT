package com.example.pawcare.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.pawcare.entidad.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {
    
    List<Mascota> findByClienteId(Long id);

    @Query("SELECT COUNT(m) FROM Mascota m WHERE m.estado = 'En tratamiento'")
    Long countMascotasActivas();
}