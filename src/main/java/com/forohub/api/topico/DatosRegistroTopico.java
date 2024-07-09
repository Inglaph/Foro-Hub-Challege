package com.forohub.api.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
                @Pattern(regexp = "[0-9]+") // Solo numeros
        String idUsuario,
        @NotBlank
                @Pattern(regexp = "[0-9]+") // Solo numeros
        String idCurso
) {
}
