package com.son.saps.service.impl;

import com.son.saps.service.CrudService;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class GenericCrudServiceImpl<T> implements CrudService<T> {

  private final JpaRepository<T, Long> repository;

  protected GenericCrudServiceImpl(JpaRepository<T, Long> repository) {
    this.repository = repository;
  }

  @Override
  public List<T> listarTodos() {
    return repository.findAll();
  }

  @Override
  public Optional<T> buscarPorId(Long id) {
    return repository.findById(id);
  }

  @Override
  public T guardar(T entity) {
    return repository.save(entity);
  }

  @Override
  public void eliminarPorId(Long id) {
    repository.deleteById(id);
  }
}
