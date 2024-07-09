
CREATE TABLE usuarios(

    id serial PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    id_perfil INT NOT NULL,

    CONSTRAINT fk_usuarios_perfiles FOREIGN KEY (id_perfil) REFERENCES perfiles(id)
);
