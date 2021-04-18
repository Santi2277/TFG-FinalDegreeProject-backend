package com.entrenadores.uoctfg.projections;

import java.util.Date;

import org.springframework.data.rest.core.config.Projection;
import com.entrenadores.uoctfg.entity.Ejercicio;
import com.entrenadores.uoctfg.entity.Perfil;

@Projection(name = "inlineEjercicioPerfil", types = { Ejercicio.class })
public interface InlineEjercicioPerfil {
    
	long getId();
    String getNombre();
    String getDescripcionCorta();
    String getDescripcionLarga();
    String getInfo();
    boolean getCore();
    Date getFechaCreacion();
    Date getFechaModificacion();
    Perfil getCreador();
	
	
}