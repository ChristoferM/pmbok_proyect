package com.tesis.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tesis.v1.domain.Grupo;
import com.tesis.v1.domain.Reunion;

public interface ReunionRepository extends JpaRepository<Reunion, Integer> {

	@Query(value ="SELECT * FROM reuniones WHERE reuniones.idproyecto = ?1 ;", nativeQuery = true)
	public  List<Reunion>reunionPorIdProyecto(Integer idProyecto);
	

	
}
