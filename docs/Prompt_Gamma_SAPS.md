# Prompt para Gamma - Presentacion S.A.P.S

Crea una presentacion profesional, academica y moderna sobre el proyecto final **S.A.P.S - Sistema Administrador de Proyectos Son**. La presentacion debe servir para sustentar el sistema ante un docente universitario de Lenguaje de Programacion II.

## Estilo visual

Usa un estilo sobrio, limpio y tecnico. Fondo claro, tipografia sans serif, mucho espacio en blanco, bloques visuales ordenados, colores de acento en azul, verde petroleo y naranja. Evita decoraciones excesivas. La presentacion debe parecer hecha por un estudiante de Ingenieria Empresarial y de Sistemas que preparo bien su exposicion.

## Objetivo de la presentacion

Al final, el publico debe entender que S.A.P.S resuelve la administracion y seguimiento de proyectos academicos integradores porque centraliza usuarios, cursos, grupos, proyectos, entregables, observaciones, rubricas, calificaciones, reportes y evidencia de pruebas en una aplicacion web funcional.

## Datos del proyecto

- Nombre: S.A.P.S - Sistema Administrador de Proyectos Son.
- Tipo: aplicacion web academica.
- Autor: Son.
- Tecnologias: Java 17, Spring Boot 3, Spring MVC, Thymeleaf, Spring Data JPA, Spring Security, MySQL, Maven, Bootstrap 5.
- Base de datos: `saps_db`.
- Ejecucion local: `http://localhost:8080`.
- Usuarios de prueba:
  - Administrador: `admin` / `admin123`
  - Docente: `docente` / `docente123`
  - Estudiante: `estudiante` / `estudiante123`

## Estructura sugerida

### 1. Portada
Titulo: **S.A.P.S**
Subtitulo: **Sistema Administrador de Proyectos Son**
Texto breve: Aplicacion web academica para administrar proyectos integradores, entregables, observaciones, rubricas, calificaciones y reportes.

### 2. Problema identificado
Explica que el seguimiento manual de proyectos genera informacion dispersa, observaciones poco centralizadas y dificultad para evidenciar avances y evaluaciones.

### 3. Objetivo y alcance
Presenta el objetivo general: centralizar la gestion academica de proyectos integradores.
Incluye los modulos: usuarios, cursos, docentes, estudiantes, grupos, proyectos, entregables, observaciones, rubricas, criterios, calificaciones, dashboard y reportes.

### 4. Arquitectura del sistema
Muestra un diagrama MVC por capas:
Vistas Thymeleaf -> Controladores MVC -> Servicios -> Repositorios JPA -> MySQL.
Explica que esta separacion mejora mantenimiento y claridad del codigo.

### 5. Modelo de datos principal
Incluye un esquema visual con estas entidades:
Curso, Docente, Grupo, Estudiante, Proyecto, Entregable, Observacion, Rubrica, CriterioEvaluacion, Calificacion, Usuario y Rol.
Destaca que un proyecto pertenece a un grupo y concentra entregables, observaciones y evaluaciones.

### 6. Seguridad y roles
Explica el uso de Spring Security, login personalizado, contrasenas cifradas con BCrypt y roles ADMIN, DOCENTE y ESTUDIANTE.

### 7. Flujo principal del sistema
Representa el flujo:
Login -> Dashboard -> Registro de proyecto -> Entregable -> Observacion -> Rubrica -> Calificacion -> Reporte.

### 8. Interfaz y modulos funcionales
Resume que las vistas permiten listar, crear, editar, eliminar y consultar informacion. Menciona Bootstrap 5 y fragmentos reutilizables de Thymeleaf para navegacion, alertas, sidebar y footer.

### 9. Base de datos
Explica que para la primera ejecucion basta crear la base:
`CREATE DATABASE saps_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;`
Luego Hibernate crea las tablas con `spring.jpa.hibernate.ddl-auto=update`. Los scripts de la carpeta `database` quedan como respaldo y datos de apoyo.

### 10. Configuracion y ejecucion
Incluye los pasos:
abrir XAMPP, activar Apache y MySQL, crear `saps_db`, abrir el proyecto Maven en NetBeans, ejecutar `SapsApplication.java` y abrir `http://localhost:8080`.
Menciona que NetBeans puede mostrar la pestaña Run abierta porque Spring Boot queda ejecutando un servidor web.

### 11. Pruebas realizadas
Muestra una tabla con casos aprobados:
login administrador, login docente, login estudiante, dashboard, tablas MySQL visibles, listados de cursos, estudiantes, grupos, proyectos, entregables, observaciones, rubricas, criterios y reportes.

### 12. Guion de demostracion
Incluye una ruta breve para exponer:
presentar S.A.P.S, explicar problema, mostrar arquitectura, entidades, login, dashboard, CRUDs, registrar proyecto, entregable y observacion, explicar rubrica y mostrar reportes.

### 13. Resultados obtenidos
Destaca trazabilidad, organizacion del seguimiento, centralizacion de evaluaciones, claridad del codigo y documentacion lista para entrega.

### 14. Conclusiones y mejoras futuras
Concluye que el sistema cumple el alcance principal. Sugiere mejoras futuras: exportacion PDF/Excel, carga de archivos, filtros avanzados, graficos de avance y notificaciones.

## Reglas de redaccion

- Escribe en español claro y formal.
- No menciones inteligencia artificial, Codex ni generadores.
- Evita frases genericas como "innovador" si no explicas el valor.
- Usa titulos tipo conclusion, por ejemplo: "La arquitectura separa responsabilidades por capas".
- Incluye diagramas simples y tablas solo donde ayuden a explicar.
- Mantén cada diapositiva con poco texto y una idea principal.

