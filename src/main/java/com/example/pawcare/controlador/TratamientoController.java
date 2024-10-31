package com.example.pawcare.controlador;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import com.example.pawcare.entidad.Droga;
import com.example.pawcare.entidad.Mascota;
import com.example.pawcare.entidad.Tratamiento;
import com.example.pawcare.servicio.DrogaService;
import com.example.pawcare.servicio.MascotaService;
import com.example.pawcare.servicio.TratamientoService;
import com.example.pawcare.servicio.VeterinarioService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pawcare.entidad.Veterinario;


@RestController
@RequestMapping("/tratamiento")
@CrossOrigin(origins = "http://localhost:4200")  // Permitir solicitudes desde Angular
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
    public void agregarTratamientoNuevo(Model model, @PathVariable("idVET") Long idVET, @PathVariable("idMASC") Long idMASC, @PathVariable("idDROGA") Long idDROGA, @RequestBody Tratamiento tratamiento) {
        Droga droga = drogaService.SearchById(idVET);
        Mascota mascota = mascotaService.SearchById(idMASC);
        Veterinario veterinario = veterinarioService.SearchById(idVET);

        mascota.setEstado("En tratamiento");

        tratamiento.setDroga(droga);
        tratamiento.setMascota(mascota);
        tratamiento.setVeterinario(veterinario);

        tratamientoService.add(tratamiento);
    }
    

    @PostMapping("/agregar/{cedula}/{nombredroga}/{id}")
    public void agregarTratamiento(@PathVariable("cedula") int cedula, @PathVariable("nombredroga") String nombredroga, @PathVariable("id") Long id , @RequestBody Tratamiento tratamiento) {      
          Droga droga = drogaService.findByName(nombredroga);
          Veterinario veterinario = veterinarioService.SearchByCedula(cedula);
          Mascota mascota = mascotaService.SearchById(id);
          
          mascota.setEstado("En tratamiento");

          tratamiento.setDroga(droga);
          tratamiento.setVeterinario(veterinario);
          tratamiento.setMascota(mascota);
          System.out.println("\n\n\n\n\nFECHA -->"+tratamiento.getFecha());
          tratamientoService.add(tratamiento);
    }

    @PostMapping("/agregar/{cedula}/{nombredroga}")
    public void agregarTratamientoVD(@PathVariable("cedula") int cedula, @PathVariable("nombredroga") String nombredroga, @RequestBody Tratamiento tratamiento) {      
          Droga droga = drogaService.findByName(nombredroga);
          Veterinario veterinario = veterinarioService.SearchByCedula(cedula);
          
          tratamiento.setDroga(droga);
          tratamiento.setVeterinario(veterinario);
          System.out.println("\n\n\n\n\nFECHA -->"+tratamiento.getFecha());
          tratamientoService.add(tratamiento);
    }
    

    @GetMapping("/all")
    public Collection<Tratamiento> getMethodName() {
        return tratamientoService.SearchAll();
    }

    /*
     @GetMapping("/cantidadUltimoMes")
    public ResponseEntity<Long> getCantidadTratamientosUltimoMes() {
        Long cantidadTratamientos = tratamientoService.getCantidadTratamientosUltimoMes();
        return ResponseEntity.ok(cantidadTratamientos);
    }
    */
}
