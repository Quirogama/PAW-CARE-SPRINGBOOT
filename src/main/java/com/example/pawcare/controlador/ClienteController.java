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
import com.example.pawcare.entidad.UserEntity;
import com.example.pawcare.repositorio.UserRepository;
import com.example.pawcare.seguridad.CustomUserDetailService;
import com.example.pawcare.seguridad.JWTGenerator;
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

    @Autowired
    UserRepository userRepository;

    @Autowired
    CustomUserDetailService customUserDetailService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTGenerator JWTGenerator;

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
    
    @PostMapping("/add")
    public ResponseEntity<Cliente> registroCliente(@RequestBody Cliente cliente) {
        /*
        if (clienteService.SearchByCedula(cliente.getCedula()) != null) {
            throw new UserAlreadyExistsException(cliente.getCedula());
        }
        else if(adminService.SearchByCedula(cliente.getCedula()) != null){
            throw new UserAlreadyExistsException(cliente.getCedula());
        }
        clienteService.add(cliente);
         */
        if(userRepository.existsByUsername(String.valueOf(cliente.getCedula()))){
            return new ResponseEntity<Cliente>(cliente, HttpStatus.BAD_REQUEST);
        }
        
        UserEntity userEntity = customUserDetailService.ClienteToUser(cliente); 
        cliente.setUserEntity(userEntity);
        Cliente newCliente = clienteService.agregar(cliente);
        if (newCliente == null) {
            return new ResponseEntity<Cliente>(newCliente, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Cliente>(newCliente, HttpStatus.CREATED);
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

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Cliente cliente) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                cliente.getCedula(),
                cliente.getClave()
            )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = JWTGenerator.generateToken(authentication);
 
        return new ResponseEntity<String>(token, HttpStatus.OK);
    }

    @GetMapping("/details")
    public ResponseEntity<Cliente> buscarCliente() {
        Cliente cliente = clienteService.SearchByCedula(
            Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName())
        );
        System.out.println("BUSCANDO CLIENTE");
        if (cliente == null) {
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }
    
        
}


