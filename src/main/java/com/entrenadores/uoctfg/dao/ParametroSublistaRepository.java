package com.entrenadores.uoctfg.dao;

import com.entrenadores.uoctfg.entity.ParametroLista;
import com.entrenadores.uoctfg.entity.ParametroSublista;
import com.entrenadores.uoctfg.projections.InlineParametroListaPerfil;
import com.entrenadores.uoctfg.projections.InlineParametroSublistaPerfil;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@RepositoryRestResource(path = "parametrosublistas", excerptProjection = InlineParametroSublistaPerfil.class)
@CrossOrigin("http://localhost:4200")
public interface ParametroSublistaRepository extends JpaRepository<ParametroSublista, Long> {
	
	@Query("select ps from ParametroSublista ps join ps.parametroLista pl where pl.id = :idParametroLista")
	List<ParametroSublista> buscarParametroSublistaDeParametroLista(@RequestParam("idParametroLista") Long idParametroLista);
	
	@Query("select ps from ParametroSublista ps where lower(ps.nombre) like lower (concat('%', :nombre, '%'))"+
			"and lower(ps.diminutivo) like lower (concat('%', :diminutivo, '%'))"+
			"and ps.id IN (select ps from ParametroSublista ps left join ps.parametroLista pl where (:parametrovalor = '' or (pl.id like concat('', :parametrovalor, ''))))")
	Page<ParametroSublista> buscarParametroSublista(@RequestParam("nombre") String nombre,
			@RequestParam("diminutivo") String diminutivo,
			@RequestParam("parametrovalor") String parametrovalor,
			Pageable pageable);
	
	
}