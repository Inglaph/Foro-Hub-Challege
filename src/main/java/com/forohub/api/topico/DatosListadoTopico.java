package com.forohub.api.topico;

public record DatosListadoTopico(
        String id,
        String titulo,
        String mensaje,
        String fechaCreacion,
        String estado,
        String idUsuario,
        String idCurso
) {

    public DatosListadoTopico(Topico topico) {
        this(
                topico.getId().toString(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion().toString(),
                topico.isEstado() ? "Activo" : "Inactivo",
                topico.getIdUsuario().toString(),
                topico.getIdCurso().toString()
        );
    }
}
