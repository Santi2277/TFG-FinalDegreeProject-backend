package com.entrenadores.uoctfg.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity(name="Ejercicio")
@Table(name="ejercicio")
@Data
public class Ejercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion_corta")
    private String descripcionCorta;

    @Column(name = "descripcion_larga")
    private String descripcionLarga;
    
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
    @JoinColumn(name = "ejercicio_grupo_id")
    private EjercicioGrupo ejercicioGrupo;
    
    @ManyToOne
    @JoinColumn(name = "creador_id")
    private Perfil creador;
    
    @ManyToOne
    @JoinColumn(name = "modificador_id")
    private Perfil modificador;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
      name = "ejercicio_jt_parametro_lista", 
      joinColumns = @JoinColumn(name = "ejercicio_id", referencedColumnName = "id"), 
      inverseJoinColumns = @JoinColumn(name = "parametro_lista_id", referencedColumnName = "id"))
    List<ParametroLista> parametroListas;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
      name = "ejercicio_jt_parametro_sublista", 
      joinColumns = @JoinColumn(name = "ejercicio_id", referencedColumnName = "id"), 
      inverseJoinColumns = @JoinColumn(name = "parametro_sublista_id", referencedColumnName = "id"))
    List<ParametroSublista> parametroSublistas;
    
    @ManyToMany(mappedBy = "ejercicios")
    List<Multimedia> multimedias;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ejercicio")
    private List<MedidaParametroEjercicio> medidasParametroEjercicio;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ejercicio")
    private List<RutinaDiaEjercicioMedidaParametroEjercicio> rutinasDiaEjercicioMedidaParametroEjercicio;
    
    
}
