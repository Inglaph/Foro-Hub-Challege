package com.forohub.api.topico;

import com.forohub.api.curso.Curso;
import com.forohub.api.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface TopicoRepository  extends JpaRepository<Topico, Long> {

    @Query("SELECT c.nombre FROM Curso c WHERE c.id = :idCurso")
    String findNombreCursoById(Long idCurso);

    @Query("SELECT u.nombre FROM Usuario u WHERE u.id = :idUsuario")
    String findNombreUsuarioById(Long idUsuario);

}
