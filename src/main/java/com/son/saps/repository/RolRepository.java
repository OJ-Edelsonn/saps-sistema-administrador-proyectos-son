package com.son.saps.repository;

            import com.son.saps.model.Rol;
import com.son.saps.model.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

            @Repository
            public interface RolRepository extends JpaRepository<Rol, Long> {

Optional<Rol> findByNombre(RolNombre nombre);
boolean existsByNombre(RolNombre nombre);
            }
