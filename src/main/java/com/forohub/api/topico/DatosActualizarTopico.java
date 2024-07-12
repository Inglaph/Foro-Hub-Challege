package com.forohub.api.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DatosActualizarTopico(
        String titulo,
        String mensaje,
        @Pattern(regexp = "[0-9]+") // Solo numeros
        String idUsuario,
        @Pattern(regexp = "[0-9]+") // Solo numeros
        String idCurso
) {
}