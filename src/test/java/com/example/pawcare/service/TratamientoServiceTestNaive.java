package com.example.pawcare.service;

import java.time.LocalDate;
import java.util.Collection;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.pawcare.entidad.Tratamiento;
import com.example.pawcare.repositorio.TratamientoRepository;
import com.example.pawcare.servicio.TratamientoService;

@SpringBootTest
public class TratamientoServiceTestNaive {
    
    @Autowired
    private TratamientoService tratamientoService;

    @Autowired
    private TratamientoRepository tratamientoRepository;

    @BeforeEach
    void setUp(){
        tratamientoRepository.save(new Tratamiento(LocalDate.parse("2024-10-20"), "Desparasitación interna y externa"));
        tratamientoRepository.save(new Tratamiento(LocalDate.parse("2024-10-21"),  "Vacunación contra la rabia"));
        tratamientoRepository.save(new Tratamiento(LocalDate.parse("2024-10-22"), "Limpieza dental y pulido"));
        tratamientoRepository.save(new Tratamiento(LocalDate.parse("2024-10-23"), "Aplicación de antipulgas y garrapatas"));
        tratamientoRepository.save(new Tratamiento(LocalDate.parse("2024-10-24"), "Tratamiento para infecciones oculares"));
    }

    @Test
    public void TratamientoServiceNaive_addTratamiento_Tratamiento(){
        Tratamiento tratamientoPrueba = new Tratamiento(LocalDate.parse("2024-10-20"), "Desparasitación interna y externa");
        Tratamiento nuevoTratamiento = tratamientoService.agregar(tratamientoPrueba);

        Assertions.assertThat(nuevoTratamiento).isNotNull();
        Assertions.assertThat(nuevoTratamiento.getId()).isEqualTo(33L);
    }

    @Test
    public void TratamientoServiceNaive_FindById_Tratamiento(){
        Long index = 1L;

        Tratamiento tratamientoRecibido = tratamientoService.SearchById(index);

        Assertions.assertThat(tratamientoService.SearchById(index)).isNotNull();
        Assertions.assertThat(tratamientoService.SearchById(index).getId()).isEqualTo(1);
    }

    @Test
    public void TratamientoService_createTratamiento_Tratamiento() {

        Tratamiento tratamiento = new Tratamiento(LocalDate.parse("2024-10-20"),  "Desparasitación interna y externa");
        Tratamiento tratamiento2 = new Tratamiento(LocalDate.parse("2024-10-20"), "Otro");

        tratamientoService.add(tratamiento);
        tratamientoService.add(tratamiento2);

        Assertions.assertThat(tratamientoService.SearchAll()).size().isEqualTo(22); //10 de la BDD + 2 insertadas aqui + 5 locales
    }

    @Test
    public void TratamientoService_updateTratamiento_Tratamiento() {

        Collection<Tratamiento> tratamientos = tratamientoService.SearchAll();
    
        Assertions.assertThat(tratamientos).isNotNull();
        Assertions.assertThat(tratamientos).size().isEqualTo(15); 
    }
}
