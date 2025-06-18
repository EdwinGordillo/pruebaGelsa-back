package co.com.gelsa.prueba.demo.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import co.com.gelsa.prueba.demo.dto.RecargaDTO;
import co.com.gelsa.prueba.demo.model.Operador;
import co.com.gelsa.prueba.demo.model.Recarga;
import co.com.gelsa.prueba.demo.model.Usuario;
import co.com.gelsa.prueba.demo.repository.OperadorRepository;
import co.com.gelsa.prueba.demo.repository.RecargaRepository;
import co.com.gelsa.prueba.demo.repository.UsuarioRepository;
import co.com.gelsa.prueba.demo.service.RecargaService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecargaServiceImpl implements RecargaService {
    private final RecargaRepository recargaRepository;
    private final UsuarioRepository usuarioRepository;
    private final OperadorRepository operadorRepository;

    @Override
    public Recarga registrarRecarga(RecargaDTO recargaDTO) {
        Usuario usuario = usuarioRepository.findById(recargaDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Operador operador = operadorRepository.findById(recargaDTO.getOperadorId())
                .orElseThrow(() -> new RuntimeException("Operador no encontrado"));
        
        Recarga recarga = Recarga.builder()
                .usuario(usuario)
                .operador(operador)
                .valor(recargaDTO.getValor())
                .fecha(LocalDate.now())
                .build();
        return recargaRepository.save(recarga);
    }

    @Override
    public List<Object[]> resumenRecargasPorOperador() {
        return recargaRepository.resumenRecargas();
    }
}
