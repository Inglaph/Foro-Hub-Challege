
CREATE TABLE respuestas(

    id serial PRIMARY KEY,
    mensaje VARCHAR(1000) NOT NULL,
    fecha_creacion TIMESTAMP NOT NULL,
    id_usuario INT NOT NULL,
    id_topico INT NOT NULL,
    solucion BOOLEAN NOT NULL,

    CONSTRAINT fk_respuestas_topicos FOREIGN KEY (id_topico) REFERENCES topicos(id),
    CONSTRAINT fk_respuestas_usuarios FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);