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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

        @Entity
@Table(name = "grupos")
        public class Grupo {

            @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(nullable = false, length = 100)
    private String nombre;
    @NotBlank
    @Column(nullable = false, unique = true, length = 30)
    private String codigoGrupo;
    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "curso_id")
    private Curso curso;
    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "docente_id")
    private Docente docenteAsesor;
    @Enumerated(EnumType.STRING)
    private EstadoGeneral estado = EstadoGeneral.ACTIVO;
    private LocalDateTime fechaCreacion;
    @OneToMany(mappedBy = "grupo")
    private List<Estudiante> estudiantes = new ArrayList<>();
    @OneToOne(mappedBy = "grupo")
    private Proyecto proyecto;

        @PrePersist
public void prePersist() {
    if (fechaCreacion == null) {
        fechaCreacion = LocalDateTime.now();
    }
}


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


    public String getCodigoGrupo() {
        return codigoGrupo;
    }

    public void setCodigoGrupo(String codigoGrupo) {
        this.codigoGrupo = codigoGrupo;
    }


    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }


    public Docente getDocenteAsesor() {
        return docenteAsesor;
    }

    public void setDocenteAsesor(Docente docenteAsesor) {
        this.docenteAsesor = docenteAsesor;
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


    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }


    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

        }
