package co.com.gelsa.prueba.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.gelsa.prueba.demo.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
