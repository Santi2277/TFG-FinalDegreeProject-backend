package com.entrenadores.uoctfg.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="medida_parametro_ejercicio")
@Data
public class MedidaParametroEjercicio {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
	@Column(name = "medida_valor")
    private float medidaValor;
	
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
    @JoinColumn(name = "ejercicio_id")
    private Ejercicio ejercicio;
    
    @ManyToOne
    @JoinColumn(name = "medida_unidad_id")
    private MedidaUnidad medidaUnidad;
    
    @ManyToOne
    @JoinColumn(name = "parametro_lista_id")
    private ParametroLista parametroLista;
    
    @ManyToOne
    @JoinColumn(name = "parametro_sublista_id")
    private ParametroSublista parametroSublista;
	
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medidaParametroEjercicio")
    private List<RutinaDiaEjercicioMedidaParametroEjercicio> rutinasDiaEjercicioMedidaParametroEjercicio;
	
	
}
