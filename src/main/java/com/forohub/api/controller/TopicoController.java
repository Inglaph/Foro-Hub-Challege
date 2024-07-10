package com.forohub.api.controller;

import com.forohub.api.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private TopicoService topicoService;

    // Metodo para registrar un topico
    @PostMapping
    @Transactional
    public void registrarTopico (@RequestBody @Valid DatosRegistroTopico datosRegistroTopico) {
        System.out.println(" El request fue exitoso");
        topicoRepository.save(new Topico(datosRegistroTopico));
    }

    // Metodo para listar todos los topicos
    @GetMapping
    public Page<DatosListadoTopico> listarTopicos(@PageableDefault(size = 10) Pageable paginacion) {
        return topicoRepository.findAll(paginacion).map(topico -> {
            String nombreUsuario = topicoService.findUsuarioById(topico.getIdUsuario().longValue());
            String nombreCurso = topicoService.findCursoById(topico.getIdCurso().longValue());
            return new DatosListadoTopico(
                    topico.getId().toString(),
                    topico.getTitulo(),
                    topico.getMensaje(),
                    topico.getFechaCreacion().toString(),
                    topico.isEstado() ? "Activo" : "Inactivo",
                    nombreUsuario,
                    nombreCurso
            );
        });
    }

}

