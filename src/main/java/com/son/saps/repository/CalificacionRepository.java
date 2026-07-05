package com.son.saps.repository;

            import com.son.saps.model.Calificacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

            @Repository
            public interface CalificacionRepository extends JpaRepository<Calificacion, Long> {

List<Calificacion> findByProyectoTituloContainingIgnoreCase(String titulo);
List<Calificacion> findTop5ByOrderByNotaFinalDesc();
            }
