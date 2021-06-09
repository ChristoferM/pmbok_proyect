package com.tesis.v1.repository.pga;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tesis.v1.domain.pga.entradapga;

public interface entradaPgaRepository  extends JpaRepository<entradapga,Integer> {


    @Query(value ="SELECT  " + 
			"entradapga.identradapga, " + 
			"entradapga.estandares, " + 
			"entradapga.objetivocalidad, " + 
			"entradapga.ciclo, " + 
			"entradapga.enfoque," +
			"entradapga.activosprocesos, " + 
			"entradapga.idpga " + 
			"FROM proyectos, reuniones, pga, entradapga " + 
			"	where " + 
			"	proyectos.idproyecto = reuniones.idproyecto AND " + 
			"	reuniones.idreuniones = pga.idreuniones AND  " + 
			"	 pga.idpga = entradapga.idpga  AND " + 
			"	proyectos.idproyecto =  ?1 "
			, nativeQuery = true)
	public entradapga BuscarEntradasPGAPorIdDelProyecto(Integer idProyecto);

    
}
