package com.son.saps.service.impl;

import com.son.saps.model.DetalleCalificacion;
import com.son.saps.repository.DetalleCalificacionRepository;
import com.son.saps.service.DetalleCalificacionService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class DetalleCalificacionServiceImpl extends GenericCrudServiceImpl<DetalleCalificacion> implements DetalleCalificacionService {

    private final DetalleCalificacionRepository repository;

    public DetalleCalificacionServiceImpl(DetalleCalificacionRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public List<DetalleCalificacion> buscar(String texto) {
        return repository.findAll();
    }


}
