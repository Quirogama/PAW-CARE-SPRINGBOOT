package com.example.pawcare.service;

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
        tratamientoRepository.save(new Tratamiento("10/20/2024", "Desparasitación interna y externa"));
        tratamientoRepository.save(new Tratamiento("10/21/2024", "Vacunación contra la rabia"));
        tratamientoRepository.save(new Tratamiento("10/22/2024", "Limpieza dental y pulido"));
        tratamientoRepository.save(new Tratamiento("10/23/2024", "Aplicación de antipulgas y garrapatas"));
        tratamientoRepository.save(new Tratamiento("10/20/2024", "Tratamiento para infecciones oculares"));
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

        Tratamiento tratamiento = new Tratamiento("10/20/2024", "Desparasitación interna y externa");
        Tratamiento tratamiento2 = new Tratamiento("10/20/2024", "Otro");

        tratamientoService.add(tratamiento);
        tratamientoService.add(tratamiento2);

        Assertions.assertThat(tratamientoService.SearchAll()).size().isEqualTo(17); //10 de la BDD + 2 insertadas aqui + 5 locales
    }

    @Test
    public void TratamientoService_updateTratamiento_Tratamiento() {

        Collection<Tratamiento> tratamientos = tratamientoService.SearchAll();
    
        Assertions.assertThat(tratamientos).isNotNull();
        Assertions.assertThat(tratamientos).size().isEqualTo(15); 
    }

}
