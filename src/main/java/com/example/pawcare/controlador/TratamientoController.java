package com.example.pawcare.controlador;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pawcare.entidad.Droga;
import com.example.pawcare.entidad.Mascota;
import com.example.pawcare.entidad.Tratamiento;
import com.example.pawcare.entidad.Veterinario;
import com.example.pawcare.servicio.DrogaService;
import com.example.pawcare.servicio.MascotaService;
import com.example.pawcare.servicio.TratamientoService;
import com.example.pawcare.servicio.VeterinarioService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/tratamiento")
@CrossOrigin(origins = "http://localhost:4200")
public class TratamientoController {

    @Autowired
    private TratamientoService tratamientoService;

    @Autowired
    private VeterinarioService veterinarioService;

    @Autowired
    private MascotaService mascotaService;

    @Autowired
    private DrogaService drogaService;
    
    @PostMapping("/add")
    public void addTratamiento(@RequestBody Tratamiento tratamiento) {
        tratamientoService.add(tratamiento);
    }
    
    @PostMapping("/agregar/{idVET}/{idMASC}/{idDROGA}")
    public void agregarTratamientoNuevo(@PathVariable("idVET") Long idVET,@PathVariable("idMASC") Long idMASC,@PathVariable("idDROGA") Long idDROGA,@RequestParam("descripcion") String descripcion,@RequestParam("fecha") String fecha) {

        Tratamiento tratamiento = new Tratamiento();
        tratamiento.setDescripcion(descripcion);
        tratamiento.setFecha(LocalDate.parse(fecha)); 

        Droga droga = drogaService.SearchById(idDROGA);
        Mascota mascota = mascotaService.SearchById(idMASC);
        Veterinario veterinario = veterinarioService.SearchById(idVET);

        tratamiento.setDroga(droga);
        tratamiento.setMascota(mascota);
        tratamiento.setVeterinario(veterinario);

        tratamientoService.add(tratamiento);

        String tratamientoHistorial = tratamiento.toString();
        mascota.addToHistorialMedico(tratamientoHistorial);
        mascota.setEstado("En tratamiento");
        mascotaService.update(mascota);

        veterinario.setNumAtenciones(veterinario.getNumAtenciones() + 1);
        veterinarioService.update(veterinario);

        droga.setUnidadesVendidas(droga.getUnidadesVendidas() + 1);
        droga.setUnidadesDisp(droga.getUnidadesDisp() - 1);
        drogaService.update(droga);
    }

    @DeleteMapping("/eliminar/{id}")
    public void borrarTratamiento(@PathVariable("id") Long id) {
        System.out.println("\n\n\n\n\nID ENTRADA --> " + id);
        Tratamiento tratamiento = tratamientoService.SearchById(id);
        Mascota mascota = tratamiento.getMascota();

        tratamientoService.deleteById(id);

        mascota.setEstado("Recuperado");
        mascotaService.update(mascota);

        Veterinario veterinario = tratamiento.getVeterinario();
        veterinario.getTratamientos().remove(tratamiento);
        
        veterinarioService.update(veterinario);
    }


    @GetMapping("/all")
    public Collection<Tratamiento> getMethodName() {
        return tratamientoService.SearchAll();
    }


    @GetMapping("/mascota/{id}")
    public Tratamiento getTratamientoMascota(@PathVariable("id") Long id) {
        return tratamientoService.SearchByMascotaId(id);
    }

    /*
     @GetMapping("/cantidadUltimoMes")
    public ResponseEntity<Long> getCantidadTratamientosUltimoMes() {
        Long cantidadTratamientos = tratamientoService.getCantidadTratamientosUltimoMes();
        return ResponseEntity.ok(cantidadTratamientos);
    }
    */
}
