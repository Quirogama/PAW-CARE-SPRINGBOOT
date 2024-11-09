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
import org.springframework.web.bind.annotation.RestController;

import com.example.pawcare.entidad.Cliente;
import com.example.pawcare.entidad.Mascota;
import com.example.pawcare.entidad.Tratamiento;
import com.example.pawcare.entidad.UserEntity;
import com.example.pawcare.entidad.Veterinario;
import com.example.pawcare.repositorio.UserRepository;
import com.example.pawcare.seguridad.CustomUserDetailService;
import com.example.pawcare.seguridad.JWTGenerator;
import com.example.pawcare.servicio.VeterinarioService;



@RestController
@RequestMapping("/veterinario")
@CrossOrigin(origins = "http://localhost:4200")
public class VeterinarioController {
    
    @Autowired
    VeterinarioService veterinarioService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CustomUserDetailService customUserDetailService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTGenerator JWTGenerator;

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
    public ResponseEntity agregarVeterinario(@RequestBody Veterinario veterinario) {
        if(userRepository.existsByUsername(String.valueOf(veterinario.getCedula()))){
            return new ResponseEntity<Veterinario>(veterinario, HttpStatus.BAD_REQUEST);
        }
        
        UserEntity userEntity = customUserDetailService.VeterinarioToUser(veterinario); 
        veterinario.setUserEntity(userEntity);
        Veterinario newVeterinario = veterinarioService.agregar(veterinario);
        if (newVeterinario == null) {
            return new ResponseEntity<Veterinario>(newVeterinario, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Veterinario>(newVeterinario, HttpStatus.CREATED);
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

    @GetMapping("/mascotas/tratamiento/{id}")
    public List<Mascota> getMascotasEnTratamiento(@PathVariable("id") Long id) {
        List<Tratamiento> tratamientos = veterinarioService.SearchById(id).getTratamientos();

        List<Mascota> mascotas = mascotas = new java.util.ArrayList<>();
        if (tratamientos != null) {
            for (Tratamiento tratamiento : tratamientos) {
                mascotas.add(tratamiento.getMascota());
            }
        }
        return mascotas;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Veterinario veterinario) {
        if(veterinarioService.SearchByCedula(veterinario.getCedula()) == null){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
                Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                veterinario.getCedula(),
                veterinario.getClave()
            )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = JWTGenerator.generateToken(authentication);
 
        return new ResponseEntity<String>(token, HttpStatus.OK);
    }

    @GetMapping("/details")
    public ResponseEntity<Veterinario> buscarVeterinario() {
        Veterinario veterinario = veterinarioService.SearchByCedula(
            Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName())
        );

        if (veterinario == null) {
            return new ResponseEntity<Veterinario>(HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<Veterinario>(veterinario, HttpStatus.OK);
    } 
    
}
