package com.example.pawcare.repositorio;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.pawcare.entidad.Droga;

@Repository
public interface DrogaRepository extends JpaRepository<Droga, Long> {
    List<Droga> findByMascotaId(Long mascotaId);

    Droga findByNombre(String nombre);
    
    // Sumar el número total de unidades vendidas de todas las drogas (Ventas totales)
    @Query("SELECT SUM(d.unidadesVendidas) FROM Droga d")
    Integer getTotalVentas();  // Retorna el número total de unidades vendidas

    // Sumar todas las unidades vendidas multiplicadas por la diferencia entre precio de venta y precio de compra (Ganancias totales)
    @Query("SELECT SUM(d.unidadesVendidas * (d.precioVenta - d.precioCompra)) FROM Droga d")
    Float getTotalGanancias();  // Retorna la suma de las ganancias totales
}