package com.tesis.v1.repository.pdp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tesis.v1.domain.pdp.Herramientas;

public interface herramientasPdpRepository extends JpaRepository<Herramientas,Integer>{


    @Query(value ="SELECT  " + 
			"herramientaspdp.*"+ 
			"FROM " + 
			"	proyectos, reuniones, pdp, herramientaspdp" + 
			"	where " + 
			"	proyectos.idproyecto = reuniones.idproyecto AND " + 
			"	reuniones.idreuniones = pdp.idreuniones AND  " + 
			"	 pdp.idpdp =  herramientaspdp.idpdp AND " + 
			"	proyectos.idproyecto = ?1  "
			, nativeQuery = true)
	public List <Herramientas> BuscarHerramientasPdpPorIdDelProyecto(Integer idProyecto);
    
    
	@Query(value ="select actas.idreuniones from actas where actas.idreuniones in ("
			+ "SELECT reuniones.idreuniones FROM reuniones WHERE  reuniones.idproyecto = ?1 "
			+ ");", nativeQuery = true)
	public Integer buscarIdReunion( Integer idproyecto);
	
	
	@Query(value ="SELECT * FROM herramientaspdp WHERE herramientaspdp.idpdp IN  ( " + 
			"				SELECT pdp.idpdp FROM pdp WHERE pdp.idreuniones IN (   \r\n" + 
			"					SELECT reuniones.idreuniones FROM reuniones, proyectos    \r\n" + 
			"						WHERE reuniones.idproyecto = proyectos.idproyecto     \r\n" + 
			"						AND proyectos.idproyecto= ?1 ) );", nativeQuery = true)
	public List<Herramientas> BuscarDatosDeHerramientasPdp( Integer idproyecto);
	
}
