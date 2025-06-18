package co.com.gelsa.prueba.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.gelsa.prueba.demo.dto.OperadorDTO;
import co.com.gelsa.prueba.demo.model.Operador;
import co.com.gelsa.prueba.demo.service.OperadorService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/operadores")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class OperadorController {
    private final OperadorService operadorService;

    @PostMapping
    public ResponseEntity<Operador> crear(@RequestBody OperadorDTO operadorDTO) {
        return ResponseEntity.ok(operadorService.crear(operadorDTO));
    }
}
