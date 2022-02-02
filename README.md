# Prueba de Banco Popular
Prueba del Banco de Popular

- Para Ejecutar el proyecto es necesario tener instalado PostgreSQL y Java 11
- Las configuraciones de la base de datos de encuentran en application.properties

spring.datasource.url = jdbc:postgresql://localhost/pruebasSpring?currentSchema=prueba
spring.datasource.username=user
spring.datasource.password=user
server.port=8080
spring.jpa.hibernate.ddl-auto=none
logging.level.org.hibernate.SQL=debug

- Y se requiere modificar los campos "pruebasSpring" para la BD y "prueba" para el esquema. Adicional del username y password, segun corresponda a la configuracion de BD
- AL ejecutar el proyecto, este tiene configurado las extensiones de Swagger los cuales permiten ver la documentacion del API por el ruta http://localhost:8080/swagger-ui.html#/
- para acceder a los servicios se probo con PostMan a traves de la URL de tipo:
* GET " http://localhost:8080/myhotel/ingresoAcompanantes ", 
* GET " http://localhost:8080/myhotel/serviciosConsumidos ", 
* GET " http://localhost:8080/myhotel/valorTotal/{documentoCliente} ", 
