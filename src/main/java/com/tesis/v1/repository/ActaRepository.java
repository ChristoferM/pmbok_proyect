package com.tesis.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tesis.v1.domain.Acta;

public interface ActaRepository  extends JpaRepository<Acta,Integer>{
	
	@Query(value ="select * from actas where actas.idreuniones = ?1 ; ", nativeQuery = true)
	public Acta buscarPorIdReunion(Integer idreuniones);
	
	
	@Query(value ="select * from actas where actas.idreuniones = (SELECT reuniones.idreuniones  " + 
			"		FROM reuniones, proyectos  " + 
			"		WHERE reuniones.idproyecto = proyectos.idproyecto  " + 
			"		AND proyectos.idproyecto= ?1 limit 1);", nativeQuery = true)
	public Acta buscarIdActaPorProyecto(Integer idreuniones);

}
