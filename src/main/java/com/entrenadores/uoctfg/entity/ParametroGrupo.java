package com.entrenadores.uoctfg.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="parametro_grupo")
@Data
public class ParametroGrupo {

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
    @JoinColumn(name = "parametro_id")
    private Parametro parametro;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
      name = "parametro_grupo_jt_parametro_lista", 
      joinColumns = @JoinColumn(name = "parametro_grupo_id", referencedColumnName = "id"), 
      inverseJoinColumns = @JoinColumn(name = "parametro_lista_id", referencedColumnName = "id"))
    List<ParametroLista> parametroListas;
    
}