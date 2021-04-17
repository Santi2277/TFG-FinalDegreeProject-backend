package com.entrenadores.uoctfg.dao;
import com.entrenadores.uoctfg.entity.ParametroLista;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@RepositoryRestResource(path = "parametrolistas")
@CrossOrigin("http://localhost:4200")
public interface ParametroListaRepository extends JpaRepository<ParametroLista, Long> {
	
	@Query("select pl from ParametroLista pl join pl.parametroGrupos pg where pg.id = :idParametroGrupo")
	List<ParametroLista> buscarParametroListaDeParametroGrupo(@RequestParam("idParametroGrupo") Long idParametroGrupo);
	
}