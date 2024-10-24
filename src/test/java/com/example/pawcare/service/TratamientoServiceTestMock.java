package com.example.pawcare.service;

import java.time.LocalDate;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import com.example.pawcare.entidad.Tratamiento;
import com.example.pawcare.repositorio.TratamientoRepository;
import com.example.pawcare.servicio.TratamientoServiceImpl;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class TratamientoServiceTestMock {

    @InjectMocks
    private TratamientoServiceImpl tratamientoService;


    @Mock
    private TratamientoRepository tratamientoRepository;

    @BeforeEach
    public void setUp() {}

    @Test
    public void TratamientoService_addTratamiento_Tratamiento() {
        Tratamiento tratamientoPrueba = new Tratamiento(LocalDate.parse("2024-10-20"),  "Desparasitación interna y externa");
        when(tratamientoRepository.save(tratamientoPrueba)).thenReturn(tratamientoPrueba);

        Tratamiento tratamientoNuevo = tratamientoService.agregar(tratamientoPrueba);

        Assertions.assertThat(tratamientoNuevo).isNotNull();
    }

    @Test
    public void TratamientoService_FindById_Tratamiento() {
        Long id = 1L;

        Tratamiento tratamiento = new Tratamiento(1L,LocalDate.parse("2024-10-20"), "Desparasitación interna y externa");
        when(tratamientoRepository.findById(1L)).thenReturn(
            Optional.of(tratamiento));

        Tratamiento tratamientoRecibido = tratamientoService.SearchById(id);

        Assertions.assertThat(tratamientoRecibido).isNotNull();
        Assertions.assertThat(tratamientoRecibido.getId()).isEqualTo(id);
    }

    /*
     @Test
    public void TratamientoService_FindCantTratamientosUltimoMes_Long(){
        Long CantTratamientos = 5L;
        
        when(tratamientoRepository.countTratamientosByFechaBetweenALT(LocalDate.now().minusMonths(1), LocalDate.now())).thenReturn(CantTratamientos);

        Assertions.assertThat(tratamientoService.getCantidadTratamientosUltimoMes()).isNotNull();
        Assertions.assertThat(tratamientoService.getCantidadTratamientosUltimoMes()).isEqualTo(CantTratamientos);
    }
     */
}
