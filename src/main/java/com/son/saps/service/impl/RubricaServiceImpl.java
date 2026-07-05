package com.son.saps.service.impl;

import com.son.saps.model.Rubrica;
import com.son.saps.repository.RubricaRepository;
import com.son.saps.service.RubricaService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class RubricaServiceImpl extends GenericCrudServiceImpl<Rubrica> implements RubricaService {

    private final RubricaRepository repository;

    public RubricaServiceImpl(RubricaRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public List<Rubrica> buscar(String texto) {
        return StringUtils.hasText(texto) ? repository.findByNombreContainingIgnoreCase(texto) : repository.findAll();
    }


}
