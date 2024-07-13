package com.forohub.api.domain.topico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TopicoService {

    private final TopicoRepository topicoRepository;

    @Autowired
    public TopicoService(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    public String findCursoById(Long idCurso) {
        return topicoRepository.findNombreCursoById(idCurso);
    }

    public String findUsuarioById(Long idUsuario) {
        return topicoRepository.findNombreUsuarioById(idUsuario);
    }
}