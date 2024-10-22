package com.example.pawcare.servicio;

import java.util.List;

import com.example.pawcare.entidad.Droga;

public interface DrogaService {

    public Droga SearchById(Long id);

    public List<Droga> SearchAll();

    public List<Droga> SearchByMascotaId(Long id);

    public Droga findByName(String name);
    
    public void add(Droga droga);
    
    public void deleteById(Long id);
    
    public void update(Droga droga);

    Integer getTotalVentas();  // Método para obtener el total de ventas (unidades vendidas)
    Float getTotalGanancias();  // Método para obtener el total de ganancias
    
    public List<Droga> cargarDrogasDesdeExcel(); // Método para cargar desde Excel
}
