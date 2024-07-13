package com.forohub.api.domain.topico;

public record DatosListadoTopico(
        String id,
        String titulo,
        String mensaje,
        String fechaCreacion,
        String estado,
        String nombreUsuario,
        String nombreCurso
) {
    public DatosListadoTopico(Topico topico, String nombreUsuario, String nombreCurso) {
        this(
                topico.getId().toString(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion().toString(),
                topico.isEstado() ? "Activo" : "Inactivo",
                nombreUsuario,
                nombreCurso
        );
    }
}