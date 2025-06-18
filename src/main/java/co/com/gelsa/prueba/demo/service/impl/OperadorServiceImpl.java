package co.com.gelsa.prueba.demo.service.impl;

import org.springframework.stereotype.Service;

import co.com.gelsa.prueba.demo.dto.OperadorDTO;
import co.com.gelsa.prueba.demo.model.Operador;
import co.com.gelsa.prueba.demo.repository.OperadorRepository;
import co.com.gelsa.prueba.demo.service.OperadorService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OperadorServiceImpl implements OperadorService {
    private final OperadorRepository operadorRepository;

    @Override
    public Operador crear(OperadorDTO nombre) {
        Operador operador = Operador.builder()
                .nombre(nombre.getNombre())
                .build();
        return operadorRepository.save(operador);
    }
    
}