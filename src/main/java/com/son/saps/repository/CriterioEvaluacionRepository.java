package com.son.saps.repository;

import com.son.saps.model.CriterioEvaluacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriterioEvaluacionRepository extends JpaRepository<CriterioEvaluacion, Long> {

  List<CriterioEvaluacion> findByNombreContainingIgnoreCase(String nombre);

  List<CriterioEvaluacion> findByRubricaIdOrderByOrdenAsc(Long rubricaId);
}
