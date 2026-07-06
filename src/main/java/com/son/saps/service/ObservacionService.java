package com.son.saps.service;

import com.son.saps.model.Observacion;
import java.util.List;

public interface ObservacionService extends CrudService<Observacion> {
  List<Observacion> buscar(String texto);
}
