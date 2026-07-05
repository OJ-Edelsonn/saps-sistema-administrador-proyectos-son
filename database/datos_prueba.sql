USE saps_db;

INSERT INTO entregables (proyecto_id, nombre, tipo, descripcion, fecha_limite, fecha_entrega, url_archivo, estado)
SELECT ((n - 1) MOD 6) + 1, CONCAT('Entregable adicional ', n), 'AVANCE_1',
       CONCAT('Evidencia adicional ', n), DATE_ADD(CURDATE(), INTERVAL n DAY), NULL,
       'https://github.com/OJ-Edelsonn/saps-sistema-administrador-proyectos-son', 'PENDIENTE'
FROM (
    SELECT 1 n UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9 UNION SELECT 10
    UNION SELECT 11 UNION SELECT 12 UNION SELECT 13 UNION SELECT 14 UNION SELECT 15 UNION SELECT 16 UNION SELECT 17 UNION SELECT 18 UNION SELECT 19 UNION SELECT 20
) nums;

INSERT INTO observaciones (proyecto_id, entregable_id, docente_id, comentario, nivel, fecha_observacion, estado) VALUES
(1, 1, 1, 'Mejorar descripcion del problema.', 'MEDIA', CURDATE(), 'PENDIENTE'),
(2, 2, 2, 'Agregar evidencia de pruebas.', 'CRITICA', CURDATE(), 'PENDIENTE'),
(3, 3, 3, 'Normalizar el modelo relacional.', 'MEDIA', CURDATE(), 'PENDIENTE');
