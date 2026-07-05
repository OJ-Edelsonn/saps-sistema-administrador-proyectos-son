package com.son.saps.service.impl;

import com.son.saps.model.Observacion;
import com.son.saps.repository.ObservacionRepository;
import com.son.saps.service.ObservacionService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ObservacionServiceImpl extends GenericCrudServiceImpl<Observacion> implements ObservacionService {

    private final ObservacionRepository repository;

    public ObservacionServiceImpl(ObservacionRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public List<Observacion> buscar(String texto) {
        return StringUtils.hasText(texto) ? repository.findByComentarioContainingIgnoreCase(texto) : repository.findAll();
    }


}
