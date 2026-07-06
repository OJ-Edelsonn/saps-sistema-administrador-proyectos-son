package com.son.saps.service.impl;

import com.son.saps.model.Calificacion;
import com.son.saps.model.DetalleCalificacion;
import com.son.saps.repository.CalificacionRepository;
import com.son.saps.service.CalificacionService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class CalificacionServiceImpl extends GenericCrudServiceImpl<Calificacion>
    implements CalificacionService {

  private final CalificacionRepository repository;

  public CalificacionServiceImpl(CalificacionRepository repository) {
    super(repository);
    this.repository = repository;
  }

  @Override
  public List<Calificacion> buscar(String texto) {
    return StringUtils.hasText(texto)
        ? repository.findByProyectoTituloContainingIgnoreCase(texto)
        : repository.findAll();
  }

  @Override
  public Calificacion guardar(Calificacion calificacion) {
    calificacion.setNotaFinal(calcularNotaFinal(calificacion));
    if (calificacion.getDetalles() != null) {
      calificacion.getDetalles().forEach(detalle -> detalle.setCalificacion(calificacion));
    }
    return repository.save(calificacion);
  }

  @Override
  public BigDecimal calcularNotaFinal(Calificacion calificacion) {
    if (calificacion.getDetalles() == null || calificacion.getDetalles().isEmpty()) {
      return calificacion.getNotaFinal() == null ? BigDecimal.ZERO : calificacion.getNotaFinal();
    }
    BigDecimal acumulado = BigDecimal.ZERO;
    for (DetalleCalificacion detalle : calificacion.getDetalles()) {
      if (detalle.getCriterio() == null
          || detalle.getCriterio().getPuntajeMaximo() == null
          || detalle.getCriterio().getPesoPorcentual() == null
          || detalle.getPuntajeObtenido() == null
          || detalle.getCriterio().getPuntajeMaximo().compareTo(BigDecimal.ZERO) <= 0) {
        continue;
      }
      BigDecimal proporcion =
          detalle
              .getPuntajeObtenido()
              .divide(detalle.getCriterio().getPuntajeMaximo(), 4, RoundingMode.HALF_UP);
      acumulado = acumulado.add(proporcion.multiply(detalle.getCriterio().getPesoPorcentual()));
    }
    return acumulado
        .multiply(BigDecimal.valueOf(20))
        .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
  }
}
