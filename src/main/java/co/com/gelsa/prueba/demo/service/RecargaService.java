package co.com.gelsa.prueba.demo.service;

import java.util.List;

import co.com.gelsa.prueba.demo.dto.RecargaDTO;
import co.com.gelsa.prueba.demo.model.Recarga;

public interface RecargaService {

    Recarga registrarRecarga(RecargaDTO recarga);

    List<Object[]> resumenRecargasPorOperador();
}