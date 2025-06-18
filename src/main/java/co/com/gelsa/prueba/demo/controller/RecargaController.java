package co.com.gelsa.prueba.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.gelsa.prueba.demo.dto.RecargaDTO;
import co.com.gelsa.prueba.demo.model.Recarga;
import co.com.gelsa.prueba.demo.service.RecargaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/recargas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RecargaController {
    
    private final RecargaService recargaService;

    @PostMapping
    public ResponseEntity<Recarga> crear(@RequestBody RecargaDTO recargaDTO) {
        return ResponseEntity.ok(recargaService.registrarRecarga(recargaDTO));
    }

    @GetMapping("/resumen")
    public ResponseEntity<List<Object[]>> resumenRecargasPorOperador() {
        return ResponseEntity.ok(recargaService.resumenRecargasPorOperador());
    }
}
