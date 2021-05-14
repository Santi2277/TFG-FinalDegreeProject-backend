package com.entrenadores.uoctfg.dao;

import com.entrenadores.uoctfg.entity.Parametro;
import com.entrenadores.uoctfg.projections.InlineParametroPerfil;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@RepositoryRestResource(path = "parametros", excerptProjection = InlineParametroPerfil.class)
@CrossOrigin("http://localhost:4200")
public interface ParametroRepository extends JpaRepository<Parametro, Long> {
	
	
	@Query("select p from Parametro p where lower(p.nombre) like lower (concat('%', :nombre, '%'))"+
			"and lower(p.diminutivo) like lower (concat('%', :diminutivo, '%'))")
	Page<Parametro> buscarParametro(@RequestParam("nombre") String nombre,
			@RequestParam("diminutivo") String diminutivo,
			Pageable pageable);
	
	
	
}