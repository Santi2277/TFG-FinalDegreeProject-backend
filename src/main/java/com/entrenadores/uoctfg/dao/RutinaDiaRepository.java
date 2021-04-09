package com.entrenadores.uoctfg.dao;

import com.entrenadores.uoctfg.entity.RutinaDia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(path = "rutinadias")
@CrossOrigin("http://localhost:4200")
public interface RutinaDiaRepository extends JpaRepository<RutinaDia, Long> {

}
