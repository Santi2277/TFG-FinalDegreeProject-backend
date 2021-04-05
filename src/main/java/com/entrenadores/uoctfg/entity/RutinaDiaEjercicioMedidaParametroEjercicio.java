package com.entrenadores.uoctfg.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="rutina_dia_jtm_ejercicio_jtm_medida_parametro_ejercicio")
@Data
public class RutinaDiaEjercicioMedidaParametroEjercicio {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
	@Column(name = "secuencia_ejercicio")
    private int secuenciaEjercicio;
	
	@ManyToOne
    @JoinColumn(name = "rutina_dia_id", nullable = false)
    private RutinaDia rutinaDia;
	
	@ManyToOne
    @JoinColumn(name = "ejercicio_id", nullable = false)
    private Ejercicio ejercicio;
	
	@ManyToOne
    @JoinColumn(name = "medida_parametro_ejercicio_id", nullable = false)
    private MedidaParametroEjercicio medidaParametroEjercicio;
	
	
}
