package com.son.saps.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T> {
  List<T> listarTodos();

  Optional<T> buscarPorId(Long id);

  T guardar(T entity);

  void eliminarPorId(Long id);
}
