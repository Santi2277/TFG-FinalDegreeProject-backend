package com.entrenadores.uoctfg.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="multimedia_grupo")
@Data
public class MultimediaGrupo {

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
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "multimediaGrupo")
    private List<Multimedia> multimedias;
    
}