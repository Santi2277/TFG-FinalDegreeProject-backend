package com.entrenadores.uoctfg.dao;

import com.entrenadores.uoctfg.entity.Ejercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface EjercicioRepository extends JpaRepository<Ejercicio, Long> {
}
