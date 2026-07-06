package com.son.saps.service;

import com.son.saps.model.Rol;
import java.util.List;

public interface RolService extends CrudService<Rol> {
  List<Rol> buscar(String texto);
}
