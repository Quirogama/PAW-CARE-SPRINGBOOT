package com.example.pawcare.controlador;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pawcare.entidad.Tratamiento;
import com.example.pawcare.entidad.Veterinario;
import com.example.pawcare.servicio.VeterinarioService;


@RestController
@RequestMapping("/veterinario")
@CrossOrigin(origins = "http://localhost:4200")
public class VeterinarioController {
    
    @Autowired
    VeterinarioService veterinarioService;

    //http://localhost:8080/veterinario/all
    @GetMapping("/all")
    public List<Veterinario> mostrarVeterinarios(Model model){
        
        return veterinarioService.SearchAll();
    }

    @GetMapping("/{id}")
        public Veterinario mostrarInfoVeterinario(@PathVariable("id") Long id){
        
        Veterinario veterinario = veterinarioService.SearchById(id);

        return veterinario;
    }

    @GetMapping("/cedula/{cedula}")
    public Veterinario mostrarInfoVeterinario(@PathVariable("cedula") int cedula){
        Veterinario veterinario = veterinarioService.SearchByCedula(cedula);
        return veterinario;
    }

    //http://localhost:8080/veterinario/add
    @GetMapping("/add")
    public String mostrarFormularioRegistro(Model model) {
        Veterinario veterinario = new Veterinario();
        model.addAttribute("veterinario", veterinario);
        return "crear_veterinario";
    }

    @PostMapping("/add")
    public void agregarVeterinario(@RequestBody Veterinario veterinario) {
        veterinarioService.add(veterinario);
    }

    @DeleteMapping("/eliminar/{id}")
    public void borrarVeterinario(@PathVariable("id") Long id) {
        veterinarioService.deleteById(id);
    }

    @GetMapping("/modificar/{id}")
    public String mostrarFormularioModificar(@PathVariable("id") Long id, Model model) {
        model.addAttribute("veterinario", veterinarioService.SearchById(id));
        return "modificar_veterinario";
    }

    @PutMapping("/modificar/{id}")
    public void actualizarVeterinario(@RequestBody Veterinario veterinario) {
        veterinarioService.update(veterinario);
    }

    @GetMapping("/tratamientos/{id}")
    public List<Tratamiento> tratamientosVeterinario(@PathVariable("id") Long id){
        return veterinarioService.SearchById(id).getTratamientos();
    }
}
