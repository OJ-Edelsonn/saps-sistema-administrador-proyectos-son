# Manual tecnico

## Arquitectura

El proyecto usa MVC por capas: controladores para rutas, servicios para reglas de negocio, repositorios para acceso a datos, entidades JPA para el modelo y Thymeleaf para vistas.

## Configuracion

La conexion MySQL se define en `application.properties`. Hibernate esta configurado con `ddl-auto=update` para facilitar la creacion inicial de tablas durante la sustentacion.

## Seguridad

Spring Security protege las rutas y usa login personalizado. Las contrasenas sembradas por la aplicacion se guardan con el encoder delegante de Spring Security y BCrypt.
