package com.son.saps.model;

import com.son.saps.model.enums.EstadoProyecto;
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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "proyectos")
public class Proyecto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Column(nullable = false, length = 180)
  private String titulo;

  @Column(length = 2000)
  private String descripcion;

  @Column(length = 2000)
  private String problemaIdentificado;

  @Column(length = 1000)
  private String objetivoGeneral;

  @Column(length = 2000)
  private String objetivosEspecificos;

  @Column(length = 120)
  private String lineaTematica;

  @NotNull
  @ManyToOne(optional = false)
  @JoinColumn(name = "curso_id")
  private Curso curso;

  @NotNull
  @OneToOne(optional = false)
  @JoinColumn(name = "grupo_id", unique = true)
  private Grupo grupo;

  @NotNull
  @ManyToOne(optional = false)
  @JoinColumn(name = "docente_id")
  private Docente docenteAsesor;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate fechaInicio;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate fechaEstimadaEntrega;

  @Enumerated(EnumType.STRING)
  private EstadoProyecto estado = EstadoProyecto.PROPUESTO;

  @OneToMany(mappedBy = "proyecto")
  private List<Entregable> entregables = new ArrayList<>();

  @OneToMany(mappedBy = "proyecto")
  private List<Observacion> observaciones = new ArrayList<>();

  @OneToMany(mappedBy = "proyecto")
  private List<Calificacion> calificaciones = new ArrayList<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getProblemaIdentificado() {
    return problemaIdentificado;
  }

  public void setProblemaIdentificado(String problemaIdentificado) {
    this.problemaIdentificado = problemaIdentificado;
  }

  public String getObjetivoGeneral() {
    return objetivoGeneral;
  }

  public void setObjetivoGeneral(String objetivoGeneral) {
    this.objetivoGeneral = objetivoGeneral;
  }

  public String getObjetivosEspecificos() {
    return objetivosEspecificos;
  }

  public void setObjetivosEspecificos(String objetivosEspecificos) {
    this.objetivosEspecificos = objetivosEspecificos;
  }

  public String getLineaTematica() {
    return lineaTematica;
  }

  public void setLineaTematica(String lineaTematica) {
    this.lineaTematica = lineaTematica;
  }

  public Curso getCurso() {
    return curso;
  }

  public void setCurso(Curso curso) {
    this.curso = curso;
  }

  public Grupo getGrupo() {
    return grupo;
  }

  public void setGrupo(Grupo grupo) {
    this.grupo = grupo;
  }

  public Docente getDocenteAsesor() {
    return docenteAsesor;
  }

  public void setDocenteAsesor(Docente docenteAsesor) {
    this.docenteAsesor = docenteAsesor;
  }

  public LocalDate getFechaInicio() {
    return fechaInicio;
  }

  public void setFechaInicio(LocalDate fechaInicio) {
    this.fechaInicio = fechaInicio;
  }

  public LocalDate getFechaEstimadaEntrega() {
    return fechaEstimadaEntrega;
  }

  public void setFechaEstimadaEntrega(LocalDate fechaEstimadaEntrega) {
    this.fechaEstimadaEntrega = fechaEstimadaEntrega;
  }

  public EstadoProyecto getEstado() {
    return estado;
  }

  public void setEstado(EstadoProyecto estado) {
    this.estado = estado;
  }

  public List<Entregable> getEntregables() {
    return entregables;
  }

  public void setEntregables(List<Entregable> entregables) {
    this.entregables = entregables;
  }

  public List<Observacion> getObservaciones() {
    return observaciones;
  }

  public void setObservaciones(List<Observacion> observaciones) {
    this.observaciones = observaciones;
  }

  public List<Calificacion> getCalificaciones() {
    return calificaciones;
  }

  public void setCalificaciones(List<Calificacion> calificaciones) {
    this.calificaciones = calificaciones;
  }
}
