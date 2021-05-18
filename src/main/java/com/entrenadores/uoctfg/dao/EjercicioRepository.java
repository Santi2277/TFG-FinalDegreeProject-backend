package com.entrenadores.uoctfg.dao;

import com.entrenadores.uoctfg.entity.Ejercicio;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import com.entrenadores.uoctfg.projections.InlineEjercicioPerfil;

@RepositoryRestResource(path = "ejercicios", excerptProjection = InlineEjercicioPerfil.class)
@CrossOrigin("http://localhost:4200")
public interface EjercicioRepository extends JpaRepository<Ejercicio, Long> {
	
	@Query("select e from Ejercicio e where lower(e.nombre) like lower (concat('%', :nombre, '%'))"+
			"and lower(e.descripcionCorta) like lower (concat('%', :descripcion, '%'))"+
			"and lower(e.descripcionLarga) like lower (concat('%', :descripcion, '%'))"+
			"and lower(e.creador.nick) like lower (concat('%', :entrenador, '%'))"+
			"and e.id IN (select e from Ejercicio e left join e.parametroListas pl where (:parametrovalor1 = '' or (pl.id like concat('', :parametrovalor1, ''))))"+
			"and e.id IN (select e from Ejercicio e left join e.parametroSublistas psl where (:parametrosubvalor1 = '' or (psl.id like concat('', :parametrosubvalor1, ''))))"+
			"and e.id IN (select e from Ejercicio e left join e.parametroListas pl where (:parametrovalor2 = '' or (pl.id like concat('', :parametrovalor2, ''))))"+
			"and e.id IN (select e from Ejercicio e left join e.parametroSublistas psl where (:parametrosubvalor2 = '' or (psl.id like concat('', :parametrosubvalor2, ''))))"+
			"and e.id IN (select e from Ejercicio e left join e.parametroListas pl where (:parametrovalor3 = '' or (pl.id like concat('', :parametrovalor3, ''))))"+
			"and e.id IN (select e from Ejercicio e left join e.parametroSublistas psl where (:parametrosubvalor3 = '' or (psl.id like concat('', :parametrosubvalor3, ''))))")
	Page<Ejercicio> buscarEjercicio(@RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion,
			@RequestParam("entrenador") String entrenador,
			@RequestParam("parametrovalor1") String parametrovalor1,
			@RequestParam("parametrosubvalor1") String parametrosubvalor1,
			@RequestParam("parametrovalor2") String parametrovalor2,
			@RequestParam("parametrosubvalor2") String parametrosubvalor2,
			@RequestParam("parametrovalor3") String parametrovalor3,
			@RequestParam("parametrosubvalor3") String parametrosubvalor3,
			Pageable pageable);
	
	
}
