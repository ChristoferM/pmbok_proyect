package com.tesis.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tesis.v1.domain.FaseProyecto;

public interface FaseProyectoRepository extends JpaRepository<FaseProyecto,Integer>{
	
	//@Query(value ="", nativeQuery = true)
	// public Boolean  responsablesEnFaseoReunionValidacion(Integer idfase,String email);


}
