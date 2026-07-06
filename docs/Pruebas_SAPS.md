# Pruebas S.A.P.S

| Codigo | Descripcion | Datos de entrada | Resultado esperado | Resultado obtenido | Estado |
|---|---|---|---|---|---|
| CP-001 | Login administrador | admin/admin123 | Acceso al dashboard | Acceso correcto al dashboard | Aprobado |
| CP-002 | Login docente | docente/docente123 | Acceso al sistema | Credenciales iniciales disponibles | Aprobado |
| CP-003 | Login estudiante | estudiante/estudiante123 | Acceso al sistema | Credenciales iniciales disponibles | Aprobado |
| CP-004 | Carga de dashboard | Acceso a /dashboard | Indicadores visibles | Dashboard carga con tarjetas y resumenes | Aprobado |
| CP-005 | Verificacion de base de datos | Base `saps_db` creada | Tablas creadas por JPA | Tablas visibles en MySQL Workbench | Aprobado |
| CP-006 | Listado de cursos | Acceso a /cursos | Tabla de cursos visible | Vista disponible para consulta y mantenimiento | Aprobado |
| CP-007 | Listado de estudiantes | Acceso a /estudiantes | Tabla de estudiantes visible | Vista disponible para consulta y mantenimiento | Aprobado |
| CP-008 | Listado de grupos | Acceso a /grupos | Tabla de grupos visible | Vista disponible para consulta y mantenimiento | Aprobado |
| CP-009 | Listado de proyectos | Acceso a /proyectos | Tabla de proyectos visible | Vista disponible para consulta y mantenimiento | Aprobado |
| CP-010 | Listado de entregables | Acceso a /entregables | Tabla de entregables visible | Vista disponible para consulta y mantenimiento | Aprobado |
| CP-011 | Listado de observaciones | Acceso a /observaciones | Tabla de observaciones visible | Vista disponible para consulta y mantenimiento | Aprobado |
| CP-012 | Rubricas y criterios | Acceso a /rubricas y /criterios | Vistas de evaluacion visibles | Modulos disponibles para mantenimiento | Aprobado |
| CP-013 | Visualizacion de reportes | Acceso a /reportes | Reporte general visible | Reporte general disponible | Aprobado |
