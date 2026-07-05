package com.son.saps.service;

            import com.son.saps.model.Docente;
import java.util.List;

            public interface DocenteService extends CrudService<Docente> {
                List<Docente> buscar(String texto);
            }
