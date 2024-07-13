package com.forohub.api.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErrores {

    // Maneja la excepción EntityNotFoundException y devuelve un error 404
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarError404() {
        return ResponseEntity.notFound().build();
    }

    // Maneja el error 400 bad request
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400(MethodArgumentNotValidException e) {
        var errores = e.getFieldErrors().stream().map(DatosError::new).toList();
        return ResponseEntity.badRequest().body(errores);
    }

    private  record  DatosError(String campo, String mensaje) {
        public DatosError( FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
