package com.example.pawcare.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.pawcare.entidad.Tratamiento;

@Repository	
public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {
    @Query("SELECT COUNT(t) FROM Tratamiento t WHERE t.fecha BETWEEN :startDate AND :endDate")
    Long countTratamientosByFechaBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);

    @Query("SELECT t FROM Tratamiento t WHERE t.mascota.id = :id")
    Tratamiento findByMascotaId(@Param("id") Long id);
}