package co.com.gelsa.prueba.demo.service;

import co.com.gelsa.prueba.demo.dto.OperadorDTO;
import co.com.gelsa.prueba.demo.model.Operador;

public interface OperadorService {

    Operador crear(OperadorDTO operador);
}