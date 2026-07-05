package com.son.saps.service;

            import com.son.saps.model.Curso;
import java.util.List;

            public interface CursoService extends CrudService<Curso> {
                List<Curso> buscar(String texto);
            }
