package com.entrenadores.uoctfg.dao;

import com.entrenadores.uoctfg.entity.RutinaDiaEjercicioMedidaParametroEjercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(path = "rutinadiaejerciciomedidaparametroejercicios")
@CrossOrigin("http://localhost:4200")
public interface RutinaDiaEjercicioMedidaParametroEjercicioRepository extends JpaRepository<RutinaDiaEjercicioMedidaParametroEjercicio, Long> {

}
