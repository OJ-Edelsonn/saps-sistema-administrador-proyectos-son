# S.A.P.S - Sistema Administrador de Proyectos Son

Aplicacion web academica desarrollada con Java 17, Spring Boot 3, Spring MVC, Thymeleaf, Spring Data JPA, Spring Security, MySQL, Maven y Bootstrap 5.

## Requisitos Previos

- Windows.
- Java 17.
- Maven o un IDE con soporte Maven.
- XAMPP con Apache y MySQL.
- MySQL Workbench.
- NetBeans o Spring Tools for Eclipse.

## Ejecucion Con XAMPP

1. Abrir XAMPP.
2. Activar manualmente Apache y MySQL.
3. Abrir MySQL Workbench.
4. Crear la base de datos `saps_db`.
5. Abrir el proyecto Maven `saps` en NetBeans o Spring Tools for Eclipse.
6. Verificar `src/main/resources/application.properties`.
7. Ejecutar `SapsApplication.java` como Spring Boot App.
8. Abrir `http://localhost:8080`.

SQL recomendado para la primera ejecucion:

```sql
CREATE DATABASE saps_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

La aplicacion crea las tablas con JPA/Hibernate al iniciar. Los scripts de la carpeta `database` se conservan como respaldo y datos de apoyo para pruebas.

## Nota Para NetBeans

Cuando ejecutes el proyecto desde NetBeans, la pestana `Run (SapsApplication)` no se cierra sola porque Spring Boot levanta un servidor web permanente. Eso es normal.

Este proyecto incluye `nbactions.xml` para que S.A.P.S se ejecute con JDK 17 desde NetBeans sin cambiar el JDK global del IDE ni afectar otros proyectos.

El sistema ya esta listo cuando en la consola aparezca:

```text
S.A.P.S LISTO
Abrir: http://localhost:8080
```

En ese momento abre el navegador y entra a `http://localhost:8080`. Para detener el sistema usa el boton rojo `Stop` de NetBeans.

## Usuarios De Prueba

- Administrador: `admin` / `admin123`
- Docente: `docente` / `docente123`
- Estudiante: `estudiante` / `estudiante123`

## Validacion

- Compilacion Maven ejecutada con Java 17.
- Prueba funcional con XAMPP, MySQL local y acceso a `http://localhost:8080`.
- Verificacion de login, dashboard, estructura de tablas y carga inicial de datos.

## Modulos

Usuarios, cursos, docentes, estudiantes, grupos, proyectos integradores, entregables, observaciones, rubricas, criterios de evaluacion, calificaciones, dashboard y reportes.

## Estructura

- `src/main/java/com/son/saps/controller`: controladores MVC.
- `src/main/java/com/son/saps/model`: entidades JPA.
- `src/main/java/com/son/saps/repository`: repositorios Spring Data JPA.
- `src/main/java/com/son/saps/service`: servicios de negocio.
- `src/main/resources/templates`: vistas Thymeleaf.
- `database`: scripts SQL.
- `docs`: documentacion tecnica, manuales y UML.
- `nbactions.xml`: configuracion local de NetBeans para ejecutar S.A.P.S con JDK 17.

## Autor

Son.
