package com.son.saps.repository;

            import com.son.saps.model.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

            @Repository
            public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

Optional<Usuario> findByUsername(String username);
boolean existsByUsername(String username);
List<Usuario> findByUsernameContainingIgnoreCaseOrNombreCompletoContainingIgnoreCase(String username, String nombreCompleto);
            }
