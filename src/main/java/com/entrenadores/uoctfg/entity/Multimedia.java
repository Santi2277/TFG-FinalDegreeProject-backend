package com.entrenadores.uoctfg.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="multimedia")
@Data
public class Multimedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "url")
    private String url;
    
    @Column(name = "defecto")
    private boolean defecto;
    
    
    @Column(name = "numero_secuencia")
    private int numero_secuencia;
    
    @Column(name = "info")
    private String info;
    
    @ManyToOne
    @JoinColumn(name = "multimedia_grupo_id", nullable = false)
    private MultimediaGrupo multimediaGrupo;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
      name = "multimedia_jt_ejercicio", 
      joinColumns = @JoinColumn(name = "multimedia_id", referencedColumnName = "id"), 
      inverseJoinColumns = @JoinColumn(name = "ejercicio_id", referencedColumnName = "id"))
    List<Ejercicio> ejercicios;
    
}