# S.A.P.S - Sistema Administrador de Proyectos Son

Aplicacion web academica desarrollada con Java 17, Spring Boot 3, Spring MVC, Thymeleaf, Spring Data JPA, Spring Security, MySQL, Maven y Bootstrap 5.

## Requisitos previos

- Windows.
- Java 17.
- Maven o un IDE con soporte Maven.
- XAMPP con Apache y MySQL.
- MySQL Workbench.
- NetBeans o Spring Tools for Eclipse.

## Ejecucion con XAMPP

1. Abrir XAMPP.
2. Activar manualmente Apache y MySQL.
3. Abrir MySQL Workbench.
4. Crear la base de datos `saps_db` o ejecutar `database/saps_db.sql`.
5. Abrir el proyecto Maven `saps` en NetBeans o Spring Tools for Eclipse.
6. Verificar `src/main/resources/application.properties`.
7. Ejecutar `SapsApplication.java` como Spring Boot App.
8. Abrir `http://localhost:8080`.

### Nota importante para NetBeans

Cuando ejecutes el proyecto desde NetBeans, la pestaña `Run (SapsApplication)` no se cierra sola porque Spring Boot levanta un servidor web permanente. Eso es normal.

El sistema ya esta listo cuando en la consola aparezca:

```text
S.A.P.S LISTO
Abrir: http://localhost:8080
```

En ese momento abre el navegador y entra a `http://localhost:8080`. Para detener el sistema usa el boton rojo `Stop` de NetBeans.

## Usuarios de prueba

- Administrador: `admin` / `admin123`
- Docente: `docente` / `docente123`
- Estudiante: `estudiante` / `estudiante123`

## Validacion realizada

- Compilacion Maven ejecutada con Java 17: `mvn -DskipTests package`.
- La prueba funcional completa requiere activar manualmente Apache y MySQL desde XAMPP antes de ejecutar `SapsApplication.java`.
- El informe Word fue generado en `docs/Informe_SAPS.docx`. La revision visual por render no se completo en este entorno porque LibreOffice/`soffice` no esta instalado en PATH.

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

## Autor

Son.
