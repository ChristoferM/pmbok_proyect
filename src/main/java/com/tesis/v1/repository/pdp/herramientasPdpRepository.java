package com.tesis.v1.repository.pdp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tesis.v1.domain.pdp.Herramientas;

public interface herramientasPdpRepository extends JpaRepository<Herramientas,Integer>{


    @Query(value ="SELECT  " + 
			"herramientaspdp.idherramienta , " + 
			"herramientaspdp.juicioexpertos , " + 
			"herramientaspdp.recopilaciondatos, " + 
			"herramientaspdp.habilidades, " + 
			"herramientaspdp.herramientareuniones, " + 
			"herramientaspdp.idpdp " + 
			"FROM " + 
			"	proyectos, reuniones, pdp, herramientaspdp" + 
			"	where " + 
			"	proyectos.idproyecto = reuniones.idproyecto AND " + 
			"	reuniones.idreuniones = pdp.idreuniones AND  " + 
			"	 pdp.idpdp =  herramientaspdp.idpdp AND " + 
			"	proyectos.idproyecto = ?1  "
			, nativeQuery = true)
	public Herramientas BuscarHerramientasPdpPorIdDelProyecto(Integer idProyecto);
    
    
	@Query(value ="select actas.idreuniones from actas where actas.idreuniones in ("
			+ "SELECT reuniones.idreuniones FROM reuniones WHERE  reuniones.idproyecto = ?1 "
			+ ");", nativeQuery = true)
	public Integer buscarIdReunion( Integer idproyecto);
}
