package com.example.pawcare.servicio;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.pawcare.entidad.Droga;
import com.example.pawcare.repositorio.DrogaRepository;

@Service
public class ExcelService {

    @Autowired
    DrogaRepository drogaRepository;

    public List<Droga> leerDatosDesdeExcel() {
        List<Droga> drogas = new ArrayList<>();
        
        try {
            ClassPathResource resource = new ClassPathResource("excel/MEDICAMENTOS_VETERINARIA.xlsx");
            InputStream inputStream = resource.getInputStream();
            Workbook workbook = new XSSFWorkbook(inputStream);
    
            Sheet sheet = workbook.getSheetAt(0); // Seleccionar la primera hoja
            for (Row row : sheet) {
                if (row.getRowNum() == 0) { // Saltar la primera fila si tiene encabezados
                    continue;
                }
    
                // Leer cada celda, ajustando según el tipo
                String nombre = row.getCell(0).getStringCellValue();
                float precioVenta = (float) row.getCell(1).getNumericCellValue(); // Cambia esto
                float precioCompra = (float) row.getCell(2).getNumericCellValue(); // Cambia esto
                int unidadesDisp = (int) row.getCell(3).getNumericCellValue();
                int unidadesVendidas = (int) row.getCell(4).getNumericCellValue();
    
                // Crear una instancia de la entidad Droga y agregarla a la lista
                Droga droga = new Droga(nombre, precioCompra, precioVenta, unidadesDisp, unidadesVendidas);
                drogaRepository.save(droga);
                drogas.add(droga);
            }
    
            workbook.close();
            inputStream.close();
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        return drogas;
    }

    public void guardarEnRepositorio() {
        List<Droga> drogas = leerDatosDesdeExcel();
        drogaRepository.saveAll(drogas);
    }
}
