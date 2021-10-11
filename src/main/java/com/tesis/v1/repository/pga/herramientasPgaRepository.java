package com.tesis.v1.repository.pga;

import java.util.List;

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
	public List<herramientaspga> BuscarHerramientasPGAPorIdDelProyecto(Integer idProyecto);

    
    
    // METODOS NUEVOS PARA LA BUSCAQUEDAD DE DATOS DEL PGA 
	@Query(value ="SELECT * FROM herramientaspga WHERE herramientaspga.idpga IN  (" + 
			"			SELECT pga.idpga FROM pga WHERE pga.idreuniones IN (" + 
			"			SELECT reuniones.idreuniones FROM reuniones, proyectos" + 
			"			WHERE reuniones.idproyecto = proyectos.idproyecto" + 
			"			AND proyectos.idproyecto= ?1 ) );", nativeQuery = true)
	
	 public List<herramientaspga> BuscarDatosDeHerramientasPGA( Integer idproyecto);
}
