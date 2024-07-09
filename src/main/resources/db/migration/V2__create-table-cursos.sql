 CREATE TABLE cursos(

     id serial PRIMARY KEY,
     nombre VARCHAR(255) NOT NULL UNIQUE,
     categoria VARCHAR(255) NOT NULL
 );