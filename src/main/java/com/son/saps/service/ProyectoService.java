package com.son.saps.service;

            import com.son.saps.model.Proyecto;
import java.util.List;

            public interface ProyectoService extends CrudService<Proyecto> {
                List<Proyecto> buscar(String texto);
            }
