package com.son.saps.repository;

            import com.son.saps.model.Grupo;
import com.son.saps.model.enums.EstadoGeneral;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

            @Repository
            public interface GrupoRepository extends JpaRepository<Grupo, Long> {

List<Grupo> findByNombreContainingIgnoreCaseOrCodigoGrupoContainingIgnoreCase(String nombre, String codigoGrupo);
long countByEstado(EstadoGeneral estado);
            }
