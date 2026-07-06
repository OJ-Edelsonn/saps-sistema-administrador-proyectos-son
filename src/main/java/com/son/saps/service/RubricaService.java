package com.son.saps.service;

import com.son.saps.model.Rubrica;
import java.util.List;

public interface RubricaService extends CrudService<Rubrica> {
  List<Rubrica> buscar(String texto);
}
