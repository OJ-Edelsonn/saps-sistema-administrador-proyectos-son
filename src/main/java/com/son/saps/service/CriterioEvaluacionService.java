package com.son.saps.service;

            import com.son.saps.model.CriterioEvaluacion;
import java.util.List;

            public interface CriterioEvaluacionService extends CrudService<CriterioEvaluacion> {
                List<CriterioEvaluacion> buscar(String texto);
    List<CriterioEvaluacion> listarPorRubrica(Long rubricaId);
            }
