# Microservicio Spring Boot - MongoDB

## Conexión a la base de datos
En el archivo `src/main/resources/application.properties` agregamos la conexión a la DB, en este caso mongoDB
Escribimos: `spring.data.mongodb.uri = ${URL_DB:link_acceso}`

## Ejecutar servidor
ejecutamos el servidor con el comando
`mvn spring-boot:run` o `.\mvnw spring-boot:run`

### Cambiar puerto
En caso de generar un error cambiamos el puerto a ejecutar con el comando: `server.port=8081` en la carpeta `src/main/resources/application.properties`

## Modelo
Creamos el paquete para nuestros modelos en `src/main/java/com.misiontic.AccountMS/models`

Ahra creamos nuestra primera clase dentro de `models/` llamada `Account`

### "Conección" entre las dos bases de datos de Banco
No podemos generar una llave foranea, ya que son bases de datos completamente diferentes.
Para ello guardamos un campo "normal" en la DB en Account, simulando una FK
Podemos utilizar el PK de una tabla para la otra trabal (en relaciones 1:1)

## Decoradores
Con los decoradores agregamos caracteristicas y funcionalidades extras a nuestros atributos, metodos, clases o interfaces
Va antes de la linea a decorar y empieza por @

## Repositorio
Es similar a un Serializador, pero no filtra datos
El se encarga de mapear y darnos metodos para comunicarnos con la DB
Tambien se encara de hacer el trabajo del ORM

Para crear nuestro repositorio creamos un nuevo paquete llamado `repositories` en `src/main/java/com.misiontic.AccountMS/`
Para nuestra tarea, creamos una interfaz llamada `AccountRepository`, ya que solo implementaremos metodos heredados para mongo, los cuales son:
* save - create, update
* delete - delete
* findById - read
* findAll - read all records

## Controladores
Expone los servicios
Para crear nuestro repositorio creamos un nuevo paquete llamado `controllers` en `src/main/java/com.misiontic.AccountMS/`
Creamos una clase llamada `AccountCrontoller`
Dentro de el controlador incluimos los endpoints

Metodos:
* GetMapping -> convierte un metodo en un endpoint de tipo GET
* PostMapping -> convierte un metodo en un endpoint de tipo POST
* PutMapping -> convierte un metodo en un endpoint de tipo UPDATE
* DeleteMapping -> convierte un metodo en un endpoint de tipo DELETE