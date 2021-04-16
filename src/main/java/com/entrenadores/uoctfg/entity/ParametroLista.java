package com.entrenadores.uoctfg.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity(name="ParametroLista")
@Table(name="parametro_lista")
@Data
public class ParametroLista {

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
    @JoinColumn(name = "creador_id")
    private Perfil creador;
    
    @ManyToOne
    @JoinColumn(name = "modificador_id")
    private Perfil modificador;
    
    @ManyToMany(mappedBy = "parametroListas")
    List<ParametroGrupo> parametroGrupos;
    
    @ManyToMany(mappedBy = "parametroListas")
    List<Ejercicio> ejercicios;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parametroLista")
    private List<ParametroSublista> parametroSublistas;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parametroLista")
    private List<MedidaParametroEjercicio> medidasParametroEjercicio;
    
    @ManyToMany(mappedBy = "parametroListas")
    List<Rutina> rutinas;
    
}