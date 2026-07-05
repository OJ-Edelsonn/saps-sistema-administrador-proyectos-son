package com.son.saps.service.impl;

            import com.son.saps.model.CriterioEvaluacion;
            import com.son.saps.repository.CriterioEvaluacionRepository;
            import com.son.saps.service.CriterioEvaluacionService;
            import java.util.List;
            import org.springframework.stereotype.Service;
            import org.springframework.util.StringUtils;

            @Service
            public class CriterioEvaluacionServiceImpl extends GenericCrudServiceImpl<CriterioEvaluacion> implements CriterioEvaluacionService {

                private final CriterioEvaluacionRepository repository;

                public CriterioEvaluacionServiceImpl(CriterioEvaluacionRepository repository) {
                    super(repository);
                    this.repository = repository;
                }

                @Override
                public List<CriterioEvaluacion> buscar(String texto) {
                    return StringUtils.hasText(texto) ? repository.findByNombreContainingIgnoreCase(texto) : repository.findAll();
                }

                @Override
public List<CriterioEvaluacion> listarPorRubrica(Long rubricaId) {
    return repository.findByRubricaIdOrderByOrdenAsc(rubricaId);
}
            }
