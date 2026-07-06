package com.son.saps.repository;

import com.son.saps.model.Curso;
import com.son.saps.model.enums.EstadoGeneral;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

  boolean existsByCodigo(String codigo);

  List<Curso> findByNombreContainingIgnoreCaseOrCodigoContainingIgnoreCase(
      String nombre, String codigo);

  long countByEstado(EstadoGeneral estado);
}
