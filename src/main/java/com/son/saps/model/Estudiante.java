package com.son.saps.model;

import com.son.saps.model.enums.EstadoGeneral;
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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "estudiantes")
public class Estudiante {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Column(nullable = false, unique = true, length = 20)
  private String codigoUniversitario;

  @NotBlank
  @Column(nullable = false, length = 80)
  private String nombres;

  @NotBlank
  @Column(nullable = false, length = 80)
  private String apellidos;

  @Email
  @Column(length = 120)
  private String correo;

  @Column(length = 120)
  private String carrera;

  @Min(1)
  private Integer ciclo;

  @Enumerated(EnumType.STRING)
  private EstadoGeneral estado = EstadoGeneral.ACTIVO;

  @ManyToOne
  @JoinColumn(name = "grupo_id")
  private Grupo grupo;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCodigoUniversitario() {
    return codigoUniversitario;
  }

  public void setCodigoUniversitario(String codigoUniversitario) {
    this.codigoUniversitario = codigoUniversitario;
  }

  public String getNombres() {
    return nombres;
  }

  public void setNombres(String nombres) {
    this.nombres = nombres;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public String getCarrera() {
    return carrera;
  }

  public void setCarrera(String carrera) {
    this.carrera = carrera;
  }

  public Integer getCiclo() {
    return ciclo;
  }

  public void setCiclo(Integer ciclo) {
    this.ciclo = ciclo;
  }

  public EstadoGeneral getEstado() {
    return estado;
  }

  public void setEstado(EstadoGeneral estado) {
    this.estado = estado;
  }

  public Grupo getGrupo() {
    return grupo;
  }

  public void setGrupo(Grupo grupo) {
    this.grupo = grupo;
  }
}
