package com.son.saps.service;

import com.son.saps.model.Grupo;
import java.util.List;

public interface GrupoService extends CrudService<Grupo> {
  List<Grupo> buscar(String texto);
}
