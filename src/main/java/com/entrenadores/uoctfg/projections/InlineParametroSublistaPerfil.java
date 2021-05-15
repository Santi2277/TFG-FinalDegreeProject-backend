package com.entrenadores.uoctfg.projections;

import java.util.Date;
import java.util.List;
import org.springframework.data.rest.core.config.Projection;
import com.entrenadores.uoctfg.entity.ParametroGrupo;
import com.entrenadores.uoctfg.entity.ParametroLista;
import com.entrenadores.uoctfg.entity.ParametroSublista;
import com.entrenadores.uoctfg.entity.Perfil;

@Projection(name = "inlineParametroSublistaPerfil", types = { ParametroSublista.class })
public interface InlineParametroSublistaPerfil {

	long getId();
    String getNombre();
    String getDiminutivo();
    String getInfo();
    boolean getCore();
    Date getFechaCreacion();
    Date getFechaModificacion();
    Perfil getCreador();
	ParametroLista getParametroLista();
	
	
	
	
}
