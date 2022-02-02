# Prueba de Banco Popular
<h3>Paso 1</h3>

- Para Ejecutar el proyecto es necesario tener instalado PostgreSQL y Java 11
- Las configuraciones de la base de datos se encuentran en application.properties
<h4>application.properties</h4>

```html
spring.datasource.url = jdbc:postgresql://localhost/pruebasSpring?currentSchema=prueba
spring.datasource.username=user
spring.datasource.password=user
server.port=8080
spring.jpa.hibernate.ddl-auto=none
logging.level.org.hibernate.SQL=debug
```

Se requiere modificar los campos "pruebasSpring" para la BD y "prueba" para el esquema. Adicional del username y password, segun corresponda a la configuracion de BD

<h3>Paso 2</h3>
Se requiere ejecutar los scripts de creacion e insert a la BD encontrados en el archivo "Creacion de BD banco Popular.sql"

<h3>Paso 3</h3>

- AL ejecutar el proyecto, este tiene configurado las extensiones de Swagger los cuales permiten ver la documentacion del API por el ruta http://localhost:8080/swagger-ui.html#/

<h4>Servicios</h4>

para acceder a los servicios se probo con PostMan a traves de la URL de tipo:

* GET " http://localhost:8080/myhotel/ingresoAcompanantes ", 
* GET " http://localhost:8080/myhotel/serviciosConsumidos ", 
* GET " http://localhost:8080/myhotel/valorTotal/{documentoCliente} ", 

<h4>Modelo de Base de datos</h4>
![image](https://user-images.githubusercontent.com/32335000/152251747-14a96913-82db-4545-9ced-7a80ff4a829c.png)


