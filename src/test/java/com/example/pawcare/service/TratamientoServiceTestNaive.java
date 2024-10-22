package com.example.pawcare.service;

import java.util.Collection;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.pawcare.entidad.Tratamiento;
import com.example.pawcare.servicio.TratamientoService;

@SpringBootTest
public class TratamientoServiceTestNaive {
    
    @Autowired
    private TratamientoService tratamientoService;

    @Test
    public void TratamientoService_createTratamiento_Tratamiento() {

        Tratamiento tratamiento = new Tratamiento("10/20/2024", "Desparasitación interna y externa");
        Tratamiento tratamiento2 = new Tratamiento("10/20/2024", "otro");

        tratamientoService.add(tratamiento);
        tratamientoService.add(tratamiento2);

        Assertions.assertThat(tratamientoService.SearchAll()).size().isEqualTo(12); //10 de la BDD + 2 insertadas
    }

    @Test
    public void TratamientoService_updateTratamiento_Tratamiento() {

        Collection<Tratamiento> tratamientos = tratamientoService.SearchAll();
    
        Assertions.assertThat(tratamientos).isNotNull();
        Assertions.assertThat(tratamientos).size().isEqualTo(10);
    }

}
