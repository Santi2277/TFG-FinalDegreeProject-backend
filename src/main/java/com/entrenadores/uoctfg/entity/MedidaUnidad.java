package com.entrenadores.uoctfg.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="medida_unidad")
@Data
public class MedidaUnidad {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "diminutivo")
    private String diminutivo;
    
    @Column(name = "info")
    private String info;
    
    @Column(name = "core")
    private boolean core;

    @Column(name = "fecha_creacion")
    @CreationTimestamp
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion")
    @UpdateTimestamp
    private Date fechaModificacion;
    
    @ManyToOne
    @JoinColumn(name = "creador_id", nullable = false)
    private Perfil creador;
    
    @ManyToOne
    @JoinColumn(name = "modificador_id", nullable = false)
    private Perfil modificador;
    
    @ManyToOne
    @JoinColumn(name = "medida_grupo_id", nullable = false)
    private MedidaGrupo medidaGrupo;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medidaUnidad")
    private List<MedidaParametroEjercicio> medidasParametroEjercicio;
    
}