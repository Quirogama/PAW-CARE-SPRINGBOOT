package com.example.pawcare.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pawcare.servicio.TratamientoService;

@RestController
@RequestMapping("/api/tratamientos")
@CrossOrigin(origins = "http://localhost:4200")  // Permitir solicitudes desde Angular
public class TratamientoController {

    @Autowired
    private TratamientoService tratamientoService;

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
