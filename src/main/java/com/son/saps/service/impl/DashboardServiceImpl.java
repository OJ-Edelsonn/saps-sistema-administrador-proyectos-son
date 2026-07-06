package com.son.saps.service.impl;

import com.son.saps.model.enums.EstadoEntregable;
import com.son.saps.model.enums.EstadoObservacion;
import com.son.saps.model.enums.EstadoProyecto;
import com.son.saps.model.enums.NivelObservacion;
import com.son.saps.repository.CalificacionRepository;
import com.son.saps.repository.CursoRepository;
import com.son.saps.repository.DocenteRepository;
import com.son.saps.repository.EntregableRepository;
import com.son.saps.repository.EstudianteRepository;
import com.son.saps.repository.GrupoRepository;
import com.son.saps.repository.ObservacionRepository;
import com.son.saps.repository.ProyectoRepository;
import com.son.saps.service.DashboardService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService {

  private final CursoRepository cursoRepository;
  private final DocenteRepository docenteRepository;
  private final EstudianteRepository estudianteRepository;
  private final GrupoRepository grupoRepository;
  private final ProyectoRepository proyectoRepository;
  private final EntregableRepository entregableRepository;
  private final ObservacionRepository observacionRepository;
  private final CalificacionRepository calificacionRepository;

  public DashboardServiceImpl(
      CursoRepository cursoRepository,
      DocenteRepository docenteRepository,
      EstudianteRepository estudianteRepository,
      GrupoRepository grupoRepository,
      ProyectoRepository proyectoRepository,
      EntregableRepository entregableRepository,
      ObservacionRepository observacionRepository,
      CalificacionRepository calificacionRepository) {
    this.cursoRepository = cursoRepository;
    this.docenteRepository = docenteRepository;
    this.estudianteRepository = estudianteRepository;
    this.grupoRepository = grupoRepository;
    this.proyectoRepository = proyectoRepository;
    this.entregableRepository = entregableRepository;
    this.observacionRepository = observacionRepository;
    this.calificacionRepository = calificacionRepository;
  }

  @Override
  public Map<String, Object> obtenerResumen() {
    Map<String, Object> resumen = new LinkedHashMap<>();
    resumen.put("totalCursos", cursoRepository.count());
    resumen.put("totalDocentes", docenteRepository.count());
    resumen.put("totalEstudiantes", estudianteRepository.count());
    resumen.put("totalGrupos", grupoRepository.count());
    resumen.put("totalProyectos", proyectoRepository.count());
    resumen.put(
        "proyectosEnDesarrollo", proyectoRepository.countByEstado(EstadoProyecto.EN_DESARROLLO));
    resumen.put("proyectosObservados", proyectoRepository.countByEstado(EstadoProyecto.OBSERVADO));
    resumen.put("proyectosAprobados", proyectoRepository.countByEstado(EstadoProyecto.APROBADO));
    resumen.put(
        "entregablesPendientes", entregableRepository.countByEstado(EstadoEntregable.PENDIENTE));
    resumen.put(
        "observacionesCriticas",
        observacionRepository.countByNivelAndEstado(
            NivelObservacion.CRITICA, EstadoObservacion.PENDIENTE));
    BigDecimal promedio =
        calificacionRepository.findAll().stream()
            .map(c -> c.getNotaFinal() == null ? BigDecimal.ZERO : c.getNotaFinal())
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    long totalCalificaciones = calificacionRepository.count();
    resumen.put(
        "promedioGeneral",
        totalCalificaciones == 0
            ? BigDecimal.ZERO
            : promedio.divide(BigDecimal.valueOf(totalCalificaciones), 2, RoundingMode.HALF_UP));
    resumen.put("ultimosProyectos", proyectoRepository.findTop5ByOrderByIdDesc());
    resumen.put(
        "proximosEntregables",
        entregableRepository.findTop5ByEstadoOrderByFechaLimiteAsc(EstadoEntregable.PENDIENTE));
    resumen.put(
        "observacionesPendientes",
        observacionRepository.findTop5ByEstadoOrderByFechaObservacionDesc(
            EstadoObservacion.PENDIENTE));
    resumen.put("mejoresProyectos", calificacionRepository.findTop5ByOrderByNotaFinalDesc());
    return resumen;
  }
}
