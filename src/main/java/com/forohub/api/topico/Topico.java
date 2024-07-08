package com.forohub.api.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@NoArgsConstructor // Lombok anotacion para crear un constructor vacio
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 250)
    private String titulo;

    @Column(nullable = false, length = 1000)
    private String mensaje;

    @Column(nullable = false)
    private LocalDate fechaCreacion;

    @Column(nullable = false)
    private int status;

    @Column(nullable = false)
    private String idUsuario;
    private String Curso;



    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.idUsuario = datosRegistroTopico.idUsuario();
        this.Curso = datosRegistroTopico.nombreCurso();
        this.fechaCreacion = LocalDate.now();
        this.status = 1;
    }
}
