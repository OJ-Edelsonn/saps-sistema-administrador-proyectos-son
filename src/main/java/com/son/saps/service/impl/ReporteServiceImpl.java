package com.son.saps.service.impl;

import com.son.saps.repository.CalificacionRepository;
import com.son.saps.repository.CursoRepository;
import com.son.saps.repository.EntregableRepository;
import com.son.saps.repository.GrupoRepository;
import com.son.saps.repository.ObservacionRepository;
import com.son.saps.repository.ProyectoRepository;
import com.son.saps.service.ReporteService;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class ReporteServiceImpl implements ReporteService {

    private final CursoRepository cursoRepository;
    private final GrupoRepository grupoRepository;
    private final ProyectoRepository proyectoRepository;
    private final EntregableRepository entregableRepository;
    private final ObservacionRepository observacionRepository;
    private final CalificacionRepository calificacionRepository;

    public ReporteServiceImpl(CursoRepository cursoRepository, GrupoRepository grupoRepository,
            ProyectoRepository proyectoRepository, EntregableRepository entregableRepository,
            ObservacionRepository observacionRepository, CalificacionRepository calificacionRepository) {
        this.cursoRepository = cursoRepository;
        this.grupoRepository = grupoRepository;
        this.proyectoRepository = proyectoRepository;
        this.entregableRepository = entregableRepository;
        this.observacionRepository = observacionRepository;
        this.calificacionRepository = calificacionRepository;
    }

    @Override
    public Map<String, Object> obtenerReporteGeneral() {
        Map<String, Object> reporte = new LinkedHashMap<>();
        reporte.put("cursos", cursoRepository.findAll());
        reporte.put("grupos", grupoRepository.findAll());
        reporte.put("proyectos", proyectoRepository.findAll());
        reporte.put("entregables", entregableRepository.findAll());
        reporte.put("observaciones", observacionRepository.findAll());
        reporte.put("calificaciones", calificacionRepository.findAll());
        return reporte;
    }
}
