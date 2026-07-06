package com.son.saps.service.impl;

import com.son.saps.model.Entregable;
import com.son.saps.repository.EntregableRepository;
import com.son.saps.service.EntregableService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class EntregableServiceImpl extends GenericCrudServiceImpl<Entregable>
    implements EntregableService {

  private final EntregableRepository repository;

  public EntregableServiceImpl(EntregableRepository repository) {
    super(repository);
    this.repository = repository;
  }

  @Override
  public List<Entregable> buscar(String texto) {
    return StringUtils.hasText(texto)
        ? repository.findByNombreContainingIgnoreCase(texto)
        : repository.findAll();
  }
}
