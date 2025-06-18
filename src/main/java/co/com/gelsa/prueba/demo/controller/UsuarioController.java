package co.com.gelsa.prueba.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.gelsa.prueba.demo.dto.UsuarioDTO;
import co.com.gelsa.prueba.demo.model.Usuario;
import co.com.gelsa.prueba.demo.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> crear(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.crear(usuarioDTO));
    }
}
