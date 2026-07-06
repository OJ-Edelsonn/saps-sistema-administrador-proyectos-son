package com.son.saps.repository;

import com.son.saps.model.Proyecto;
import com.son.saps.model.enums.EstadoProyecto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

  List<Proyecto> findByTituloContainingIgnoreCaseOrLineaTematicaContainingIgnoreCase(
      String titulo, String lineaTematica);

  long countByEstado(EstadoProyecto estado);

  List<Proyecto> findTop5ByOrderByIdDesc();
}
