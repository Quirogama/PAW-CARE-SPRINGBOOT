package com.example.pawcare.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pawcare.entidad.Tratamiento;
import com.example.pawcare.servicio.TratamientoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/tratamiento")
@CrossOrigin(origins = "http://localhost:4200")  // Permitir solicitudes desde Angular
public class TratamientoController {

    @Autowired
    private TratamientoService tratamientoService;
    
    @PostMapping("/add")
    public void addTratamiento(@RequestBody Tratamiento tratamiento) {
        tratamientoService.add(tratamiento);
    }
    /*
     @GetMapping("/cantidadUltimoMes")
    public ResponseEntity<Long> getCantidadTratamientosUltimoMes() {
        Long cantidadTratamientos = tratamientoService.getCantidadTratamientosUltimoMes();
        return ResponseEntity.ok(cantidadTratamientos);
    }etMapping("/cantidadUltimoMes")
    pub
}   Long cantidadTratamientos = tratamientoService.getCantidadTratamientosUltimoMes();
        return ResponseEntity.ok(cantidadTratamientos);
    }etMapping("/cantidadUltimoMes")
    pub
}   Long cantidadTratamientos = tratamientoService.getCantidadTratamientosUltimoMes();
        return ResponseEntity.ok(cantidadTratamientos);
    }etMapping("/cantidadUltimoMes")
    pub
}   Long cantidadTratamientos = tratamientoService.getCantidadTratamientosUltimoMes();
        return ResponseEntity.ok(cantidadTratamientos);
    }etMapping("/cantidadUltimoMes")
    pub
}   Long cantidadTratamientos = tratamientoService.getCantidadTratamientosUltimoMes();
        return ResponseEntity.ok(cantidadTratamientos);
    }etMapping("/cantidadUltimoMes")
    pub
}   Long cantidadTratamientos = tratamientoService.getCantidadTratamientosUltimoMes();
        return ResponseEntity.ok(cantidadTratamientos);
    }etMapping("/cantidadUltimoMes")
    pub
}   Long cantidadTratamientos = tratamientoService.getCantidadTratamientosUltimoMes();
        return ResponseEntity.ok(cantidadTratamientos);
    }etMapping("/cantidadUltimoMes")
    pub
}   Long cantidadTratamientos = tratamientoService.getCantidadTratamientosUltimoMes();
        return ResponseEntity.ok(cantidadTratamientos);
    }etMapping("/cantidadUltimoMes")
    pub
}   Long cantidadTratamientos = tratamientoService.getCantidadTratamientosUltimoMes();
        return ResponseEntity.ok(cantidadTratamientos);
    }
     */
}
