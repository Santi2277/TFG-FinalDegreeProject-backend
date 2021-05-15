package com.entrenadores.uoctfg.projections;

import org.springframework.data.rest.core.config.Projection;

import com.entrenadores.uoctfg.entity.ParametroGrupo;
import com.entrenadores.uoctfg.entity.ParametroLista;
import com.entrenadores.uoctfg.entity.Perfil;
import java.util.Date;
import java.util.List;

@Projection(name = "inlineParametroListaPerfil", types = { ParametroLista.class })
public interface InlineParametroListaPerfil {

	long getId();
    String getNombre();
    String getDiminutivo();
    String getInfo();
    boolean getCore();
    Date getFechaCreacion();
    Date getFechaModificacion();
    Perfil getCreador();
	List<ParametroGrupo> getParametroGrupos();
	
	
	
}
