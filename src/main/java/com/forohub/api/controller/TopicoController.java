package com.forohub.api.controller;

import com.forohub.api.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private TopicoService topicoService;

    // Metodo para registrar un topico httpRequest 201 o 400
    @PostMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> registrarTopico (@RequestBody @Valid DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uriComponentsBuilder) {
        Topico topico = topicoRepository.save(new Topico(datosRegistroTopico));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(
                topico.getId().toString(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion().toString(),
                topico.isEstado() ? "Activo" : "Inactivo",
                topicoService.findUsuarioById(topico.getIdUsuario().longValue()),
                topicoService.findCursoById(topico.getIdCurso().longValue())
        );
        URI uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri(); // Se crea la URI para la respuesta
        return ResponseEntity.created(uri).body(datosRespuestaTopico);
    }

    // Metodo para listar todos los topicos httpRequest 200
    @GetMapping
    public Page<DatosListadoTopico> listarTopicos(@PageableDefault(size = 10, sort = "fechaCreacion") Pageable paginacion) {
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

    // Metodo para listar un topico por id httpRequest 200 o 404
    @GetMapping("/{id}")
    public ResponseEntity<DatosListadoTopico> listarTopicoPorId(@PathVariable Long id) {
        DatosListadoTopico datosListadoTopico = topicoRepository.findById(id).map(topico -> {
            String nombreUsuario = topicoService.findUsuarioById(topico.getIdUsuario().longValue());
            String nombreCurso = topicoService.findCursoById(topico.getIdCurso().longValue());
            return new DatosListadoTopico(topico, nombreUsuario, nombreCurso);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Topico no encontrado con el id: " + id));
        return ResponseEntity.ok(datosListadoTopico);
    }

    // Metodo para actualizar un topico
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> actualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosRegistroTopico datosActualizarTopico) {
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        topicoOptional.ifPresentOrElse(topico -> {
            topico.actualizarDatos(datosActualizarTopico);
            topicoRepository.save(topico);
        }, () -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado");
        });
        // Se retorna el DTO DatosRespuestaTopico con los datos actualizados de la entidad Topico topicoOptional
        return ResponseEntity.ok(new  DatosRespuestaTopico(
            topicoOptional.get().getId().toString(),
            topicoOptional.get().getTitulo(),
            topicoOptional.get().getMensaje(),
            topicoOptional.get().getFechaCreacion().toString(),
            topicoOptional.get().isEstado() ? "Activo" : "Inactivo",
            topicoService.findUsuarioById(topicoOptional.get().getIdUsuario().longValue()),
            topicoService.findCursoById(topicoOptional.get().getIdCurso().longValue()
        )));
    }


    // Metodo para eliminar un topico httpRequest 200 o 404
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        topicoOptional.ifPresentOrElse(topicoRepository::delete, () -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado");
        });
        return ResponseEntity.ok().build();
    }

}

