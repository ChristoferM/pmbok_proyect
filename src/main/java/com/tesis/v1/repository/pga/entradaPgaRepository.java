package com.tesis.v1.repository.pga;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tesis.v1.domain.pga.entradapga;

public interface entradaPgaRepository  extends JpaRepository<entradapga,Integer> {


    @Query(value ="SELECT  " + 
			"entradapga.*" + 
			"FROM proyectos, reuniones, pga, entradapga " + 
			"	where " + 
			"	proyectos.idproyecto = reuniones.idproyecto AND " + 
			"	reuniones.idreuniones = pga.idreuniones AND  " + 
			"	 pga.idpga = entradapga.idpga  AND " + 
			"	proyectos.idproyecto =  ?1 "
			, nativeQuery = true)
	public 	List<entradapga> BuscarEntradasPGAPorIdDelProyecto(Integer idProyecto);
    
    
    
    
    // METODOS NUEVOS PARA LA BUSCAQUEDAD DE DATOS DEL PGA 
	@Query(value ="SELECT * FROM entradapga WHERE entradapga.idpga IN  (" + 
			"		SELECT pga.idpga FROM pga WHERE pga.idreuniones IN (" + 
			"		SELECT reuniones.idreuniones FROM reuniones, proyectos" + 
			"			WHERE reuniones.idproyecto = proyectos.idproyecto" + 
			"		AND proyectos.idproyecto= ?1 ) );", nativeQuery = true)
	public List<entradapga> BuscarDatosDeEntradasPGA( Integer idproyecto);

    
}
