package com.entrenadores.uoctfg.dao;

import com.entrenadores.uoctfg.entity.ParametroGrupo;
import com.entrenadores.uoctfg.entity.ParametroLista;
import com.entrenadores.uoctfg.projections.InlineParametroListaPerfil;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@RepositoryRestResource(path = "parametrolistas", excerptProjection = InlineParametroListaPerfil.class)
@CrossOrigin("http://localhost:4200")
public interface ParametroListaRepository extends JpaRepository<ParametroLista, Long> {
	
	@Query("select pl from ParametroLista pl join pl.parametroGrupos pg where pg.id = :idParametroGrupo")
	List<ParametroLista> buscarParametroListaDeParametroGrupo(@RequestParam("idParametroGrupo") Long idParametroGrupo);
	
	
	@Query("select pl from ParametroLista pl where lower(pl.nombre) like lower (concat('%', :nombre, '%'))"+
			"and lower(pl.diminutivo) like lower (concat('%', :diminutivo, '%'))"+
			"and pl.id IN (select pl from ParametroLista pl join pl.parametroGrupos pg where (:parametrogrupo = '' or (pg.id like concat('', :parametrogrupo, ''))))")
	Page<ParametroLista> buscarParametroLista(@RequestParam("nombre") String nombre,
			@RequestParam("diminutivo") String diminutivo,
			@RequestParam("parametrogrupo") String parametrogrupo,
			Pageable pageable);
	
	
	
}