package com.son.saps.service;

            import com.son.saps.model.Usuario;
import java.util.List;

            public interface UsuarioService extends CrudService<Usuario> {
                List<Usuario> buscar(String texto);
            }
