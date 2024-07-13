package com.forohub.api.topico;

public class DatosRespuestaTopico {
    private String id;
    private String titulo;
    private String mensaje;
    private String fechaCreacion;
    private String estado;
    private String nombreUsuario;
    private String nombreCurso;

    public DatosRespuestaTopico(String id, String titulo, String mensaje, String fechaCreacion, String estado, String nombreUsuario, String nombreCurso) {
        this.id = id;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.nombreUsuario = nombreUsuario;
        this.nombreCurso = nombreCurso;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }
}
