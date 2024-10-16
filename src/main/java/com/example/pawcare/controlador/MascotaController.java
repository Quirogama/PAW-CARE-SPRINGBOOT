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

import com.example.pawcare.entidad.Mascota;
import com.example.pawcare.servicio.MascotaService;



@RestController
@RequestMapping("/mascota")
@CrossOrigin(origins = "http://localhost:4200")
public class MascotaController {
    
    @Autowired
    MascotaService mascotaService;
    
    @GetMapping("/all")
    public List<Mascota> mostrarMascotas() {
        //model.addAttribute("mascotas", mascotaService.SearchAll());
        //return "listado_mascotas";
        return mascotaService.SearchAll();
    }

    @GetMapping("/{id}")
    public Mascota mostrarMascotaId(@PathVariable("id") Long id) {
        //model.addAttribute("cliente", clienteService.SearchById(id));
        //return "";
        Mascota mascota = mascotaService.SearchById(id);
        return mascota;
    }

    // http://localhost:8080/mascota/cliente/1
    @GetMapping("/cliente/{id}")
    public List<Mascota> mostrarinfoMascota(@PathVariable("id") Long id) {
        //comentado ya que en sprint 8 el profe no usa el if else//
        /*if (mascota != null) {
            Cliente cliente = clienteService.SearchByCedula(mascota.getCliente().getCedula());

            model.addAttribute("mascota", mascota);
            model.addAttribute("cliente", cliente);
        } else {
            // Maneja el caso en que la mascota no sea encontrada, si es necesario
            model.addAttribute("error", "Mascota no encontrada");
        }*/
        return mascotaService.SearchByClienteId(id);
    }


    @GetMapping("/adminfind/{id}")
    public String mostrarinfoMascotaAdmin(Model model, @PathVariable("id") Long id) {
        model.addAttribute("mascota", mascotaService.SearchById(id));
        return "mostrar_mascota_admin";
    }

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        Mascota mascota = new Mascota("","","","","",1,"");
        model.addAttribute("mascota", mascota);
        return "registro_mascotas";
    }

    @PostMapping("/registro")
    public void agregarMascota(@RequestBody Mascota mascota) {
        mascotaService.add(mascota);
    }
    
    
    @DeleteMapping("/eliminar/{id}")
    public void borrarMascota(@PathVariable("id") Long id) {
        mascotaService.deleteById(id);
    }


    @GetMapping("/modificar/{id}")
    public String mostrarFormularioModificar(@PathVariable("id") Long id, Model model) {
        model.addAttribute("mascota", mascotaService.SearchById(id));
        return "modificar_mascota";
    }

    @PutMapping("/modificar/{id}")
    public void actualizarMascota(@PathVariable Long id, @RequestBody Mascota mascota) {
    Mascota mascotaExistente = mascotaService.SearchById(id);
    if (mascotaExistente.getCliente() != null) {
        mascota.setCliente(mascotaExistente.getCliente());
    }
    mascotaService.update(mascota);
}


}