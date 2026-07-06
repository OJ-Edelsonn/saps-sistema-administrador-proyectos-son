package com.son.saps.repository;

import com.son.saps.model.Observacion;
import com.son.saps.model.enums.EstadoObservacion;
import com.son.saps.model.enums.NivelObservacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObservacionRepository extends JpaRepository<Observacion, Long> {

  List<Observacion> findByComentarioContainingIgnoreCase(String comentario);

  long countByNivelAndEstado(NivelObservacion nivel, EstadoObservacion estado);

  List<Observacion> findTop5ByEstadoOrderByFechaObservacionDesc(EstadoObservacion estado);
}
