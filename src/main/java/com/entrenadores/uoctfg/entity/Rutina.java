package com.entrenadores.uoctfg.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="rutina")
@Data
public class Rutina {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "numero_dias")
    private int numeroDias;
    
    @Column(name = "parametro_libre")
    private boolean parametroLibre;
    
    @Column(name = "descripcion_corta")
    private String descripcionCorta;
    
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
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutina")
    private List<RutinaDia> rutinasDia;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
      name = "rutina_jt_parametro_lista", 
      joinColumns = @JoinColumn(name = "rutina_id", referencedColumnName = "id"), 
      inverseJoinColumns = @JoinColumn(name = "parametro_lista_id", referencedColumnName = "id"))
    List<ParametroLista> parametroListas;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
      name = "rutina_jt_parametro_sublista", 
      joinColumns = @JoinColumn(name = "rutina_id", referencedColumnName = "id"), 
      inverseJoinColumns = @JoinColumn(name = "parametro_sublista_id", referencedColumnName = "id"))
    List<ParametroSublista> parametroSublistas;
	
}
