package com.son.saps.model;

import com.son.saps.model.enums.EstadoGeneral;
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
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rubricas")
public class Rubrica {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Column(nullable = false, length = 140)
  private String nombre;

  @NotNull
  @ManyToOne(optional = false)
  @JoinColumn(name = "curso_id")
  private Curso curso;

  @Column(length = 1000)
  private String descripcion;

  @NotNull
  @DecimalMin("1.0")
  private BigDecimal puntajeMaximo = BigDecimal.valueOf(20);

  @Enumerated(EnumType.STRING)
  private EstadoGeneral estado = EstadoGeneral.ACTIVO;

  @OneToMany(mappedBy = "rubrica", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<CriterioEvaluacion> criterios = new ArrayList<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Curso getCurso() {
    return curso;
  }

  public void setCurso(Curso curso) {
    this.curso = curso;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public BigDecimal getPuntajeMaximo() {
    return puntajeMaximo;
  }

  public void setPuntajeMaximo(BigDecimal puntajeMaximo) {
    this.puntajeMaximo = puntajeMaximo;
  }

  public EstadoGeneral getEstado() {
    return estado;
  }

  public void setEstado(EstadoGeneral estado) {
    this.estado = estado;
  }

  public List<CriterioEvaluacion> getCriterios() {
    return criterios;
  }

  public void setCriterios(List<CriterioEvaluacion> criterios) {
    this.criterios = criterios;
  }
}
