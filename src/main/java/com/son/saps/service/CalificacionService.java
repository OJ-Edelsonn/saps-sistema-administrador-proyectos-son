package com.son.saps.service;

            import com.son.saps.model.Calificacion;
import java.math.BigDecimal;
import java.util.List;

            public interface CalificacionService extends CrudService<Calificacion> {
                List<Calificacion> buscar(String texto);
    BigDecimal calcularNotaFinal(Calificacion calificacion);
            }
