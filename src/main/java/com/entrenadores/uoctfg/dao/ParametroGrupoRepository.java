package com.entrenadores.uoctfg.dao;
import com.entrenadores.uoctfg.entity.Parametro;
import com.entrenadores.uoctfg.entity.ParametroGrupo;
import com.entrenadores.uoctfg.projections.InlineParametroGrupoPerfil;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@RepositoryRestResource(path = "parametrogrupos", excerptProjection = InlineParametroGrupoPerfil.class)
@CrossOrigin("http://localhost:4200")
public interface ParametroGrupoRepository extends JpaRepository<ParametroGrupo, Long> {
	
	@Query("select pg from ParametroGrupo pg join pg.parametro p where p.id = :idParametro")
	List<ParametroGrupo> buscarParametroGrupoDeParametro(@RequestParam("idParametro") Long idParametro);
	
	@Query("select pg from ParametroGrupo pg where lower(pg.nombre) like lower (concat('%', :nombre, '%'))"+
			"and lower(pg.diminutivo) like lower (concat('%', :diminutivo, '%'))"+
			"and pg.id IN (select pg from ParametroGrupo pg join pg.parametro p where (:parametro = '' or (p.id like concat('', :parametro, ''))))")
	Page<ParametroGrupo> buscarParametroGrupo(@RequestParam("nombre") String nombre,
			@RequestParam("diminutivo") String diminutivo,
			@RequestParam("parametro") String parametro,
			Pageable pageable);
	
	
}