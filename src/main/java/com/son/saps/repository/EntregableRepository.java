package com.son.saps.repository;

import com.son.saps.model.Entregable;
import com.son.saps.model.enums.EstadoEntregable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregableRepository extends JpaRepository<Entregable, Long> {

  List<Entregable> findByNombreContainingIgnoreCase(String nombre);

  long countByEstado(EstadoEntregable estado);

  List<Entregable> findTop5ByEstadoOrderByFechaLimiteAsc(EstadoEntregable estado);
}
