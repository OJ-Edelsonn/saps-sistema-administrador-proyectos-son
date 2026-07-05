package com.son.saps.service.impl;

import com.son.saps.model.Usuario;
import com.son.saps.repository.UsuarioRepository;
import com.son.saps.service.UsuarioService;
import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UsuarioServiceImpl extends GenericCrudServiceImpl<Usuario> implements UsuarioService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UsuarioRepository repository, PasswordEncoder passwordEncoder) {
        super(repository);
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Usuario> buscar(String texto) {
        return StringUtils.hasText(texto)
                ? repository.findByUsernameContainingIgnoreCaseOrNombreCompletoContainingIgnoreCase(texto, texto)
                : repository.findAll();
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        if (StringUtils.hasText(usuario.getPassword()) && !usuario.getPassword().startsWith("{")) {
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        }
        return repository.save(usuario);
    }
}
