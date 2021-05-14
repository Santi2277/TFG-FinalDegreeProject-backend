package com.entrenadores.uoctfg.projections;

import org.springframework.data.rest.core.config.Projection;
import com.entrenadores.uoctfg.entity.Parametro;
import com.entrenadores.uoctfg.entity.Perfil;
import java.util.Date;

@Projection(name = "inlineParametroPerfil", types = { Parametro.class })
public interface InlineParametroPerfil {
	
	long getId();
    String getNombre();
    String getDiminutivo();
    String getInfo();
    boolean getCore();
    Date getFechaCreacion();
    Date getFechaModificacion();
    Perfil getCreador();

}
