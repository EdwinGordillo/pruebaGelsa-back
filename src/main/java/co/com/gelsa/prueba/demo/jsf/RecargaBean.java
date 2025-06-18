package co.com.gelsa.prueba.demo.jsf;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.gelsa.prueba.demo.model.Operador;
import co.com.gelsa.prueba.demo.model.Recarga;
import co.com.gelsa.prueba.demo.model.Usuario;
import co.com.gelsa.prueba.demo.repository.OperadorRepository;
import co.com.gelsa.prueba.demo.repository.RecargaRepository;
import co.com.gelsa.prueba.demo.repository.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
@Component
@Getter
@Setter
public class RecargaBean implements Serializable {

    private Double valor;
    private Long usuarioId;
    private Long operadorId;

    private List<Usuario> usuarios;
    private List<Operador> operadores;
    private List<Object[]> recargas;

    @Autowired private RecargaRepository recargaRepository;
    @Autowired private UsuarioRepository usuarioRepository;
    @Autowired private OperadorRepository operadorRepository;

    @PostConstruct
    public void init() {
        usuarios = usuarioRepository.findAll();
        operadores = operadorRepository.findAll();
        recargas = recargaRepository.resumenRecargas();
    }

    public void registrarRecarga() {
        Usuario u = usuarioRepository.findById(usuarioId)
                .orElseThrow();
        Operador o = operadorRepository.findById(operadorId)
                .orElseThrow();

        Recarga r = Recarga.builder()
                .valor(valor)
                .fecha(LocalDate.now())
                .usuario(u)
                .operador(o)
                .build();
        
        recargaRepository.save(r);
        valor = null;
        usuarioId = null;
        operadorId = null;
        recargas = recargaRepository.resumenRecargas();
    }
    
}
