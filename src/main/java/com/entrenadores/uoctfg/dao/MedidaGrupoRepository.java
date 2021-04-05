package com.entrenadores.uoctfg.dao;

import com.entrenadores.uoctfg.entity.MedidaGrupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface MedidaGrupoRepository extends JpaRepository<MedidaGrupo, Long> {

}
