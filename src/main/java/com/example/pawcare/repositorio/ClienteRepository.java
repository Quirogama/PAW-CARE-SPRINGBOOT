package com.example.pawcare.repositorio;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.pawcare.entidad.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    Cliente findByCedula(int cedula);

    @Query("SELECT c FROM Cliente c WHERE c.id < 25")
    List<Cliente> findAllByIdLessThan(int id);

    
}

//public interface MascotaRepository extends JpaRepository<Mascota, Long> {
    
//}