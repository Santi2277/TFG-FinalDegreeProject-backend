package com.entrenadores.uoctfg.dao;

import com.entrenadores.uoctfg.entity.Multimedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(path = "multimedias")
@CrossOrigin("http://localhost:4200")
public interface MultimediaRepository extends JpaRepository<Multimedia, Long> {

}
