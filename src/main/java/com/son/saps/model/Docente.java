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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

        @Entity
@Table(name = "docentes")
        public class Docente {

            @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    private String especialidad;
    @Column(length = 30)
    private String telefono;
    @Enumerated(EnumType.STRING)
    private EstadoGeneral estado = EstadoGeneral.ACTIVO;
    @OneToMany(mappedBy = "docenteAsesor")
    private List<Grupo> gruposAsesorados = new ArrayList<>();
    @OneToMany(mappedBy = "docenteAsesor")
    private List<Proyecto> proyectosAsesorados = new ArrayList<>();




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }


    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public EstadoGeneral getEstado() {
        return estado;
    }

    public void setEstado(EstadoGeneral estado) {
        this.estado = estado;
    }


    public List<Grupo> getGruposAsesorados() {
        return gruposAsesorados;
    }

    public void setGruposAsesorados(List<Grupo> gruposAsesorados) {
        this.gruposAsesorados = gruposAsesorados;
    }


    public List<Proyecto> getProyectosAsesorados() {
        return proyectosAsesorados;
    }

    public void setProyectosAsesorados(List<Proyecto> proyectosAsesorados) {
        this.proyectosAsesorados = proyectosAsesorados;
    }

        }
