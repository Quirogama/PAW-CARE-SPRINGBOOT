package com.example.pawcare.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pawcare.entidad.Administrador;
import com.example.pawcare.entidad.Cliente;
import com.example.pawcare.entidad.Mascota;
import com.example.pawcare.errorHandling.NotFoundException;
import com.example.pawcare.errorHandling.UserAlreadyExistsException;
import com.example.pawcare.seguridad.JWTGenerator;
import com.example.pawcare.servicio.AdministradorService;
import com.example.pawcare.servicio.ClienteService;
import com.example.pawcare.servicio.MascotaService;
import com.fasterxml.jackson.annotation.JsonIgnore;


@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")

public class AdminController {

    @Autowired
    AdministradorService AdminService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    MascotaService mascotaService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTGenerator JWTGenerator;

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        Cliente cliente = new Cliente("","",1,1,"");
        model.addAttribute("cliente", cliente);
        return "registroAdmin";
    }

    @PostMapping("/registrar")
    public String registroCliente(@ModelAttribute("cliente") Cliente cliente) {
        
        if (clienteService.SearchByCedula(cliente.getCedula()) != null || AdminService.SearchByCedula(cliente.getCedula()) != null) {
            throw new UserAlreadyExistsException(cliente.getCedula());
        }
        clienteService.add(cliente);
        return "redirect:/admin/clientes";
    }

    @GetMapping("/registroMascota")
    public String mostrarFormularioRegistroMascota(Model model) {
        Mascota mascota = new Mascota("","","","","",1,"");
        model.addAttribute("mascota", mascota);
        return "registro_mascotas";
    }

    @PostMapping("/registrarMascota")
    public String registroMascota(@ModelAttribute("mascota") Mascota mascota,
                        @RequestParam("cedula") int cedula) {
    Cliente cliente = clienteService.SearchByCedula(cedula);
    if (cliente != null) {
        mascota.setCliente(cliente);
        mascotaService.add(mascota);
        return "redirect:/admin/mascotas";
    } else {
        // Manejo de error si el cliente no existe
        throw new NotFoundException (cedula);
    }
    
    }

    @JsonIgnore
    @GetMapping("/clientes")
    public List<Cliente> allClientes(Model model) {
        //model.addAttribute("clientes", clienteService.SearchAll());
        //return "usuarios";

        return clienteService.SearchAll();
    }

    @JsonIgnore
    @GetMapping("/mascotas")
    public List<Mascota> mostrarMascotas(Model model) {
        //model.addAttribute("mascotas", mascotaService.SearchAll());
        //return "listado_mascotas";
        return mascotaService.SearchAll();
    }

    @GetMapping("/{cedula}")
    public Administrador mostrarinfoAdministradorCedula(@PathVariable("cedula") int cedula) {
        Administrador admin = AdminService.SearchByCedula(cedula);
        return admin;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Administrador admin) {
                Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                admin.getCedula(),
                admin.getClave()
            )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = JWTGenerator.generateToken(authentication);
 
        return new ResponseEntity<String>(token, HttpStatus.OK);
    }
}