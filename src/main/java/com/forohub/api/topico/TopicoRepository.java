package com.forohub.api.topico;

import com.forohub.api.curso.Curso;
import com.forohub.api.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TopicoRepository  extends JpaRepository<Topico, Long> {

    // Metodo para retornar el nombre del curso de un topico por su id
    public Curso findCursoById(Long idCurso);

    // Metodo para retornar el nombre del usuario de un topico por su id
    public Usuario findUsuarioById(Long idUsuario);
}
