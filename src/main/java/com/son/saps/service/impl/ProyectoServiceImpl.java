package com.son.saps.service.impl;

import com.son.saps.model.Proyecto;
import com.son.saps.repository.ProyectoRepository;
import com.son.saps.service.ProyectoService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ProyectoServiceImpl extends GenericCrudServiceImpl<Proyecto> implements ProyectoService {

    private final ProyectoRepository repository;

    public ProyectoServiceImpl(ProyectoRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public List<Proyecto> buscar(String texto) {
        return StringUtils.hasText(texto) ? repository.findByTituloContainingIgnoreCaseOrLineaTematicaContainingIgnoreCase(texto, texto) : repository.findAll();
    }


}
