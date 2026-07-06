package com.son.saps.model;

import com.son.saps.model.enums.EstadoObservacion;
import com.son.saps.model.enums.NivelObservacion;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "observaciones")
public class Observacion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @ManyToOne(optional = false)
  @JoinColumn(name = "proyecto_id")
  private Proyecto proyecto;

  @ManyToOne
  @JoinColumn(name = "entregable_id")
  private Entregable entregable;

  @NotNull
  @ManyToOne(optional = false)
  @JoinColumn(name = "docente_id")
  private Docente docente;

  @NotBlank
  @Column(nullable = false, length = 2000)
  private String comentario;

  @Enumerated(EnumType.STRING)
  private NivelObservacion nivel = NivelObservacion.LEVE;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate fechaObservacion;

  @Enumerated(EnumType.STRING)
  private EstadoObservacion estado = EstadoObservacion.PENDIENTE;

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

  public Entregable getEntregable() {
    return entregable;
  }

  public void setEntregable(Entregable entregable) {
    this.entregable = entregable;
  }

  public Docente getDocente() {
    return docente;
  }

  public void setDocente(Docente docente) {
    this.docente = docente;
  }

  public String getComentario() {
    return comentario;
  }

  public void setComentario(String comentario) {
    this.comentario = comentario;
  }

  public NivelObservacion getNivel() {
    return nivel;
  }

  public void setNivel(NivelObservacion nivel) {
    this.nivel = nivel;
  }

  public LocalDate getFechaObservacion() {
    return fechaObservacion;
  }

  public void setFechaObservacion(LocalDate fechaObservacion) {
    this.fechaObservacion = fechaObservacion;
  }

  public EstadoObservacion getEstado() {
    return estado;
  }

  public void setEstado(EstadoObservacion estado) {
    this.estado = estado;
  }
}
