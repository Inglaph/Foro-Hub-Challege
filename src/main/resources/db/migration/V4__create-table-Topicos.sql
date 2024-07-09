CREATE TABLE topicos(

    id serial PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensaje VARCHAR(1000) NOT NULL,
    fecha_creacion TIMESTAMP NOT NULL,
    estado BOOLEAN NOT NULL,
    id_autor INT NOT NULL,
    id_curso INT NOT NULL,


    CONSTRAINT fk_topicos_cursos FOREIGN KEY (id_curso) REFERENCES cursos(id),
    CONSTRAINT fk_topicos_usuarios FOREIGN KEY (id_autor) REFERENCES usuarios(id)
);