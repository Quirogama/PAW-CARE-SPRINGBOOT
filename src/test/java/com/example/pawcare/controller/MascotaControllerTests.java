package com.example.pawcare.controller;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.pawcare.controlador.MascotaController;
import com.example.pawcare.entidad.Mascota;
import com.example.pawcare.servicio.ClienteService;
import com.example.pawcare.servicio.MascotaService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = MascotaController.class)
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class MascotaControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MascotaService mascotaService;

    @MockBean
    private ClienteService clienteService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void MascotaController_agregarMascota_Mascota() throws Exception {
        Mascota mascota = new Mascota("Daisy", "5", "Dachshund", "Problemas dentales", "Recuperado", 4, "assets/img/perroGenerico.png");

        when(mascotaService.agregarMascota(Mockito.any(Mascota.class))).thenReturn(mascota);

        ResultActions response = mockMvc.perform(
                post("/mascota/registro")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(mascota)));
                
        response.andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.nombre").value(mascota.getNombre()));
    }

    @Test
    public void MascotaController_findAll_Mascotas() throws Exception {
        when(mascotaService.SearchAll()).thenReturn(
            List.of(
                new Mascota("Daisy", "5", "Dachshund", "Problemas dentales", "Recuperado", 4, "assets/img/perroGenerico.png"),
                new Mascota("Daisy2", "5", "Dachshund", "Problemas dentales", "Recuperado", 4, "assets/img/perroGenerico.png")
            )
        );

        ResultActions response = mockMvc.perform(
                get("/mascota/all"));

        response.andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    public void MascotaController_findById_Mascota() throws Exception {
        Long id = 1L;

        when(mascotaService.SearchById(id)).thenReturn(
            new Mascota("Daisy", "5", "Dachshund", "Problemas dentales", "Recuperado", 4, "assets/img/perroGenerico.png")
        );

        ResultActions response = mockMvc.perform(
                get("/mascota/1"));

        response.andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.nombre").value("Daisy"));
    }

    @Test
    public void MascotaController_findMascotasDeCliente_Mascotas() throws Exception {
        Long id = 1L;

        when(mascotaService.SearchByClienteId(id)).thenReturn(
            List.of(
                new Mascota("Daisy", "5", "Dachshund", "Problemas dentales", "Recuperado", 4, "assets/img/perroGenerico.png"),
                new Mascota("Daisy2", "5", "Dachshund", "Problemas dentales", "Recuperado", 4, "assets/img/perroGenerico.png")
            )
        );

        ResultActions response = mockMvc.perform(
                get("/mascota/cliente/1"));

        response.andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    public void MascotaController_findActivas_Mascota() throws Exception {
        when(mascotaService.getCantidadMascotasActivas()).thenReturn(
            5L
        );

        ResultActions response = mockMvc.perform(
                get("/mascota/activas"));

        response.andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$").value(5));
    }

    @Test
    public void MascotaController_Delete() throws Exception {
        ResultActions response = mockMvc.perform(
                delete("/mascota/eliminar/1"));

        response.andExpect(status().isNoContent());
    }

    @Test    
    public void MascotaController_Update_NotFound() throws Exception {
        Long id = 1L;
        Mascota mascota = new Mascota("Daisy", "5", "Dachshund", "Problemas dentales", "Recuperado", 4, "assets/img/perroGenerico.png");
            
        when(mascotaService.SearchById(id)).thenReturn(null);
    
        ResultActions response = mockMvc.perform(
                put("/mascota/modificar/0")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(mascota)));
    
        response.andExpect(status().isNotFound());
    } 

    @Test
    public void MascotaController_Update() throws Exception {
        Long id = 1L;
        Mascota mascota = new Mascota("DaisyMod", "5", "Dachshund", "Problemas dentales", "Recuperado", 4, "assets/img/perroGenerico.png");
            
        when(mascotaService.SearchById(id)).thenReturn(mascota);
    
        ResultActions response = mockMvc.perform(
                put("/mascota/modificar/1")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(mascota)));
    
        response.andExpect(status().isOk());
    }
}