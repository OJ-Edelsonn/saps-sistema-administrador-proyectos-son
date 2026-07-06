package com.son.saps.service.impl;

import com.son.saps.model.Rol;
import com.son.saps.repository.RolRepository;
import com.son.saps.service.RolService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl extends GenericCrudServiceImpl<Rol> implements RolService {

  private final RolRepository repository;

  public RolServiceImpl(RolRepository repository) {
    super(repository);
    this.repository = repository;
  }

  @Override
  public List<Rol> buscar(String texto) {
    return repository.findAll();
  }
}
