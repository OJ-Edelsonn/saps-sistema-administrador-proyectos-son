package com.son.saps.repository;

import com.son.saps.model.DetalleCalificacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleCalificacionRepository extends JpaRepository<DetalleCalificacion, Long> {

  List<DetalleCalificacion> findByCalificacionId(Long calificacionId);
}
