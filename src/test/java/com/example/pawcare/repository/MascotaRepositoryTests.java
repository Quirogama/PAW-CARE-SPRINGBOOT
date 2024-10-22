package com.example.pawcare.repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.pawcare.entidad.Cliente;
import com.example.pawcare.entidad.Mascota;
import com.example.pawcare.repositorio.ClienteRepository;
import com.example.pawcare.repositorio.DrogaRepository;
import com.example.pawcare.repositorio.MascotaRepository;
import com.example.pawcare.repositorio.TratamientoRepository;
import com.example.pawcare.repositorio.VeterinarioRepository;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class MascotaRepositoryTests {
    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private TratamientoRepository tratamientoRepository;

    @Autowired
    private DrogaRepository drogaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @BeforeEach
    void setUp() {
        clienteRepository.save(new Cliente("Juan Pérez", "juan.perez@example.com", 12345678, 87654321, "clave123"));
        clienteRepository.save(new Cliente("María Gómez", "maria.gomez@example.com", 23456789, 98765432, "clave234"));
        clienteRepository.save(new Cliente("Carlos López", "carlos.lopez@example.com", 34567890, 19876543, "clave345"));
        clienteRepository.save(new Cliente("Ana Martínez", "ana.martinez@example.com", 45678901, 21987654, "clave456"));
        clienteRepository.save(new Cliente("Luis Rodríguez", "luis.rodriguez@example.com", 56789012, 32198765, "clave567"));
        
        mascotaRepository.save(new Mascota("Lucas", "5", "Labrador", "Displasia de cadera", "En tratamiento", 5, "assets/img/lucas.jpg"));
        mascotaRepository.save(new Mascota("Pablo", "1", "Desconocida", "Otitis", "En observación", 3, "assets/img/pablo.jpg"));
        mascotaRepository.save(new Mascota("Jhony", "10", "Criollo", "Artritis", "En tratamiento", 7, "assets/img/jhony.jpg"));
        mascotaRepository.save(new Mascota("Miguel", "200", "Husky", "Alergia alimentaria", "En tratamiento", 4, "assets/img/miguel.jpg"));
        mascotaRepository.save(new Mascota("Zeus", "4", "Pastor Aleman", "Problemas dentales", "Recuperado", 2, "assets/img/Zeus.jpg"));

        List<Mascota> mascotas = mascotaRepository.findAll();
        List<Cliente> clientes = clienteRepository.findAll();

        //Mascota a clientes
        int clienteIndex = 0;
        for (Mascota mascota : mascotas) {
            Cliente cliente = clientes.get(clienteIndex);
            mascota.setCliente(cliente);
            cliente.getMascotas().add(mascota);
            clienteRepository.save(cliente);
            clienteIndex = (clienteIndex + 1) % clientes.size();
        }
    }

    //CRUD MASCOTA
    //CREATE
    @Test
    public void MascotaRepositoryTest_save_Mascota(){
        Mascota mascota = new Mascota("Daisy", "5", "Dachshund", "Problemas dentales", "Recuperado", 4, "assets/img/perroGenerico.png");
    
        Mascota savedMascota = mascotaRepository.save(mascota);

        Assertions.assertThat(savedMascota).isNotNull();
    }

    //READ
    @Test
    public void MascotaRepositoryTest_findById_Mascota(){
        Long index = 1L;

        Optional<Mascota> optionalMascota = mascotaRepository.findById(index);

        Assertions.assertThat(optionalMascota).isNotEmpty();
        Assertions.assertThat(optionalMascota.get().getNombre()).isEqualTo("Lucas");
    }

    //UPDATE
    @Test
    public void MascotaRepositoryTest_update_MascotaActualizada(){
        Mascota mascota = new Mascota("Daisy", "5", "Dachshund", "Problemas dentales", "Recuperado", 4, "assets/img/perroGenerico.png");
    
        Mascota savedMascota = mascotaRepository.save(mascota);
        savedMascota.setEdad(6);
        mascotaRepository.save(savedMascota);

        Assertions.assertThat(savedMascota).isNotNull();
        Assertions.assertThat(savedMascota.getEdad()).isEqualTo(6);
    }

    //DELETE
    @Test
    public void MascotaRepositoryTest_deleteById_MascotaVacia(){

        Long index = 1L;

        mascotaRepository.deleteById(index);

        Assertions.assertThat(mascotaRepository.findById(index)).isEmpty();
    }

    //Pruebas consultas propias
    //Buscar todas las mascotas
    @Test
    public void MascotaRepositoryTest_findAll_NotEmptyList(){
        Mascota mascota = new Mascota("Daisy", "5", "Dachshund", "Problemas dentales", "Recuperado", 4, "assets/img/perroGenerico.png");
        Mascota mascota2 = new Mascota("Daisy2", "5", "Dachshund", "Problemas dentales", "Recuperado", 4, "assets/img/perroGenerico.png");

        mascotaRepository.save(mascota);
        mascotaRepository.save(mascota2);
        List<Mascota> mascotas = mascotaRepository.findAll();

        Assertions.assertThat(mascotas).size().isEqualTo(7);
        Assertions.assertThat(mascotas).size().isGreaterThan(0);
    }

    //Buscar por ID de cliente
    @Test
    public void MascotaRepositoryTest_findByClienteId_Mascota(){
        Long id = 1L;
        List<Mascota> mascotas = mascotaRepository.findByClienteId(id);

        Assertions.assertThat(mascotas).size().isNotNull();
        Assertions.assertThat(mascotas).size().isEqualTo(1);
    }

    //Contar las mascotas en tratamiento
    @Test
    public void MascotaRepositoryTest_countMascotasActivas_NotNull(){
        Long count = mascotaRepository.countMascotasActivas();

        Assertions.assertThat(count).isNotNull();
        Assertions.assertThat(count).isEqualTo(3);
    }

    //Contar las mascotas en observacion 
    @Test
    public void MascotaRepositoryTest_countMascotasEnObservacion_NotNull(){
        Long count = mascotaRepository.countMascotasEnObservacion();

        Assertions.assertThat(count).isNotNull();
        Assertions.assertThat(count).isEqualTo(1);
    }

    //Contar las mascotas recuperadas
    @Test
    public void MascotaRepositoryTest_countMascotasRecuperadas_NotNull(){
        Long count = mascotaRepository.countMascotasRecuperadas();

        Assertions.assertThat(count).isNotNull();
        Assertions.assertThat(count).isEqualTo(1);
    }
}
