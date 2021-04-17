package com.entrenadores.uoctfg.dao;
import com.entrenadores.uoctfg.entity.ParametroGrupo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@RepositoryRestResource(path = "parametrogrupos")
@CrossOrigin("http://localhost:4200")
public interface ParametroGrupoRepository extends JpaRepository<ParametroGrupo, Long> {
	
	@Query("select pg from ParametroGrupo pg join pg.parametro p where p.id = :idParametro")
	List<ParametroGrupo> buscarParametroGrupoDeParametro(@RequestParam("idParametro") Long idParametro);
	
	
}