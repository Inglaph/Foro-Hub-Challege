CREATE TABLE perfiles (

    id serial PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL UNIQUE,
    descripcion VARCHAR(255) NOT NULL
);