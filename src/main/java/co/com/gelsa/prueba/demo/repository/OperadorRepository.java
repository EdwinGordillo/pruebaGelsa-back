package co.com.gelsa.prueba.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.gelsa.prueba.demo.model.Operador;

public interface OperadorRepository extends JpaRepository<Operador, Long> {
}