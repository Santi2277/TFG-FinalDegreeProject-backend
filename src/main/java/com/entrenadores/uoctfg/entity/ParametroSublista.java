package com.entrenadores.uoctfg.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="parametro_sublista")
@Data
public class ParametroSublista {

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
    
    @ManyToOne
    @JoinColumn(name = "parametro_lista_id")
    private ParametroLista parametroLista;
    
    @ManyToMany(mappedBy = "parametroSublistas")
    List<Ejercicio> ejercicios;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parametroSublista")
    private List<MedidaParametroEjercicio> medidasParametroEjercicio;
    
    @ManyToMany(mappedBy = "parametroSublistas")
    List<Rutina> rutinas;
    
}