
package com.example.pawcare.entidad;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import com.example.pawcare.repositorio.AdministradorRepository;
import com.example.pawcare.repositorio.ClienteRepository;
import com.example.pawcare.repositorio.DrogaRepository;
import com.example.pawcare.repositorio.MascotaRepository;
import com.example.pawcare.repositorio.RoleRepository;
import com.example.pawcare.repositorio.TratamientoRepository;
import com.example.pawcare.repositorio.UserRepository;
import com.example.pawcare.repositorio.VeterinarioRepository;
import com.example.pawcare.servicio.ExcelService;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class DatabaseInit implements ApplicationRunner {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    MascotaRepository mascotaRepository;

    @Autowired
    AdministradorRepository administradorRepository;

    @Autowired
    VeterinarioRepository veterinarioRepository;

    @Autowired
    DrogaRepository drogaRepository;

    @Autowired
    TratamientoRepository tratamientoRepository;

    @Autowired
    ExcelService excelService;

    //Seguridad
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        
        //Roles
        roleRepository.save(new Role("ADMIN"));
        roleRepository.save(new Role("VETERINARIO"));
        roleRepository.save(new Role("CLIENTE"));

        Cliente clienteSave;
        UserEntity userEntity;        

        //Admin
        Administrador adminSave = new Administrador(777, "clave777");
        userEntity = saveUserAdministrador(adminSave);
        adminSave.setUserEntity(userEntity);
        administradorRepository.save(adminSave);

        //Clientes
        clienteSave = new Cliente("Juan Pérez", "juan.perez@example.com", 12345678, 87654321, "clave123");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("María Gómez", "maria.gomez@example.com", 23456789, 98765432, "clave234");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Carlos López", "carlos.lopez@example.com", 34567890, 19876543, "clave345");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Ana Martínez", "ana.martinez@example.com", 45678901, 21987654, "clave456");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Luis Rodríguez", "luis.rodriguez@example.com", 56789012, 32198765, "clave567");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Laura Fernández", "laura.fernandez@example.com", 67890123, 43219876, "clave678");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Pedro Ramírez", "pedro.ramirez@example.com", 78901234, 54321987, "clave789");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Lucía Sánchez", "lucia.sanchez@example.com", 89012345, 65432198, "clave890");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Miguel Torres", "miguel.torres@example.com", 90123456, 76543219, "clave901");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Andrea Morales", "andrea.morales@example.com", 12345679, 87654320, "clave123");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Santiago Ortiz", "santiago.ortiz@example.com", 23456780, 98765421, "clave234");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Isabella Herrera", "isabella.herrera@example.com", 34567891, 19876542, "clave345");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Daniel Vargas", "daniel.vargas@example.com", 45678902, 21987653, "clave456");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Valentina Ríos", "valentina.rios@example.com", 56789013, 32198764, "clave567");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Sebastián Castro", "sebastian.castro@example.com", 67890124, 43219875, "clave678");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Camila Mendoza", "camila.mendoza@example.com", 78901235, 54321986, "clave789");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Mateo Jiménez", "mateo.jimenez@example.com", 89012346, 65432197, "clave890");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Sofía Romero", "sofia.romero@example.com", 90123457, 76543210, "clave901");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Nicolás Vargas", "nicolas.vargas@example.com", 12345680, 87654322, "clave123");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Gabriela Pineda", "gabriela.pineda@example.com", 23456781, 98765433, "clave234");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Diego Suárez", "diego.suarez@example.com", 34567892, 19876544, "clave345");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Valeria Rivera", "valeria.rivera@example.com", 45678903, 21987655, "clave456");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Martín Gutiérrez", "martin.gutierrez@example.com", 56789014, 32198766, "clave567");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Mariana Castillo", "mariana.castillo@example.com", 67890125, 43219877, "clave678");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Lucas Silva", "lucas.silva@example.com", 78901236, 54321988, "clave789");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Antonella Vargas", "antonella.vargas@example.com", 89012347, 65432199, "clave890");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Tomás Díaz", "tomas.diaz@example.com", 90123458, 76543211, "clave901");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Julieta Reyes", "julieta.reyes@example.com", 12345681, 87654323, "clave123");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("David Moreno", "david.moreno@example.com", 23456782, 98765434, "clave234");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Paula Soto", "paula.soto@example.com", 34567893, 19876545, "clave345");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Joaquín Rojas", "joaquin.rojas@example.com", 45678904, 21987656, "clave456");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Catalina Álvarez", "catalina.alvarez@example.com", 56789015, 32198767, "clave567");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Emiliano Ruiz", "emiliano.ruiz@example.com", 67890126, 43219878, "clave678");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Valentina Ramírez", "valentina.ramirez@example.com", 78901237, 54321989, "clave789");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Pablo Acosta", "pablo.acosta@example.com", 89012348, 65432100, "clave890");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Emilia Luna", "emilia.luna@example.com", 90123459, 76543212, "clave901");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Agustín Pérez", "agustin.perez@example.com", 12345682, 87654324, "clave123");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Mía Gómez", "mia.gomez@example.com", 23456783, 98765435, "clave234");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Alejandro Torres", "alejandro.torres@example.com", 34567894, 19876546, "clave345");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Victoria Ortiz", "victoria.ortiz@example.com", 45678905, 21987657, "clave456");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Iván Gutiérrez", "ivan.gutierrez@example.com", 56789016, 32198768, "clave567");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Renata Vargas", "renata.vargas@example.com", 67890127, 43219879, "clave678");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Bruno Morales", "bruno.morales@example.com", 78901238, 54321990, "clave789");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Natalia Rivera", "natalia.rivera@example.com", 89012349, 65432101, "clave890");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Facundo Herrera", "facundo.herrera@example.com", 90123460, 76543213, "clave901");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Amanda Sánchez", "amanda.sanchez@example.com", 12345683, 87654325, "clave123");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Benjamín Ramírez", "benjamin.ramirez@example.com", 23456784, 98765436, "clave234");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Florencia Pineda", "florencia.pineda@example.com", 34567895, 19876547, "clave345");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Luciano Jiménez", "luciano.jimenez@example.com", 45678906, 21987658, "clave456");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente("Martina Castillo", "martina.castillo@example.com", 56789017, 32198769, "clave567");
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUserEntity(userEntity);
        clienteRepository.save(clienteSave);
        

        
        
        //Mascotas
        mascotaRepository.save(new Mascota("Lucas", "5", "Labrador", "Displasia de cadera", "En tratamiento", 5, "assets/img/lucas.jpg"));
        mascotaRepository.save(new Mascota("Pablo", "1", "Desconocida", "Otitis", "En observación", 3, "assets/img/pablo.jpg"));
        mascotaRepository.save(new Mascota("Jhony", "10", "Criollo", "Artritis", "En observación", 7, "assets/img/jhony.jpg"));
        mascotaRepository.save(new Mascota("Miguel", "200", "Husky", "Alergia alimentaria", "En tratamiento", 4, "assets/img/miguel.jpg"));
        mascotaRepository.save(new Mascota("Zeus", "4", "Pastor Aleman", "Problemas dentales", "Recuperado", 2, "assets/img/Zeus.jpg"));
        mascotaRepository.save(new Mascota("Coco", "4", "Pastor Aleman", "Problemas dentales", "Recuperado", 2, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Max", "5", "Labrador", "Corte de orejas", "Recuperado", 3, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Bella", "6", "Beagle", "Raspaduras", "En observación", 1, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Charlie", "7", "Bulldog", "Ojos irritados", "En observación", 4, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Daisy", "4", "Poodle", "Infección en la piel", "Recuperado", 2, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Lucy", "3", "Chihuahua", "Problemas respiratorios", "En observación", 5, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Molly", "8", "Boxer", "Cojera", "Recuperado", 3, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Rocky", "9", "Rottweiler", "Diarrea", "En observación", 6, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Sadie", "5", "Dachshund", "Corte en la pata", "En observación", 2, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Buddy", "4", "Cocker Spaniel", "Fiebre", "Recuperado", 4, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Maggie", "6", "Schnauzer", "Tos persistente", "En observación", 1, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Sakura", "5", "Pug", "Problemas de digestión", "En observación", 6, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Jake", "3", "Shih Tzu", "Alergias", "Recuperado", 2, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Lola", "5", "Pomerania", "Raspaduras en la piel", "En observación", 3, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Bentley", "8", "Husky", "Dolores de estómago", "En observación", 4, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Duke", "9", "Akita", "Infección ocular", "Recuperado", 6, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Oliver", "4", "Bichon Frise", "Herida en la pata", "En observación", 1, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Chloe", "6", "Yorkshire Terrier", "Problemas de oído", "En observación", 5, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Bear", "7", "Bernese Mountain Dog", "Infección urinaria", "Recuperado", 3, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Riley", "5", "Samoyedo", "Dolores musculares", "En observación", 2, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Sophie", "8", "Golden Retriever", "Alergias alimentarias", "En observación", 4, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Jack", "3", "Cavalier King Charles", "Problemas dentales", "Recuperado", 5, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Luna", "5", "Maltés", "Lesión en la cola", "En observación", 3, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Zoey", "6", "Pug", "Infección en las encías", "En tratamiento", 2, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Mia", "7", "Dálmata", "Cortes menores", "Recuperado", 4, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Loki", "8", "Weimaraner", "Problemas de piel", "En observación", 1, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Gracie", "4", "Basset Hound", "Infección respiratoria", "En tratamiento", 5, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Rusty", "5", "Labrador", "Problemas articulares", "Recuperado", 3, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Harley", "6", "Terrier", "Problemas digestivos", "En observación", 2, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Misty", "7", "Beagle", "Herida en la pata", "En observación", 4, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Oscar", "4", "Schnauzer", "Corte en la oreja", "Recuperado", 5, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Jasper", "8", "Boxer", "Fiebre alta", "En observación", 1, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Penny", "5", "Pomerania", "Problemas oculares", "En tratamiento", 3, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Bailey", "6", "Cocker Spaniel", "Alergia estacional", "Recuperado", 2, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Maya", "7", "Poodle", "Dolores en el estómago", "En observación", 4, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Winston", "4", "Husky", "Problemas dentales", "En tratamiento", 5, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Roxy", "5", "Akita", "Corte en la pata", "Recuperado", 3, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Lola", "8", "Mastín", "Fiebre leve", "En observación", 1, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Maggie", "6", "Shih Tzu", "Infección en el oído", "En observación", 2, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Daisy", "7", "Dachshund", "Problemas en la piel", "Recuperado", 4, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Ellie", "4", "Yorkshire Terrier", "Corte en la cola", "En observación", 5, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Sasha", "5", "Labrador", "Herida en el ojo", "En observación", 3, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Rocky", "6", "Beagle", "Problemas respiratorios", "Recuperado", 2, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Nala", "7", "Boxer", "Raspaduras menores", "En observación", 4, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Milo", "5", "Schnauzer", "Infección en la piel", "En observación", 1, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Zeke", "8", "Pug", "Dolores en las patas", "Recuperado", 3, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Stella", "6", "Pomerania", "Corte en la oreja", "En observación", 5, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Luca", "7", "Chihuahua", "Problemas de visión", "En tratamiento", 2, "assets/img/perroGenerico.png"));        
        mascotaRepository.save(new Mascota("Luca", "7", "Chihuahua", "Problemas de visión", "En tratamiento", 2, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Riley", "4", "Shih Tzu", "Herida en la pata", "Recuperado", 1, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Jax", "6", "Rottweiler", "Infección en el oído", "En observación", 3, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Mia", "7", "Maltés", "Corte en la cola", "En tratamiento", 2, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Leo", "5", "Labrador", "Problemas articulares", "Recuperado", 4, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Luna", "8", "Beagle", "Fiebre leve", "En observación", 1, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Sasha", "4", "Cocker Spaniel", "Infección respiratoria", "En observación", 3, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Buddy", "6", "Poodle", "Dolores musculares", "Recuperado", 5, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Roxy", "7", "Akita", "Problemas dentales", "En observación", 2, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Maggie", "5", "Dachshund", "Corte en la pata", "En observación", 4, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Oliver", "6", "Schnauzer", "Alergias estacionales", "Recuperado", 3, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Chloe", "8", "Pomerania", "Problemas oculares", "En observación", 2, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Rocky", "5", "Pug", "Dolores de estómago", "En observación", 1, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Bailey", "7", "Labrador", "Herida en el ojo", "Recuperado", 4, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Zara", "4", "Beagle", "Corte en la pata", "En observación", 2, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Toby", "5", "Bulldog", "Problemas dentales", "En tratamiento", 3, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Nina", "6", "Boxer", "Fiebre alta", "Recuperado", 1, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Dexter", "7", "Pomerania", "Raspaduras menores", "En observación", 4, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Winnie", "8", "Rottweiler", "Infección urinaria", "En observación", 2, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Milo", "4", "Chihuahua", "Problemas digestivos", "Recuperado", 3, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Rosie", "6", "Cocker Spaniel", "Herida en la cola", "En observación", 5, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Jasper", "7", "Schnauzer", "Corte en la oreja", "En observación", 4, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Lola", "5", "Shih Tzu", "Infección en la piel", "Recuperado", 2, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Riley", "8", "Pug", "Problemas oculares", "En observación", 3, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Benny", "4", "Labrador", "Corte en la pata", "En observación", 1, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Maggie", "6", "Dachshund", "Fiebre baja", "Recuperado", 5, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Daisy", "7", "Beagle", "Infección respiratoria", "En observación", 2, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Bella", "5", "Boxer", "Herida en la pata", "En observación", 3, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Luna", "8", "Poodle", "Problemas articulares", "Recuperado", 4, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Jack", "4", "Cocker Spaniel", "Dolores de estómago", "En observación", 1, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Zoey", "6", "Schnauzer", "Infección en el ojo", "En observación", 2, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Milo", "7", "Pomerania", "Problemas dentales", "Recuperado", 3, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Ruby", "5", "Labrador", "Fiebre leve", "En observación", 4, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Max", "8", "Bulldog", "Corte en la pata", "En observación", 1, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Sadie", "4", "Chihuahua", "Problemas de piel", "Recuperado", 2, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Oliver", "6", "Beagle", "Infección en las encías", "En observación", 3, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Riley", "7", "Rottweiler", "Dolores musculares", "En observación", 4, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Maggie", "5", "Pug", "Corte en la cola", "Recuperado", 1, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Chloe", "8", "Akita", "Problemas digestivos", "En observación", 2, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Bailey", "4", "Dachshund", "Herida en el ojo", "En observación", 5, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Sophie", "6", "Boxer", "Infección respiratoria", "Recuperado", 3, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Bella", "7", "Poodle", "Problemas articulares", "En observación", 2, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Toby", "5", "Shih Tzu", "Dolores en el estómago", "En observación", 4, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Rocky", "6", "Labrador", "Herida en la pata", "Recuperado", 1, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Roxy", "8", "Cocker Spaniel", "Fiebre baja", "En observación", 3, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Nina", "4", "Pug", "Infección en el ojo", "En observación", 2, "assets/img/perroGenerico.png"));
        mascotaRepository.save(new Mascota("Daisy", "5", "Dachshund", "Problemas dentales", "Recuperado", 4, "assets/img/perroGenerico.png"));
        
        //Veterinarios
        Veterinario veterinarioSave;
        veterinarioSave = Veterinario.builder().nombre("Dr. House").cedula(9991234).especialidad("Tratamientos Oculares").imagen("assets/img/veterinarioGenerico.png").numAtenciones(18).clave("clave123").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().nombre("Dra. Lisa Cuddy").cedula(9994567).especialidad("Medicina Interna").imagen("assets/img/veterinarioGenerico.png").numAtenciones(5).clave("clave567").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().nombre("Dr. James Wilson").cedula(9998903).especialidad("Oncología").imagen("assets/img/veterinarioGenerico.png").numAtenciones(4).clave("clave901").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().nombre("Dr. Robert Chase").cedula(9993456).especialidad("Cirugía").imagen("assets/img/veterinarioGenerico.png").numAtenciones(7).clave("clave456").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().nombre("Dra. Allison Cameron").cedula(9997890).especialidad("Diagnóstico General").imagen("assets/img/veterinarioGenerico.png").numAtenciones(6).clave("clave890").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().nombre("Dr. Eric Foreman").cedula(9992345).especialidad("Neurología").imagen("assets/img/veterinarioGenerico.png").numAtenciones(8).clave("clave345").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().nombre("Dr. Chris Taub").cedula(9996789).especialidad("Cardiología").imagen("assets/img/veterinarioGenerico.png").numAtenciones(5).clave("clave789").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().nombre("Dra. Remy Hadley").cedula(9990123).especialidad("Genética").imagen("assets/img/veterinarioGenerico.png").numAtenciones(3).clave("clave123").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().nombre("Dr. Lawrence Kutner").cedula(9994547).especialidad("Psiquiatría").imagen("assets/img/veterinarioGenerico.png").numAtenciones(4).clave("clave567").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().nombre("Dr. Jeffrey Cole").cedula(9998901).especialidad("Medicina General").imagen("assets/img/veterinarioGenerico.png").numAtenciones(2).clave("clave901").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().nombre("Dr. Henry Dobson").cedula(9992346).especialidad("Dermatología").imagen("assets/img/veterinarioGenerico.png").numAtenciones(6).clave("clave346").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().nombre("Dra. Amber Volakis").cedula(9995679).especialidad("Anestesiología").imagen("assets/img/veterinarioGenerico.png").numAtenciones(3).clave("clave679").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().nombre("Dra. Jessica Adams").cedula(9998912).especialidad("Medicina de Urgencias").imagen("assets/img/veterinarioGenerico.png").numAtenciones(4).clave("clave912").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().nombre("Dra. Chi Park").cedula(9993457).especialidad("Neurocirugía").imagen("assets/img/veterinarioGenerico.png").numAtenciones(14).clave("clave457").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().nombre("Dr. Gregory House").cedula(9997891).especialidad("Nefrología").imagen("assets/img/veterinarioGenerico.png").numAtenciones(11).clave("clave891").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().nombre("Dr. John Carter").cedula(9992348).especialidad("Infectología").imagen("assets/img/veterinarioGenerico.png").numAtenciones(7).clave("clave348").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().nombre("Dr. Peter Benton").cedula(9995670).especialidad("Gastroenterología").imagen("assets/img/veterinarioGenerico.png").numAtenciones(8).clave("clave670").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().nombre("Dra. Susan Lewis").cedula(9998913).especialidad("Reumatología").imagen("assets/img/veterinarioGenerico.png").numAtenciones(3).clave("clave913").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().nombre("Dr. Mark Greene").cedula(9993458).especialidad("Pediatría").imagen("assets/img/veterinarioGenerico.png").numAtenciones(6).clave("clave458").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().nombre("Dr. James Johnson").cedula(9997892).especialidad("Cirugía Plástica").imagen("assets/img/veterinarioGenerico.png").numAtenciones(7).clave("clave892").build();
        userEntity = saveUserVeterinario(veterinarioSave);
        veterinarioSave.setUserEntity(userEntity);
        veterinarioRepository.save(veterinarioSave);
    
        //Tratamientos
        tratamientoRepository.save(new Tratamiento(LocalDate.parse("2024-10-01"), "Desparasitación interna y externa"));
        tratamientoRepository.save(new Tratamiento(LocalDate.parse("2024-10-22"), "Vacunación contra la rabia"));
        tratamientoRepository.save(new Tratamiento(LocalDate.parse("2024-10-03"), "Limpieza dental y pulido"));
        tratamientoRepository.save(new Tratamiento(LocalDate.parse("2024-10-04"), "Aplicación de antipulgas y garrapatas"));
        tratamientoRepository.save(new Tratamiento(LocalDate.parse("2024-10-05"), "Tratamiento para infecciones oculares"));   
        tratamientoRepository.save(new Tratamiento(LocalDate.parse("2024-10-06"), "Tratamiento para huesos rotos"));
        tratamientoRepository.save(new Tratamiento(LocalDate.parse("2024-10-07"), "Tratamiento para infecciones"));
        tratamientoRepository.save(new Tratamiento(LocalDate.parse("2024-10-08"), "Tratamiento para afectaciones generales"));
        tratamientoRepository.save(new Tratamiento(LocalDate.parse("2024-10-09"), "Tratamiento para cortes"));
        tratamientoRepository.save(new Tratamiento(LocalDate.parse("2024-10-10"), "Tratamiento para enfermedades terminales"));

        //Drogas
        //excelService.uploadCsv("resources/excel/MEDICAMENTOS_VETERINARIA.xlsx");
        excelService.guardarEnRepositorio();

        //Asociar veterinario con tratamiento
        
        int CANTIDAD_VETERINARIOS = 20;
        int CANTIDAD_VETERINARIOS_ASIGNAR = 1;
        for (Tratamiento tratamiento : tratamientoRepository.findAll()) {
            for (int i = 0; i < CANTIDAD_VETERINARIOS_ASIGNAR; i++) {
                int random = ThreadLocalRandom.current().nextInt(1, CANTIDAD_VETERINARIOS+1);
                System.out.println("NUMERO RANDOM: " + random + "DE: " + tratamiento.getId());
                Long search = Long.valueOf(random);
                System.out.println("SEARCH: " + search);
                Veterinario veterinario = veterinarioRepository.findById(search).get();
                tratamiento.setVeterinario(veterinario);
                tratamientoRepository.save(tratamiento);
            }
        }
        
       int CANTIDAD_TRATAMIENTOS = 10;
       int CANTIDAD_DROGAS_ASIGNAR = 10;


        //Asociar droga con Tratamiento
        
          
        // Asignar las 10 primeras drogas a los 10 primeros tratamientos
        List<Droga> primerasDiezDrogas = drogaRepository.findAll();
        List<Tratamiento> primerosDiezTratamientos = tratamientoRepository.findAll();

        primerosDiezTratamientos.get(1).setDroga(primerasDiezDrogas.get(1));
        tratamientoRepository.save(primerosDiezTratamientos.get(1));

        primerosDiezTratamientos.get(2).setDroga(primerasDiezDrogas.get(2));
        tratamientoRepository.save(primerosDiezTratamientos.get(2));

        primerosDiezTratamientos.get(3).setDroga(primerasDiezDrogas.get(3));
        tratamientoRepository.save(primerosDiezTratamientos.get(3));

        primerosDiezTratamientos.get(4).setDroga(primerasDiezDrogas.get(4));
        tratamientoRepository.save(primerosDiezTratamientos.get(4));

        primerosDiezTratamientos.get(5).setDroga(primerasDiezDrogas.get(5));
        tratamientoRepository.save(primerosDiezTratamientos.get(5));

        primerosDiezTratamientos.get(6).setDroga(primerasDiezDrogas.get(6));
        tratamientoRepository.save(primerosDiezTratamientos.get(6));

        primerosDiezTratamientos.get(7).setDroga(primerasDiezDrogas.get(7));
        tratamientoRepository.save(primerosDiezTratamientos.get(7));

        primerosDiezTratamientos.get(8).setDroga(primerasDiezDrogas.get(8));
        tratamientoRepository.save(primerosDiezTratamientos.get(8));

        primerosDiezTratamientos.get(9).setDroga(primerasDiezDrogas.get(9));
        tratamientoRepository.save(primerosDiezTratamientos.get(9));

        primerosDiezTratamientos.get(0).setDroga(primerasDiezDrogas.get(0));
        tratamientoRepository.save(primerosDiezTratamientos.get(0));

        //Asociar tratamiento con Mascota
        List<Mascota> mascotasEnTratamiento = mascotaRepository.findAll().stream()
                .filter(mascota -> mascota.getEstado().equals("En tratamiento"))
                .limit(10)
                .collect(Collectors.toList());
        
        List<Tratamiento> Tratamientos = tratamientoRepository.findAll().subList(0, 10);
        
        for (int i = 0; i < 10; i++) {
            Mascota mascota = mascotasEnTratamiento.get(i);
            Tratamiento tratamiento = Tratamientos.get(i);
            mascota.setTratamiento(tratamiento);
            tratamiento.setMascota(mascota);
            tratamientoRepository.save(tratamiento);
            mascotaRepository.save(mascota);
        }


        List<Veterinario> primerosDiezVeterinarios = veterinarioRepository.findAll().subList(0, 10);
        List<Tratamiento> todosLosTratamientos = tratamientoRepository.findAll();
        for (int i = 0; i < 10; i++) {
            Veterinario veterinario = primerosDiezVeterinarios.get(i);
            Tratamiento tratamiento = todosLosTratamientos.get(i);
            tratamiento.setVeterinario(veterinario);
            tratamientoRepository.save(tratamiento);
        }

        int CANTIDAD_CLIENTES = 50;
        int CANTIDAD_CLIENTES_ASIGNAR = 2;

        for(Mascota mascota : mascotaRepository.findAll()) {
            System.out.println("ID MASCOTA REVISADA: " + mascota.getId());
            for (int i = 0; i < CANTIDAD_CLIENTES_ASIGNAR; i++) {
                int random = ThreadLocalRandom.current().nextInt(1, CANTIDAD_CLIENTES+1);
                System.out.println("NUMERO RANDOM: " + random + "DE: " + mascota.getId());
                Long search = Long.valueOf(random);
                System.out.println("SEARCH: " + search);
                Cliente cliente = clienteRepository.findById(search).get();
                mascota.setCliente(cliente);
                mascotaRepository.save(mascota);
            }
        }


        
    }
    private UserEntity saveUserCliente(Cliente cliente) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(String.valueOf(cliente.getCedula()));
        userEntity.setPassword(passwordEncoder.encode(cliente.getClave())); 
        Role roles = roleRepository.findByName("CLIENTE").get();
        userEntity.setRoles(List.of(roles));
        return userRepository.save(userEntity);
    }

    private UserEntity saveUserVeterinario(Veterinario veterinario) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(String.valueOf(veterinario.getCedula()));
        userEntity.setPassword(passwordEncoder.encode(veterinario.getClave())); 
        Role roles = roleRepository.findByName("VETERINARIO").get();
        userEntity.setRoles(List.of(roles));
        return userRepository.save(userEntity);
    }

    private UserEntity saveUserAdministrador(Administrador administrador) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(String.valueOf(administrador.getCedula()));
        userEntity.setPassword(passwordEncoder.encode(administrador.getClave())); 
        Role roles = roleRepository.findByName("ADMIN").get();
        userEntity.setRoles(List.of(roles));
        return userRepository.save(userEntity);
    }
}
