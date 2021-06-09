package com.tesis.v1.repository.pga;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tesis.v1.domain.pga.herramientaspga;

public interface herramientasPgaRepository  extends JpaRepository<herramientaspga,Integer> {


    @Query(value ="SELECT  " + 
			"herramientaspga.* " + 
			"			FROM proyectos, reuniones, pga, herramientaspga  " + 
			"				where  " + 
			"				proyectos.idproyecto = reuniones.idproyecto AND  " + 
			"				reuniones.idreuniones = pga.idreuniones AND  " + 
			"				 pga.idpga = herramientaspga.idpga  AND  " + 
			"				proyectos.idproyecto =  ?1 ", nativeQuery = true)
	public herramientaspga BuscarHerramientasPGAPorIdDelProyecto(Integer idProyecto);
    
}
