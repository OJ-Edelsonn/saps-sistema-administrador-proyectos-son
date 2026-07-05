package com.son.saps.service.impl;

import com.son.saps.model.Estudiante;
import com.son.saps.repository.EstudianteRepository;
import com.son.saps.service.EstudianteService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class EstudianteServiceImpl extends GenericCrudServiceImpl<Estudiante> implements EstudianteService {

    private final EstudianteRepository repository;

    public EstudianteServiceImpl(EstudianteRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public List<Estudiante> buscar(String texto) {
        return StringUtils.hasText(texto) ? repository.findByNombresContainingIgnoreCaseOrApellidosContainingIgnoreCaseOrCodigoUniversitarioContainingIgnoreCase(texto, texto, texto) : repository.findAll();
    }


}
