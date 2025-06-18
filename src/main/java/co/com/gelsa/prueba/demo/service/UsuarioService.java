package co.com.gelsa.prueba.demo.service;

import co.com.gelsa.prueba.demo.dto.UsuarioDTO;
import co.com.gelsa.prueba.demo.model.Usuario;

public interface UsuarioService {

    Usuario crear(UsuarioDTO usuarioDTO);
}