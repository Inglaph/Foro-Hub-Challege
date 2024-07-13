# ForoHub API
Desarrollo a API Rest  para  challenge Foro Hub de Oracle ONE Next Education G6

by [*@inglaph*](https://github.com/Inglaph)
*2024*
___
## Tabla de Contenido

- [ForoHub API](#forohub-api)
    - [Tabla de Contenido](#tabla-de-contenido)
    - [Características](#características)
    - [Tecnologías Utilizadas](#tecnologías-utilizadas)
    - [Estructura del Proyecto](#estructura-del-proyecto)
    - [Configuración](#configuración)
    - [Flyway](#flyway)
    - [Ejemplos de Uso](#ejemplos-de-uso)
        - [Autenticación de Usuario](#autenticación-de-usuario)
        - [Crear un Tópico](#crear-un-tópico)
        - [Listar Tópicos](#listar-tópicos)
        - [Actuliazar un Tópico](#actuliazar-un-tópico)
        - [Eliminar un Tópico](#eliminar-un-tópico)
        - [Seguridad](#seguridad)
        - [Manejo de Errores](#manejo-de-errores)
        - [Licencia](#licencia)

ForoHub es una plataforma de discusión en línea diseñada para facilitar la comunicación y el intercambio de ideas entre usuarios interesados en diversos temas. Esta API proporciona los medios necesarios para crear, gestionar y participar en discusiones de foros, permitiendo a los usuarios interactuar en un entorno seguro y estructurado.

## Características

- **Autenticación de Usuarios**: Registro e inicio de sesión seguro para usuarios.
- **Gestión de Tópicos**: Los usuarios pueden crear, listar, actualizar y eliminar tópicos de discusión.
- **Seguridad**: Implementación de JWT para la autenticación y protección de rutas.
- **Errores Manejados**: Respuestas de error claras y concisas para una mejor experiencia de desarrollo.

## Tecnologías Utilizadas

- Java
- Spring Boot
- Maven
- PostgreSQL
- JWT para autenticación

## Estructura del Proyecto

El proyecto sigue una estructura MVC (Modelo-Vista-Controlador), organizada de la siguiente manera:

- `src/main/java/com/forohub/api/controller`: Controladores que manejan las solicitudes HTTP.
- `src/main/java/com/forohub/api/domain`: Entidades y lógica de negocio.
- `src/main/java/com/forohub/api/infra`: Configuraciones de seguridad y manejo de errores.
- `src/main/resources`: Contiene archivos de configuración como `application.properties`.

## Configuración

Para ejecutar la aplicación, es necesario configurar las siguientes propiedades en `src/main/resources/application.properties`:

- `spring.datasource.url`: URL de la base de datos PostgreSQL.
- `spring.datasource.username`: Nombre de usuario de la base de datos.
- `spring.datasource.password`: Contraseña de la base de datos.
- `api.security.secret`: Secreto utilizado para firmar los tokens JWT.

## Flyway

Para la creación de la base de datos y las tablas necesarias, se utiliza Flyway. Al iniciar la aplicación, Flyway ejecutará las migraciones en `src/main/resources/db/migration` para crear las tablas y cargar los datos de prueba.

Para facilitar las pruebas, se han creado tres usuarios de prueba en la base de datos:

| ID | Nombre        | Email                    | Contraseña                  |
|----|---------------|--------------------------|-----------------------------|
| 1  | Luis Posada   | luisposada@example.com   | passwordLuPoForoHub1245     |
| 2  | Juan Perez    | juanperez@example.com    | ContraseñaDePrueba654       |
| 3  | Maria Garcia  | mariagarcia@example.com  | PasswordDePruebaUsuario2    |


## Ejemplos de Uso


### Autenticación de Usuario

**POST** `/login`

Request body:
```json
{
  "email": "usuario@example.com",
  "password": "contraseña"
}
```

Response:
```json
{
  "token": "JWT_TOKEN"
}
```

### Crear un Tópico  
POST /topicos  
Header: Authorization: Bearer JWT_TOKEN  
Request body:
```json
{
  "titulo": "Título del Tópico",
  "mensaje": "Mensaje del Tópico",
  "idUsuario": 1,
  "idCurso": 1
}
```

### Listar Tópicos 
GET /topicos
Header: Authorization: Bearer JWT_TOKEN  
Response:
```json
{
  "totalPages": 1,
  "totalElements": 7,
  "pageable": {
    "pageNumber": 0,
    "pageSize": 10,
    "sort": {
      "sorted": true,
      "unsorted": false,
      "empty": false
    },
    "offset": 0,
    "paged": true,
    "unpaged": false
  },
  "first": true,
  "last": true,
  "size": 10,
  "content": [
    {
      "id": "1",
      "titulo": "Error para probar la respuesta de la API",
      "mensaje": "Al enviar el request a la API en el registro de Topicos responde 404 Bad Request",
      "fechaCreacion": "2024-07-10",
      "estado": "Activo",
      "nombreUsuario": "Luis Posada",
      "nombreCurso": "Desarrollo Web"
    },
    {
      "id": "3",
      "titulo": "Error al generar reporte contable",
      "mensaje": "No se pudo generar el reporte contable debido a un problema con los datos financieros. Verifique los datos e intente nuevamente.",
      "fechaCreacion": "2024-07-10",
      "estado": "Activo",
      "nombreUsuario": "Juan Perez",
      "nombreCurso": "Contabilidad"
    },
    {
      "id": "4",
      "titulo": "Error al exportar archivo de diseño",
      "mensaje": "No se pudo exportar el archivo de diseño debido a un error inesperado. Asegúrese de tener los permisos necesarios y vuelva a intentarlo.",
      "fechaCreacion": "2024-07-10",
      "estado": "Activo",
      "nombreUsuario": "Maria Garcia",
      "nombreCurso": "Diseño Gráfico"
    },
    {
      "id": "5",
      "titulo": "Mostrar String nombres referenciando ID en BD",
      "mensaje": "Caused by: org.hibernate.type.descriptor.java.spi.JdbcTypeRecommendationException: Could not determine recommended JdbcType for Java type 'com.forohub.api.topico.TopicoRepository'.",
      "fechaCreacion": "2024-07-10",
      "estado": "Activo",
      "nombreUsuario": "Juan Perez",
      "nombreCurso": "Desarrollo Web"
    },
    {
      "id": "2",
      "titulo": "Error al crear una campaña de marketing digital - ACT 3 Con metodo PUT y el ID en la URL",
      "mensaje": "No se pudo crear la campaña de marketing digital,error en el servidor. Intente nuevamente.",
      "fechaCreacion": "2024-07-10",
      "estado": "Activo",
      "nombreUsuario": "Juan Perez",
      "nombreCurso": "Marketing Digital"
    },
    {
      "id": "6",
      "titulo": "Conectar el backEnd con el FrontEnd - PUT  con validacion de datos completos, retorno de DTO y ResponseEntity ",
      "mensaje": "Error de prueba para la creacion de un topico con una fecha distinta a los demas y probar el ordenamiento por fecha",
      "fechaCreacion": "2024-07-12",
      "estado": "Activo",
      "nombreUsuario": "Luis Posada",
      "nombreCurso": "Desarrollo Web"
    },
    {
      "id": "8",
      "titulo": "Error de prueba creacion de Topico con ResponseEntity",
      "mensaje": "Mensaje: Error de prueba creacion de Topico con ResponseEntity",
      "fechaCreacion": "2024-07-13",
      "estado": "Activo",
      "nombreUsuario": "Juan Perez",
      "nombreCurso": "Desarrollo Web"
    }
  ],
  "number": 0,
  "sort": {
    "sorted": true,
    "unsorted": false,
    "empty": false
  },
  "numberOfElements": 7,
  "empty": false
}
```

### Actuliazar un Tópico
PUT /topicos/{id}
Header: Authorization
Request body:
```json
{
  "titulo": "Título del Tópico Actualizado",
  "mensaje": "Mensaje del Tópico Actualizado",
  "idUsuario": 1,
  "idCurso": 1
}
```
Response:
```json
{
  "id": "1",
  "titulo": "Título del Tópico Actualizado",
  "mensaje": "Mensaje del Tópico Actualizado",
  "fechaCreacion": "2024-07-10",
  "estado": "Activo",
  "nombreUsuario": "Luis Posada",
  "nombreCurso": "Desarrollo Web"
}
```

### Eliminar un Tópico
DELETE /topicos/{id}
Header: Authorization: Bearer JWT_TOKEN

### Seguridad
La API utiliza JWT para manejar la autenticación. Es necesario incluir el token JWT en el header Authorization para acceder a las rutas protegidas.

### Manejo de Errores
La API devuelve errores claros y específicos, facilitando la depuración y el manejo de errores en el lado del cliente.


## Reglas de Negocio



### Licencia
Este proyecto está bajo la Licencia MIT. Vea el archivo LICENSE para más detalles.