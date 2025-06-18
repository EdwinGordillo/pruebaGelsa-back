package co.com.gelsa.prueba.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.com.gelsa.prueba.demo.model.Recarga;

public interface RecargaRepository extends JpaRepository<Recarga, Long> {

    @Query("SELECT r.operador.nombre, r.usuario.nombre, SUM(r.valor), COUNT(r) " +
           "FROM Recarga r " +
           "GROUP BY r.operador.nombre, r.usuario.nombre")
    List<Object[]> resumenRecargas();
}