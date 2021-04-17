package com.entrenadores.uoctfg.dao;

import com.entrenadores.uoctfg.entity.ParametroSublista;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@RepositoryRestResource(path = "parametrosublistas")
@CrossOrigin("http://localhost:4200")
public interface ParametroSublistaRepository extends JpaRepository<ParametroSublista, Long> {
	
	@Query("select ps from ParametroSublista ps join ps.parametroLista pl where pl.id = :idParametroLista")
	List<ParametroSublista> buscarParametroSublistaDeParametroLista(@RequestParam("idParametroLista") Long idParametroLista);
	
}