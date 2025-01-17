package com.forohub.api.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor // Lombok anotacion para crear un constructor vacio
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDate fechaCreacion;
    private boolean estado;
    private Integer idUsuario;
    private Integer idCurso;

    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();

        this.idUsuario = Integer.parseInt(datosRegistroTopico.idUsuario());
        //
        this.idCurso = Integer.parseInt(datosRegistroTopico.idCurso());
        this.fechaCreacion = LocalDate.now();
        this.estado = true;
    }


    public void actualizarDatos(DatosRegistroTopico datosActualizarTopico) {
        if (datosActualizarTopico.titulo() != null) {
            this.titulo = datosActualizarTopico.titulo();
        }
        if (datosActualizarTopico.mensaje() != null) {
            this.mensaje = datosActualizarTopico.mensaje();
        }
        if (datosActualizarTopico.idUsuario() != null) {
            this.idUsuario = Integer.parseInt(datosActualizarTopico.idUsuario());
        }
        if (datosActualizarTopico.idCurso() != null) {
            this.idCurso = Integer.parseInt(datosActualizarTopico.idCurso());
        }
    }
}
