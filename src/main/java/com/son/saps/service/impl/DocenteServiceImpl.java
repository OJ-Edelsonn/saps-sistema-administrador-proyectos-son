package com.son.saps.service.impl;

import com.son.saps.model.Docente;
import com.son.saps.repository.DocenteRepository;
import com.son.saps.service.DocenteService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class DocenteServiceImpl extends GenericCrudServiceImpl<Docente> implements DocenteService {

  private final DocenteRepository repository;

  public DocenteServiceImpl(DocenteRepository repository) {
    super(repository);
    this.repository = repository;
  }

  @Override
  public List<Docente> buscar(String texto) {
    return StringUtils.hasText(texto)
        ? repository
            .findByNombresContainingIgnoreCaseOrApellidosContainingIgnoreCaseOrCorreoContainingIgnoreCase(
                texto, texto, texto)
        : repository.findAll();
  }
}
