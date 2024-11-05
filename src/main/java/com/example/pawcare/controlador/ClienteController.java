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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pawcare.entidad.Cliente;
import com.example.pawcare.entidad.Mascota;
import com.example.pawcare.errorHandling.UserAlreadyExistsException;
import com.example.pawcare.servicio.AdministradorService;
import com.example.pawcare.servicio.ClienteService;



@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    AdministradorService adminService;

    @GetMapping("/all")
        public List<Cliente> allClientes(Model model) {
            //model.addAttribute("clientes", clienteService.SearchAll());
            //return "usuarios";}
            return clienteService.SearchAll();
        }
        
    @GetMapping("/{id}")
    public Cliente mostrarinfoCliente(@PathVariable("id") Long id) {
        //model.addAttribute("cliente", clienteService.SearchById(id));
        //return "";
        Cliente cliente = clienteService.SearchById(id);
        return cliente;
    }

    @GetMapping("/cedula/{cedula}")
    public Cliente mostrarinfoClienteCedula(@PathVariable("cedula") int cedula) {
        Cliente cliente = clienteService.SearchByCedula(cedula);
        return cliente;
    }

    @GetMapping("/add")
    public String mostrarFormularioRegistro(Model model) {
        Cliente cliente = new Cliente("","",1,1,"");
        model.addAttribute("cliente", cliente);
        return "registro";
    }

    @PostMapping("/add")
    public void registroCliente(@RequestBody Cliente cliente) {
        
        if (clienteService.SearchByCedula(cliente.getCedula()) != null) {
            throw new UserAlreadyExistsException(cliente.getCedula());
        }
        else if(adminService.SearchByCedula(cliente.getCedula()) != null){
            throw new UserAlreadyExistsException(cliente.getCedula());
        }
        clienteService.add(cliente);
    }

    @PostMapping("/mascota/add/{cedula}")
    public void addMascota(@RequestBody Mascota mascota, @PathVariable("cedula") int cedula) {
        // Llamar al servicio para agregar la mascota al cliente con la cédula proporcionada
        clienteService.addMascota(mascota, cedula);
    }    

    @GetMapping("/modificar/{id}")
    public String mostrarFormularioModificar(@PathVariable("id") Long id, Model model) {
        model.addAttribute("cliente", clienteService.SearchById(id));
        return "modificar";
    }

    @PutMapping("/modificar/{id}")
    public void actualizarCliente(@RequestBody Cliente cliente) {
        clienteService.update(cliente);
        //return "redirect:/admin/clientes";
    }

    @DeleteMapping("/eliminar/{id}")
    public void borrarCliente(@PathVariable("id") Long id) {
        clienteService.deleteById(id);
        //return "redirect:/admin/clientes";
    }

    @GetMapping("/login")
public String login(@RequestParam("cedula") int cedula, Model model) {
    Cliente cliente = clienteService.SearchByCedula(cedula);
    if (cliente != null) {
        model.addAttribute("cliente", cliente);
        return "clientePerfil";
    }
    else {
        return "";
    }
    }
}

