package com.son.saps.model;

import com.son.saps.model.enums.EstadoProyecto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "calificaciones")
public class Calificacion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @ManyToOne(optional = false)
  @JoinColumn(name = "proyecto_id")
  private Proyecto proyecto;

  @NotNull
  @ManyToOne(optional = false)
  @JoinColumn(name = "rubrica_id")
  private Rubrica rubrica;

  @NotNull
  @ManyToOne(optional = false)
  @JoinColumn(name = "docente_id")
  private Docente docenteEvaluador;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate fechaEvaluacion;

  @DecimalMin("0.0")
  @DecimalMax("20.0")
  private BigDecimal notaFinal = BigDecimal.ZERO;

  @Column(length = 2000)
  private String comentarioGeneral;

  @Enumerated(EnumType.STRING)
  private EstadoProyecto estado = EstadoProyecto.EN_DESARROLLO;

  @OneToMany(mappedBy = "calificacion", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<DetalleCalificacion> detalles = new ArrayList<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Proyecto getProyecto() {
    return proyecto;
  }

  public void setProyecto(Proyecto proyecto) {
    this.proyecto = proyecto;
  }

  public Rubrica getRubrica() {
    return rubrica;
  }

  public void setRubrica(Rubrica rubrica) {
    this.rubrica = rubrica;
  }

  public Docente getDocenteEvaluador() {
    return docenteEvaluador;
  }

  public void setDocenteEvaluador(Docente docenteEvaluador) {
    this.docenteEvaluador = docenteEvaluador;
  }

  public LocalDate getFechaEvaluacion() {
    return fechaEvaluacion;
  }

  public void setFechaEvaluacion(LocalDate fechaEvaluacion) {
    this.fechaEvaluacion = fechaEvaluacion;
  }

  public BigDecimal getNotaFinal() {
    return notaFinal;
  }

  public void setNotaFinal(BigDecimal notaFinal) {
    this.notaFinal = notaFinal;
  }

  public String getComentarioGeneral() {
    return comentarioGeneral;
  }

  public void setComentarioGeneral(String comentarioGeneral) {
    this.comentarioGeneral = comentarioGeneral;
  }

  public EstadoProyecto getEstado() {
    return estado;
  }

  public void setEstado(EstadoProyecto estado) {
    this.estado = estado;
  }

  public List<DetalleCalificacion> getDetalles() {
    return detalles;
  }

  public void setDetalles(List<DetalleCalificacion> detalles) {
    this.detalles = detalles;
  }
}
