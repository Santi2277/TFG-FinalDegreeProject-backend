package com.entrenadores.uoctfg.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="rutina_dia")
@Data
public class RutinaDia {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
	@Column(name = "numero")
    private int numero;
    
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
    @JoinColumn(name = "rutina_id", nullable = false)
    private Rutina rutina;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutinaDia")
    private List<RutinaDiaEjercicioMedidaParametroEjercicio> rutinasDiaEjercicioMedidaParametroEjercicio;
}
