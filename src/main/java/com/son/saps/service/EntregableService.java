package com.son.saps.service;

import com.son.saps.model.Entregable;
import java.util.List;

public interface EntregableService extends CrudService<Entregable> {
  List<Entregable> buscar(String texto);
}
