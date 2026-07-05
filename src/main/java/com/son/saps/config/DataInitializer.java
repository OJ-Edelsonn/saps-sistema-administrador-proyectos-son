package com.son.saps.config;

import com.son.saps.model.Calificacion;
import com.son.saps.model.CriterioEvaluacion;
import com.son.saps.model.Curso;
import com.son.saps.model.Docente;
import com.son.saps.model.Entregable;
import com.son.saps.model.Estudiante;
import com.son.saps.model.Grupo;
import com.son.saps.model.Observacion;
import com.son.saps.model.Proyecto;
import com.son.saps.model.Rol;
import com.son.saps.model.Rubrica;
import com.son.saps.model.Usuario;
import com.son.saps.model.enums.EstadoEntregable;
import com.son.saps.model.enums.EstadoGeneral;
import com.son.saps.model.enums.EstadoObservacion;
import com.son.saps.model.enums.EstadoProyecto;
import com.son.saps.model.enums.NivelObservacion;
import com.son.saps.model.enums.RolNombre;
import com.son.saps.model.enums.TipoEntregable;
import com.son.saps.repository.CalificacionRepository;
import com.son.saps.repository.CriterioEvaluacionRepository;
import com.son.saps.repository.CursoRepository;
import com.son.saps.repository.DocenteRepository;
import com.son.saps.repository.EntregableRepository;
import com.son.saps.repository.EstudianteRepository;
import com.son.saps.repository.GrupoRepository;
import com.son.saps.repository.ObservacionRepository;
import com.son.saps.repository.ProyectoRepository;
import com.son.saps.repository.RolRepository;
import com.son.saps.repository.RubricaRepository;
import com.son.saps.repository.UsuarioRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner seedData(RolRepository rolRepository, UsuarioRepository usuarioRepository,
            CursoRepository cursoRepository, DocenteRepository docenteRepository,
            EstudianteRepository estudianteRepository, GrupoRepository grupoRepository,
            ProyectoRepository proyectoRepository, EntregableRepository entregableRepository,
            ObservacionRepository observacionRepository, RubricaRepository rubricaRepository,
            CriterioEvaluacionRepository criterioRepository, CalificacionRepository calificacionRepository,
            PasswordEncoder passwordEncoder) {
        return args -> {
            Rol adminRol = rolRepository.findByNombre(RolNombre.ADMIN)
                    .orElseGet(() -> rolRepository.save(rol(RolNombre.ADMIN, "Administrador del sistema")));
            Rol docenteRol = rolRepository.findByNombre(RolNombre.DOCENTE)
                    .orElseGet(() -> rolRepository.save(rol(RolNombre.DOCENTE, "Docente asesor y evaluador")));
            Rol estudianteRol = rolRepository.findByNombre(RolNombre.ESTUDIANTE)
                    .orElseGet(() -> rolRepository.save(rol(RolNombre.ESTUDIANTE, "Estudiante integrante de grupo")));

            if (usuarioRepository.count() == 0) {
                usuarioRepository.save(usuario("admin", passwordEncoder.encode("admin123"), "Administrador Son", "admin@saps.edu.pe", adminRol));
                usuarioRepository.save(usuario("docente", passwordEncoder.encode("docente123"), "Docente Demo", "docente@saps.edu.pe", docenteRol));
                usuarioRepository.save(usuario("estudiante", passwordEncoder.encode("estudiante123"), "Estudiante Demo", "estudiante@saps.edu.pe", estudianteRol));
            }

            if (cursoRepository.count() > 0) {
                return;
            }

            List<Curso> cursos = new ArrayList<>();
            cursos.add(curso("LP2", "Lenguaje de Programacion 2", 4, 4));
            cursos.add(curso("IS2", "Ingenieria de Software 2", 6, 4));
            cursos.add(curso("BD2", "Base de Datos 2", 5, 4));
            cursos.add(curso("DAW", "Desarrollo de Aplicaciones Web", 5, 3));
            cursos.add(curso("GP1", "Gestion de Proyectos", 7, 3));
            cursoRepository.saveAll(cursos);

            List<Docente> docentes = new ArrayList<>();
            docentes.add(docente("Ana", "Ramirez Soto", "ana.ramirez@saps.edu.pe", "Arquitectura Java"));
            docentes.add(docente("Luis", "Torres Vega", "luis.torres@saps.edu.pe", "Gestion agil"));
            docentes.add(docente("Carla", "Mendoza Ruiz", "carla.mendoza@saps.edu.pe", "Base de datos"));
            docentes.add(docente("Miguel", "Paredes Leon", "miguel.paredes@saps.edu.pe", "UX y web"));
            docentes.add(docente("Sofia", "Castillo Rios", "sofia.castillo@saps.edu.pe", "Calidad de software"));
            docenteRepository.saveAll(docentes);

            List<Grupo> grupos = new ArrayList<>();
            for (int i = 1; i <= 6; i++) {
                Grupo grupo = new Grupo();
                grupo.setNombre("Equipo Integrador " + i);
                grupo.setCodigoGrupo("SAPSG-" + String.format("%02d", i));
                grupo.setCurso(cursos.get((i - 1) % cursos.size()));
                grupo.setDocenteAsesor(docentes.get((i - 1) % docentes.size()));
                grupo.setEstado(EstadoGeneral.ACTIVO);
                grupos.add(grupo);
            }
            grupoRepository.saveAll(grupos);

            for (int i = 1; i <= 20; i++) {
                Estudiante estudiante = new Estudiante();
                estudiante.setCodigoUniversitario("2026" + String.format("%04d", i));
                estudiante.setNombres("Estudiante " + i);
                estudiante.setApellidos("SAPS Demo");
                estudiante.setCorreo("estudiante" + i + "@saps.edu.pe");
                estudiante.setCarrera("Ingenieria de Sistemas");
                estudiante.setCiclo((i % 8) + 1);
                estudiante.setEstado(EstadoGeneral.ACTIVO);
                estudiante.setGrupo(grupos.get((i - 1) % grupos.size()));
                estudianteRepository.save(estudiante);
            }

            List<Proyecto> proyectos = new ArrayList<>();
            for (int i = 1; i <= 6; i++) {
                Proyecto proyecto = new Proyecto();
                proyecto.setTitulo("Plataforma academica integradora " + i);
                proyecto.setDescripcion("Sistema web para gestionar procesos academicos integradores.");
                proyecto.setProblemaIdentificado("Seguimiento manual de entregables y evaluaciones.");
                proyecto.setObjetivoGeneral("Automatizar la administracion de proyectos integradores.");
                proyecto.setObjetivosEspecificos("Registrar proyectos; controlar entregables; evaluar con rubricas; emitir reportes.");
                proyecto.setLineaTematica(i % 2 == 0 ? "Transformacion digital" : "Gestion academica");
                proyecto.setCurso(grupos.get(i - 1).getCurso());
                proyecto.setGrupo(grupos.get(i - 1));
                proyecto.setDocenteAsesor(grupos.get(i - 1).getDocenteAsesor());
                proyecto.setFechaInicio(LocalDate.now().minusDays(40 - i));
                proyecto.setFechaEstimadaEntrega(LocalDate.now().plusDays(20 + i));
                proyecto.setEstado(i % 3 == 0 ? EstadoProyecto.OBSERVADO : EstadoProyecto.EN_DESARROLLO);
                proyectos.add(proyecto);
            }
            proyectoRepository.saveAll(proyectos);

            for (int i = 1; i <= 20; i++) {
                Entregable entregable = new Entregable();
                entregable.setProyecto(proyectos.get((i - 1) % proyectos.size()));
                entregable.setNombre("Entregable " + i);
                entregable.setTipo(TipoEntregable.values()[(i - 1) % TipoEntregable.values().length]);
                entregable.setDescripcion("Documento o evidencia del avance " + i + ".");
                entregable.setFechaLimite(LocalDate.now().plusDays(i));
                entregable.setFechaEntrega(i % 4 == 0 ? LocalDate.now().minusDays(1) : null);
                entregable.setUrlArchivo("https://github.com/OJ-Edelsonn/saps-sistema-administrador-proyectos-son");
                entregable.setEstado(i % 4 == 0 ? EstadoEntregable.ENTREGADO : EstadoEntregable.PENDIENTE);
                entregableRepository.save(entregable);
            }

            List<Entregable> entregables = entregableRepository.findAll();
            for (int i = 1; i <= 10; i++) {
                Observacion observacion = new Observacion();
                observacion.setProyecto(proyectos.get((i - 1) % proyectos.size()));
                observacion.setEntregable(entregables.get((i - 1) % entregables.size()));
                observacion.setDocente(docentes.get((i - 1) % docentes.size()));
                observacion.setComentario("Corregir detalle tecnico observado en la entrega " + i + ".");
                observacion.setNivel(i % 3 == 0 ? NivelObservacion.CRITICA : NivelObservacion.MEDIA);
                observacion.setFechaObservacion(LocalDate.now().minusDays(i));
                observacion.setEstado(EstadoObservacion.PENDIENTE);
                observacionRepository.save(observacion);
            }

            String[] criterios = {"Analisis del problema", "Diseno de la solucion", "Implementacion MVC", "Uso de Thymeleaf",
                "Uso de JPA", "Calidad de base de datos", "Documentacion tecnica", "Sustentacion"};
            List<Rubrica> rubricas = new ArrayList<>();
            for (int r = 1; r <= 3; r++) {
                Rubrica rubrica = new Rubrica();
                rubrica.setNombre("Rubrica integradora " + r);
                rubrica.setCurso(cursos.get(r - 1));
                rubrica.setDescripcion("Rubrica para evaluar proyectos web con Spring Boot.");
                rubrica.setPuntajeMaximo(BigDecimal.valueOf(20));
                rubrica.setEstado(EstadoGeneral.ACTIVO);
                rubricas.add(rubricaRepository.save(rubrica));
                for (int c = 0; c < criterios.length; c++) {
                    CriterioEvaluacion criterio = new CriterioEvaluacion();
                    criterio.setRubrica(rubrica);
                    criterio.setNombre(criterios[c]);
                    criterio.setDescripcion("Evalua " + criterios[c].toLowerCase() + ".");
                    criterio.setPuntajeMaximo(BigDecimal.valueOf(20));
                    criterio.setPesoPorcentual(BigDecimal.valueOf(c < 4 ? 12 : 13));
                    criterio.setOrden(c + 1);
                    criterioRepository.save(criterio);
                }
            }

            for (int i = 1; i <= 6; i++) {
                Calificacion calificacion = new Calificacion();
                calificacion.setProyecto(proyectos.get(i - 1));
                calificacion.setRubrica(rubricas.get((i - 1) % rubricas.size()));
                calificacion.setDocenteEvaluador(docentes.get((i - 1) % docentes.size()));
                calificacion.setFechaEvaluacion(LocalDate.now().minusDays(i));
                calificacion.setNotaFinal(BigDecimal.valueOf(13 + i));
                calificacion.setComentarioGeneral("Evaluacion inicial registrada para sustentar el avance del proyecto.");
                calificacion.setEstado(i >= 4 ? EstadoProyecto.APROBADO : EstadoProyecto.EN_DESARROLLO);
                calificacionRepository.save(calificacion);
            }
        };
    }

    private Rol rol(RolNombre nombre, String descripcion) {
        Rol rol = new Rol();
        rol.setNombre(nombre);
        rol.setDescripcion(descripcion);
        return rol;
    }

    private Usuario usuario(String username, String password, String nombre, String correo, Rol rol) {
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setPassword(password);
        usuario.setNombreCompleto(nombre);
        usuario.setCorreo(correo);
        usuario.setRol(rol);
        usuario.setEstado(EstadoGeneral.ACTIVO);
        return usuario;
    }

    private Curso curso(String codigo, String nombre, int ciclo, int creditos) {
        Curso curso = new Curso();
        curso.setCodigo(codigo);
        curso.setNombre(nombre);
        curso.setCiclo(ciclo);
        curso.setCreditos(creditos);
        curso.setDescripcion("Curso orientado a proyectos integradores.");
        curso.setEstado(EstadoGeneral.ACTIVO);
        return curso;
    }

    private Docente docente(String nombres, String apellidos, String correo, String especialidad) {
        Docente docente = new Docente();
        docente.setNombres(nombres);
        docente.setApellidos(apellidos);
        docente.setCorreo(correo);
        docente.setEspecialidad(especialidad);
        docente.setTelefono("999-000-000");
        docente.setEstado(EstadoGeneral.ACTIVO);
        return docente;
    }
}
