package co.com.gelsa.prueba.demo.service.impl;

import org.springframework.stereotype.Service;

import co.com.gelsa.prueba.demo.dto.UsuarioDTO;
import co.com.gelsa.prueba.demo.model.Usuario;
import co.com.gelsa.prueba.demo.repository.UsuarioRepository;
import co.com.gelsa.prueba.demo.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario crear(UsuarioDTO usuarioDTO) {
        Usuario usuario = Usuario.builder()
                .nombre(usuarioDTO.getNombre())
                .documento(usuarioDTO.getDocumento())
                .build();
        return usuarioRepository.save(usuario);
    }
    
}
