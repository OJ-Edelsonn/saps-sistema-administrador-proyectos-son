package com.son.saps.service;

import com.son.saps.model.DetalleCalificacion;
import java.util.List;

public interface DetalleCalificacionService extends CrudService<DetalleCalificacion> {
  List<DetalleCalificacion> buscar(String texto);
}
