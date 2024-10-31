package com.example.pawcare.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pawcare.entidad.Droga;
import com.example.pawcare.repositorio.DrogaRepository;

@Service
public class DrogaServiceImpl implements DrogaService {

    @Autowired
    DrogaRepository drogaRepository;

    @Autowired
    private ExcelService excelService; // Asegúrate de inyectar ExcelService

    @Override
    public Droga SearchById(Long id) {
        return drogaRepository.findById(id).orElse(null); // Mejor manejo de errores
    }

    @Override
    public List<Droga> SearchAll() {
        return drogaRepository.findAll();
    }

    @Override
    public void add(Droga droga) {
        drogaRepository.save(droga);
    }

    @Override
    public void deleteById(Long id) {
        drogaRepository.deleteById(id);
    }

    @Override
    public void update(Droga droga) {
        drogaRepository.save(droga);
    }

    @Override
    public Droga findByName(String name){
        return drogaRepository.findByNombre(name);
    }

    @Override
    public Integer getTotalVentas() {
    List<Droga> drogas = cargarDrogasDesdeExcel();  // Carga las drogas desde Excel
    int totalVentas = 0;
    for (Droga droga : drogas) {
        totalVentas += droga.getUnidadesVendidas();  // Sumar el total de unidades vendidas
    }
    return totalVentas;
}




    @Override
    public Float getTotalGanancias() {
    List<Droga> drogas = cargarDrogasDesdeExcel();  // Carga las drogas desde Excel
    float totalGanancias = 0;
    for (Droga droga : drogas) {
        float gananciaPorUnidad = droga.getPrecioVenta() - droga.getPrecioCompra();
        totalGanancias += gananciaPorUnidad * droga.getUnidadesVendidas();  // Calcular la ganancia por las unidades vendidas
    }
    return totalGanancias;
}




    // Método para cargar drogas desde Excel
    public List<Droga> cargarDrogasDesdeExcel() {
        List<Droga> drogas = excelService.leerDatosDesdeExcel(); // Llama al método en ExcelService
        for (Droga droga : drogas) {
            drogaRepository.save(droga); // Persiste cada droga en la base de datos
        }
        return drogas; // Retorna la lista de drogas
    }
}
