package com.son.saps.service.impl;

import com.son.saps.model.Curso;
import com.son.saps.repository.CursoRepository;
import com.son.saps.service.CursoService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class CursoServiceImpl extends GenericCrudServiceImpl<Curso> implements CursoService {

  private final CursoRepository repository;

  public CursoServiceImpl(CursoRepository repository) {
    super(repository);
    this.repository = repository;
  }

  @Override
  public List<Curso> buscar(String texto) {
    return StringUtils.hasText(texto)
        ? repository.findByNombreContainingIgnoreCaseOrCodigoContainingIgnoreCase(texto, texto)
        : repository.findAll();
  }
}
