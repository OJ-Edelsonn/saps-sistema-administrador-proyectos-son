package com.son.saps.repository;

            import com.son.saps.model.Docente;
import com.son.saps.model.enums.EstadoGeneral;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

            @Repository
            public interface DocenteRepository extends JpaRepository<Docente, Long> {

List<Docente> findByNombresContainingIgnoreCaseOrApellidosContainingIgnoreCaseOrCorreoContainingIgnoreCase(String nombres, String apellidos, String correo);
long countByEstado(EstadoGeneral estado);
            }
