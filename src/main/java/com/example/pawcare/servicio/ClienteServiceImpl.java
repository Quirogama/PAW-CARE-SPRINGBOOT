package com.example.pawcare.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pawcare.entidad.Cliente;
import com.example.pawcare.entidad.Mascota;
import com.example.pawcare.repositorio.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Cliente SearchById(Long id) {
        return clienteRepository.findById(id).get();
    }

    @Override
    public List<Cliente> SearchAll() {
        return clienteRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public void add(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void update(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public Cliente SearchByCedula(int cedula) {
        return clienteRepository.findByCedula(cedula);
    }

    @Override
    public void addMascota(Mascota mascota, int cedula) {
        Cliente cliente = clienteRepository.findByCedula(cedula);

        if (cliente != null) {
            mascota.setCliente(cliente); 
            cliente.getMascotas().add(mascota);
            clienteRepository.save(cliente);
        } else {

        }
    }
}
