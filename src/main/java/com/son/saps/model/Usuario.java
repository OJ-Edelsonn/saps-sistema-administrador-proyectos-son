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
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Column(nullable = false, unique = true, length = 50)
  private String username;

  @NotBlank
  @Column(nullable = false, length = 120)
  private String password;

  @NotBlank
  @Column(nullable = false, length = 120)
  private String nombreCompleto;

  @Email
  @Column(length = 120)
  private String correo;

  @NotNull
  @ManyToOne(optional = false)
  @JoinColumn(name = "rol_id")
  private Rol rol;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false, length = 20)
  private EstadoGeneral estado = EstadoGeneral.ACTIVO;

  private LocalDateTime fechaCreacion;

  @PrePersist
  public void prePersist() {
    if (fechaCreacion == null) {
      fechaCreacion = LocalDateTime.now();
    }
    if (estado == null) {
      estado = EstadoGeneral.ACTIVO;
    }
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getNombreCompleto() {
    return nombreCompleto;
  }

  public void setNombreCompleto(String nombreCompleto) {
    this.nombreCompleto = nombreCompleto;
  }

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public Rol getRol() {
    return rol;
  }

  public void setRol(Rol rol) {
    this.rol = rol;
  }

  public EstadoGeneral getEstado() {
    return estado;
  }

  public void setEstado(EstadoGeneral estado) {
    this.estado = estado;
  }

  public LocalDateTime getFechaCreacion() {
    return fechaCreacion;
  }

  public void setFechaCreacion(LocalDateTime fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }
}
