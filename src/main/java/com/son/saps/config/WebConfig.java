package com.son.saps.config;

import com.son.saps.model.Calificacion;
import com.son.saps.model.CriterioEvaluacion;
import com.son.saps.model.Curso;
import com.son.saps.model.Docente;
import com.son.saps.model.Entregable;
import com.son.saps.model.Estudiante;
import com.son.saps.model.Grupo;
import com.son.saps.model.Proyecto;
import com.son.saps.model.Rol;
import com.son.saps.model.Rubrica;
import com.son.saps.repository.CalificacionRepository;
import com.son.saps.repository.CriterioEvaluacionRepository;
import com.son.saps.repository.CursoRepository;
import com.son.saps.repository.DocenteRepository;
import com.son.saps.repository.EntregableRepository;
import com.son.saps.repository.EstudianteRepository;
import com.son.saps.repository.GrupoRepository;
import com.son.saps.repository.ProyectoRepository;
import com.son.saps.repository.RolRepository;
import com.son.saps.repository.RubricaRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final RolRepository rolRepository;
    private final CursoRepository cursoRepository;
    private final DocenteRepository docenteRepository;
    private final EstudianteRepository estudianteRepository;
    private final GrupoRepository grupoRepository;
    private final ProyectoRepository proyectoRepository;
    private final EntregableRepository entregableRepository;
    private final RubricaRepository rubricaRepository;
    private final CriterioEvaluacionRepository criterioRepository;
    private final CalificacionRepository calificacionRepository;

    public WebConfig(RolRepository rolRepository, CursoRepository cursoRepository,
            DocenteRepository docenteRepository, EstudianteRepository estudianteRepository,
            GrupoRepository grupoRepository, ProyectoRepository proyectoRepository,
            EntregableRepository entregableRepository, RubricaRepository rubricaRepository,
            CriterioEvaluacionRepository criterioRepository, CalificacionRepository calificacionRepository) {
        this.rolRepository = rolRepository;
        this.cursoRepository = cursoRepository;
        this.docenteRepository = docenteRepository;
        this.estudianteRepository = estudianteRepository;
        this.grupoRepository = grupoRepository;
        this.proyectoRepository = proyectoRepository;
        this.entregableRepository = entregableRepository;
        this.rubricaRepository = rubricaRepository;
        this.criterioRepository = criterioRepository;
        this.calificacionRepository = calificacionRepository;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(String.class, Rol.class, source -> parseId(source) == null ? null : rolRepository.findById(parseId(source)).orElse(null));
        registry.addConverter(Rol.class, String.class, rol -> rol == null || rol.getId() == null ? "" : rol.getId().toString());
        registry.addConverter(String.class, Curso.class, source -> parseId(source) == null ? null : cursoRepository.findById(parseId(source)).orElse(null));
        registry.addConverter(Curso.class, String.class, curso -> curso == null || curso.getId() == null ? "" : curso.getId().toString());
        registry.addConverter(String.class, Docente.class, source -> parseId(source) == null ? null : docenteRepository.findById(parseId(source)).orElse(null));
        registry.addConverter(Docente.class, String.class, docente -> docente == null || docente.getId() == null ? "" : docente.getId().toString());
        registry.addConverter(String.class, Estudiante.class, source -> parseId(source) == null ? null : estudianteRepository.findById(parseId(source)).orElse(null));
        registry.addConverter(Estudiante.class, String.class, estudiante -> estudiante == null || estudiante.getId() == null ? "" : estudiante.getId().toString());
        registry.addConverter(String.class, Grupo.class, source -> parseId(source) == null ? null : grupoRepository.findById(parseId(source)).orElse(null));
        registry.addConverter(Grupo.class, String.class, grupo -> grupo == null || grupo.getId() == null ? "" : grupo.getId().toString());
        registry.addConverter(String.class, Proyecto.class, source -> parseId(source) == null ? null : proyectoRepository.findById(parseId(source)).orElse(null));
        registry.addConverter(Proyecto.class, String.class, proyecto -> proyecto == null || proyecto.getId() == null ? "" : proyecto.getId().toString());
        registry.addConverter(String.class, Entregable.class, source -> parseId(source) == null ? null : entregableRepository.findById(parseId(source)).orElse(null));
        registry.addConverter(Entregable.class, String.class, entregable -> entregable == null || entregable.getId() == null ? "" : entregable.getId().toString());
        registry.addConverter(String.class, Rubrica.class, source -> parseId(source) == null ? null : rubricaRepository.findById(parseId(source)).orElse(null));
        registry.addConverter(Rubrica.class, String.class, rubrica -> rubrica == null || rubrica.getId() == null ? "" : rubrica.getId().toString());
        registry.addConverter(String.class, CriterioEvaluacion.class, source -> parseId(source) == null ? null : criterioRepository.findById(parseId(source)).orElse(null));
        registry.addConverter(CriterioEvaluacion.class, String.class, criterio -> criterio == null || criterio.getId() == null ? "" : criterio.getId().toString());
        registry.addConverter(String.class, Calificacion.class, source -> parseId(source) == null ? null : calificacionRepository.findById(parseId(source)).orElse(null));
        registry.addConverter(Calificacion.class, String.class, calificacion -> calificacion == null || calificacion.getId() == null ? "" : calificacion.getId().toString());
    }

    private Long parseId(String source) {
        return source == null || source.isBlank() ? null : Long.valueOf(source);
    }
}
