package com.son.saps.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "detalle_calificaciones")
public class DetalleCalificacion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @ManyToOne(optional = false)
  @JoinColumn(name = "calificacion_id")
  private Calificacion calificacion;

  @NotNull
  @ManyToOne(optional = false)
  @JoinColumn(name = "criterio_id")
  private CriterioEvaluacion criterio;

  @NotNull
  @DecimalMin("0.0")
  private BigDecimal puntajeObtenido = BigDecimal.ZERO;

  @Column(length = 1000)
  private String comentario;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Calificacion getCalificacion() {
    return calificacion;
  }

  public void setCalificacion(Calificacion calificacion) {
    this.calificacion = calificacion;
  }

  public CriterioEvaluacion getCriterio() {
    return criterio;
  }

  public void setCriterio(CriterioEvaluacion criterio) {
    this.criterio = criterio;
  }

  public BigDecimal getPuntajeObtenido() {
    return puntajeObtenido;
  }

  public void setPuntajeObtenido(BigDecimal puntajeObtenido) {
    this.puntajeObtenido = puntajeObtenido;
  }

  public String getComentario() {
    return comentario;
  }

  public void setComentario(String comentario) {
    this.comentario = comentario;
  }
}
