package com.son.saps.model;

import com.son.saps.model.enums.EstadoGeneral;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cursos")
public class Curso {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Column(nullable = false, unique = true, length = 20)
  private String codigo;

  @NotBlank
  @Column(nullable = false, length = 120)
  private String nombre;

  @NotNull
  @Min(1)
  private Integer ciclo;

  @NotNull
  @Min(1)
  private Integer creditos;

  @Column(length = 1000)
  private String descripcion;

  @Enumerated(EnumType.STRING)
  private EstadoGeneral estado = EstadoGeneral.ACTIVO;

  @OneToMany(mappedBy = "curso")
  private List<Grupo> grupos = new ArrayList<>();

  @OneToMany(mappedBy = "curso")
  private List<Rubrica> rubricas = new ArrayList<>();

  @OneToMany(mappedBy = "curso")
  private List<Proyecto> proyectos = new ArrayList<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Integer getCiclo() {
    return ciclo;
  }

  public void setCiclo(Integer ciclo) {
    this.ciclo = ciclo;
  }

  public Integer getCreditos() {
    return creditos;
  }

  public void setCreditos(Integer creditos) {
    this.creditos = creditos;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public EstadoGeneral getEstado() {
    return estado;
  }

  public void setEstado(EstadoGeneral estado) {
    this.estado = estado;
  }

  public List<Grupo> getGrupos() {
    return grupos;
  }

  public void setGrupos(List<Grupo> grupos) {
    this.grupos = grupos;
  }

  public List<Rubrica> getRubricas() {
    return rubricas;
  }

  public void setRubricas(List<Rubrica> rubricas) {
    this.rubricas = rubricas;
  }

  public List<Proyecto> getProyectos() {
    return proyectos;
  }

  public void setProyectos(List<Proyecto> proyectos) {
    this.proyectos = proyectos;
  }
}
