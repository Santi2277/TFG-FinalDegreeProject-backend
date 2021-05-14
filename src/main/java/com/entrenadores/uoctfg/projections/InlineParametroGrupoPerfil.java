package com.entrenadores.uoctfg.projections;

import org.springframework.data.rest.core.config.Projection;

import com.entrenadores.uoctfg.entity.Parametro;
import com.entrenadores.uoctfg.entity.ParametroGrupo;
import com.entrenadores.uoctfg.entity.Perfil;
import java.util.Date;

@Projection(name = "inlineParametroGrupoPerfil", types = { ParametroGrupo.class })
public interface InlineParametroGrupoPerfil {

	long getId();
    String getNombre();
    String getDiminutivo();
    String getInfo();
    boolean getCore();
    Date getFechaCreacion();
    Date getFechaModificacion();
    Perfil getCreador();
	Parametro getParametro();
	
}
