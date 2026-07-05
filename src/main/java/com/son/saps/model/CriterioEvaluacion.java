package com.son.saps.model;

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
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

        @Entity
@Table(name = "criterios_evaluacion")
        public class CriterioEvaluacion {

            @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "rubrica_id")
    private Rubrica rubrica;
    @NotBlank
    @Column(nullable = false, length = 140)
    private String nombre;
    @Column(length = 1000)
    private String descripcion;
    @NotNull
    @DecimalMin("0.1")
    private BigDecimal puntajeMaximo = BigDecimal.valueOf(20);
    @NotNull
    @Min(1)
    @Max(100)
    private BigDecimal pesoPorcentual = BigDecimal.valueOf(10);
    @Min(1)
    private Integer orden = 1;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Rubrica getRubrica() {
        return rubrica;
    }

    public void setRubrica(Rubrica rubrica) {
        this.rubrica = rubrica;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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


    public BigDecimal getPesoPorcentual() {
        return pesoPorcentual;
    }

    public void setPesoPorcentual(BigDecimal pesoPorcentual) {
        this.pesoPorcentual = pesoPorcentual;
    }


    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

        }
