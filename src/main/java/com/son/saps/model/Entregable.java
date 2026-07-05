package com.son.saps.model;

        import com.son.saps.model.enums.EstadoEntregable;
import com.son.saps.model.enums.TipoEntregable;
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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;

        @Entity
@Table(name = "entregables")
        public class Entregable {

            @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "proyecto_id")
    private Proyecto proyecto;
    @NotBlank
    @Column(nullable = false, length = 140)
    private String nombre;
    @Enumerated(EnumType.STRING)
    private TipoEntregable tipo;
    @Column(length = 1000)
    private String descripcion;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaLimite;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaEntrega;
    @Column(length = 500)
    private String urlArchivo;
    @Enumerated(EnumType.STRING)
    private EstadoEntregable estado = EstadoEntregable.PENDIENTE;
    @OneToMany(mappedBy = "entregable")
    private List<Observacion> observaciones = new ArrayList<>();

        public boolean isAtrasado() {
    return fechaLimite != null
            && fechaEntrega == null
            && LocalDate.now().isAfter(fechaLimite);
}


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


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public TipoEntregable getTipo() {
        return tipo;
    }

    public void setTipo(TipoEntregable tipo) {
        this.tipo = tipo;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }


    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }


    public String getUrlArchivo() {
        return urlArchivo;
    }

    public void setUrlArchivo(String urlArchivo) {
        this.urlArchivo = urlArchivo;
    }


    public EstadoEntregable getEstado() {
        return estado;
    }

    public void setEstado(EstadoEntregable estado) {
        this.estado = estado;
    }


    public List<Observacion> getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(List<Observacion> observaciones) {
        this.observaciones = observaciones;
    }

        }
