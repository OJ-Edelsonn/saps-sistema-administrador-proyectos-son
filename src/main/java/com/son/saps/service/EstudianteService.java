package com.son.saps.service;

            import com.son.saps.model.Estudiante;
import java.util.List;

            public interface EstudianteService extends CrudService<Estudiante> {
                List<Estudiante> buscar(String texto);
            }
