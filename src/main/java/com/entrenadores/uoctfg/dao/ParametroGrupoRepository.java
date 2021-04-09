package com.entrenadores.uoctfg.dao;

import com.entrenadores.uoctfg.entity.ParametroGrupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(path = "parametrogrupos")
@CrossOrigin("http://localhost:4200")
public interface ParametroGrupoRepository extends JpaRepository<ParametroGrupo, Long> {
}