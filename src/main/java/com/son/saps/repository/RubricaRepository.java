package com.son.saps.repository;

            import com.son.saps.model.Rubrica;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

            @Repository
            public interface RubricaRepository extends JpaRepository<Rubrica, Long> {

List<Rubrica> findByNombreContainingIgnoreCase(String nombre);
            }
