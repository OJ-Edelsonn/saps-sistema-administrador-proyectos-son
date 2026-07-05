package com.son.saps.service.impl;

import com.son.saps.model.Grupo;
import com.son.saps.repository.GrupoRepository;
import com.son.saps.service.GrupoService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class GrupoServiceImpl extends GenericCrudServiceImpl<Grupo> implements GrupoService {

    private final GrupoRepository repository;

    public GrupoServiceImpl(GrupoRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public List<Grupo> buscar(String texto) {
        return StringUtils.hasText(texto) ? repository.findByNombreContainingIgnoreCaseOrCodigoGrupoContainingIgnoreCase(texto, texto) : repository.findAll();
    }


}
