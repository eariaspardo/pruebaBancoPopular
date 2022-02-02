# Prueba de Banco Popular
####Paso 1
- Para Ejecutar el proyecto es necesario tener instalado PostgreSQL y Java 11
- Las configuraciones de la base de datos se encuentran en application.properties
#####application.properties
```html
spring.datasource.url = jdbc:postgresql://localhost/pruebasSpring?currentSchema=prueba
spring.datasource.username=user
spring.datasource.password=user
server.port=8080
spring.jpa.hibernate.ddl-auto=none
logging.level.org.hibernate.SQL=debug
```

Se requiere modificar los campos "pruebasSpring" para la BD y "prueba" para el esquema. Adicional del username y password, segun corresponda a la configuracion de BD

####Paso 2
Se requiere ejecutar los scripts de creacion e insert a la BD encontrados en el archivo

####Paso 3
- AL ejecutar el proyecto, este tiene configurado las extensiones de Swagger los cuales permiten ver la documentacion del API por el ruta http://localhost:8080/swagger-ui.html#/
#####Servicios
para acceder a los servicios se probo con PostMan a traves de la URL de tipo:
* GET " http://localhost:8080/myhotel/ingresoAcompanantes ", 
* GET " http://localhost:8080/myhotel/serviciosConsumidos ", 
* GET " http://localhost:8080/myhotel/valorTotal/{documentoCliente} ", 
