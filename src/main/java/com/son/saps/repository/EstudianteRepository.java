package com.son.saps.repository;

import com.son.saps.model.Estudiante;
import com.son.saps.model.enums.EstadoGeneral;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

  boolean existsByCodigoUniversitario(String codigoUniversitario);

  List<Estudiante>
      findByNombresContainingIgnoreCaseOrApellidosContainingIgnoreCaseOrCodigoUniversitarioContainingIgnoreCase(
          String nombres, String apellidos, String codigoUniversitario);

  long countByEstado(EstadoGeneral estado);
}
