CREATE DATABASE IF NOT EXISTS saps_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE saps_db;

INSERT INTO roles (id, nombre, descripcion) VALUES
(1, 'ADMIN', 'Administrador del sistema'),
(2, 'DOCENTE', 'Docente asesor y evaluador'),
(3, 'ESTUDIANTE', 'Estudiante integrante de grupo')
ON DUPLICATE KEY UPDATE descripcion = VALUES(descripcion);

INSERT INTO usuarios (id, username, password, nombre_completo, correo, rol_id, estado, fecha_creacion) VALUES
(1, 'admin', '{noop}admin123', 'Administrador Son', 'admin@saps.edu.pe', 1, 'ACTIVO', NOW()),
(2, 'docente', '{noop}docente123', 'Docente Demo', 'docente@saps.edu.pe', 2, 'ACTIVO', NOW()),
(3, 'estudiante', '{noop}estudiante123', 'Estudiante Demo', 'estudiante@saps.edu.pe', 3, 'ACTIVO', NOW())
ON DUPLICATE KEY UPDATE correo = VALUES(correo);

INSERT INTO cursos (codigo, nombre, ciclo, creditos, descripcion, estado) VALUES
('LP2', 'Lenguaje de Programacion 2', 4, 4, 'Curso de aplicaciones web con Spring Boot.', 'ACTIVO'),
('IS2', 'Ingenieria de Software 2', 6, 4, 'Curso de analisis, diseno y arquitectura.', 'ACTIVO'),
('BD2', 'Base de Datos 2', 5, 4, 'Curso de modelado relacional y SQL.', 'ACTIVO'),
('DAW', 'Desarrollo de Aplicaciones Web', 5, 3, 'Curso de frontend y backend web.', 'ACTIVO'),
('GP1', 'Gestion de Proyectos', 7, 3, 'Curso de planificacion y seguimiento.', 'ACTIVO')
ON DUPLICATE KEY UPDATE nombre = VALUES(nombre);

INSERT INTO docentes (nombres, apellidos, correo, especialidad, telefono, estado) VALUES
('Ana', 'Ramirez Soto', 'ana.ramirez@saps.edu.pe', 'Arquitectura Java', '999-000-001', 'ACTIVO'),
('Luis', 'Torres Vega', 'luis.torres@saps.edu.pe', 'Gestion agil', '999-000-002', 'ACTIVO'),
('Carla', 'Mendoza Ruiz', 'carla.mendoza@saps.edu.pe', 'Base de datos', '999-000-003', 'ACTIVO'),
('Miguel', 'Paredes Leon', 'miguel.paredes@saps.edu.pe', 'UX y web', '999-000-004', 'ACTIVO'),
('Sofia', 'Castillo Rios', 'sofia.castillo@saps.edu.pe', 'Calidad de software', '999-000-005', 'ACTIVO');

INSERT INTO grupos (nombre, codigo_grupo, curso_id, docente_id, estado, fecha_creacion) VALUES
('Equipo Integrador 1', 'SAPSG-01', 1, 1, 'ACTIVO', NOW()),
('Equipo Integrador 2', 'SAPSG-02', 2, 2, 'ACTIVO', NOW()),
('Equipo Integrador 3', 'SAPSG-03', 3, 3, 'ACTIVO', NOW()),
('Equipo Integrador 4', 'SAPSG-04', 4, 4, 'ACTIVO', NOW()),
('Equipo Integrador 5', 'SAPSG-05', 5, 5, 'ACTIVO', NOW()),
('Equipo Integrador 6', 'SAPSG-06', 1, 1, 'ACTIVO', NOW())
ON DUPLICATE KEY UPDATE estado = VALUES(estado);

INSERT INTO estudiantes (codigo_universitario, nombres, apellidos, correo, carrera, ciclo, estado, grupo_id)
SELECT CONCAT('2026', LPAD(n, 4, '0')), CONCAT('Estudiante ', n), 'SAPS Demo',
       CONCAT('estudiante', n, '@saps.edu.pe'), 'Ingenieria de Sistemas', 4, 'ACTIVO', ((n - 1) MOD 6) + 1
FROM (
    SELECT 1 n UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9 UNION SELECT 10
    UNION SELECT 11 UNION SELECT 12 UNION SELECT 13 UNION SELECT 14 UNION SELECT 15 UNION SELECT 16 UNION SELECT 17 UNION SELECT 18 UNION SELECT 19 UNION SELECT 20
) nums
ON DUPLICATE KEY UPDATE correo = VALUES(correo);

INSERT INTO proyectos (titulo, descripcion, problema_identificado, objetivo_general, objetivos_especificos, linea_tematica, curso_id, grupo_id, docente_id, fecha_inicio, fecha_estimada_entrega, estado) VALUES
('Plataforma academica integradora 1', 'Sistema web academico.', 'Seguimiento manual.', 'Automatizar gestion.', 'Registrar; controlar; evaluar.', 'Gestion academica', 1, 1, 1, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 30 DAY), 'EN_DESARROLLO'),
('Plataforma academica integradora 2', 'Sistema web academico.', 'Seguimiento manual.', 'Automatizar gestion.', 'Registrar; controlar; evaluar.', 'Transformacion digital', 2, 2, 2, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 31 DAY), 'EN_DESARROLLO'),
('Plataforma academica integradora 3', 'Sistema web academico.', 'Seguimiento manual.', 'Automatizar gestion.', 'Registrar; controlar; evaluar.', 'Gestion academica', 3, 3, 3, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 32 DAY), 'OBSERVADO'),
('Plataforma academica integradora 4', 'Sistema web academico.', 'Seguimiento manual.', 'Automatizar gestion.', 'Registrar; controlar; evaluar.', 'Transformacion digital', 4, 4, 4, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 33 DAY), 'APROBADO'),
('Plataforma academica integradora 5', 'Sistema web academico.', 'Seguimiento manual.', 'Automatizar gestion.', 'Registrar; controlar; evaluar.', 'Gestion academica', 5, 5, 5, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 34 DAY), 'EN_DESARROLLO'),
('Plataforma academica integradora 6', 'Sistema web academico.', 'Seguimiento manual.', 'Automatizar gestion.', 'Registrar; controlar; evaluar.', 'Transformacion digital', 1, 6, 1, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 35 DAY), 'OBSERVADO');
