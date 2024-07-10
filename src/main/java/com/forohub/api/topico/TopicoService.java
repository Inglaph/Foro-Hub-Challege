package com.forohub.api.topico;

import com.forohub.api.curso.Curso;
import com.forohub.api.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TopicoService {

    private final TopicoRepository topicoRepository;

    @Autowired
    public TopicoService(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    public String getNombreCurso(Long idCurso) {
        Curso curso = topicoRepository.findCursoById(idCurso);
        return curso != null ? curso.getNombre() : "Curso no encontrado";
    }

    public String getNombreUsuario(Long idUsuario) {
        Usuario usuario = topicoRepository.findUsuarioById(idUsuario);
        return usuario != null ? usuario.getNombre() : "Usuario no encontrado";
    }
}