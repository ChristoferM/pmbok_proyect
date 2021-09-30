package com.tesis.v1.repository.pga;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tesis.v1.domain.pga.pga;

public interface pgaRespository  extends JpaRepository<pga, Integer> {
	
	@Query(value ="select pga.idpga, pga.idreuniones from proyectos,reuniones,pga  " + 
			"	where proyectos.idproyecto=reuniones.idproyecto and  " + 
			"	reuniones.idreuniones= pga.idreuniones and    " + 
			"	proyectos.idproyecto = ?1 "
			, nativeQuery = true)
	public pga findIdPgaForIdProyecto(Integer idProyecto);
	
	
	@Modifying(clearAutomatically = true)
	@Query(value =
			"	INSERT INTO public.pga( idreuniones)  " + 
			"VALUES (  " + 
			"	(select reuniones.idreuniones from reuniones, proyectos   " + 
			"	 WHERE reuniones.idproyecto = proyectos.idproyecto   " + 
			"	 AND proyectos.idproyecto = ?1 ))", nativeQuery = true)
	public void savePgaPorIdProyecto(Integer idProyecto);
	
	
	@Query(value ="SELECT " + 
			"  CASE WHEN " + 
			"    EXISTS ( " + 
			"      	select * from proyectos,reuniones,pga " + 
			"		where proyectos.idproyecto=reuniones.idproyecto and " + 
			"		reuniones.idreuniones= pga.idreuniones and  " + 
			"		proyectos.idproyecto = ?1) " + 
			" THEN " + 
			"    TRUE " + 
			" ELSE " + 
			"    FALSE " + 
			" END;", nativeQuery = true)
	public Boolean validarPga(Integer idProyecto);
	
	@Query(value =" " + 
			"SELECT " + 
			"  CASE WHEN " + 
			"    EXISTS ( " + 
			"      	select * from proyectos,reuniones,pga,entradapga " + 
			"		where proyectos.idproyecto=reuniones.idproyecto and " + 
			"		reuniones.idreuniones= pga.idreuniones and  " + 
			"		pga.idpga =entradapga.idpga and " + 
			"		proyectos.idproyecto = ?1 ) " + 
			" THEN " + 
			"    TRUE " + 
			" ELSE " + 
			"    FALSE " + 
			" END; ", nativeQuery = true)
	public Boolean validarEntradasPga(Integer idProyecto);
	
	@Query(value =" " + 
			"SELECT " + 
			"  CASE WHEN " + 
			"    EXISTS ( " + 
			"      	select * from proyectos,reuniones,pga,herramientaspga " + 
			"		where proyectos.idproyecto=reuniones.idproyecto and " + 
			"		reuniones.idreuniones= pga.idreuniones and  " + 
			"		pga.idpga =herramientaspga.idpga and " + 
			"		proyectos.idproyecto = ?1) " + 
			" THEN " + 
			"    TRUE " + 
			" ELSE " + 
			"    FALSE " + 
			" END;", nativeQuery = true)
	public Boolean validarHerramientasPga(Integer idProyecto);
	
	
	// Nuevos metodos
	
	@Query(value ="select actas.idreuniones from actas where actas.idreuniones in ("
			+ "SELECT reuniones.idreuniones FROM reuniones WHERE  reuniones.idproyecto = ?1 "
			+ ");", nativeQuery = true)
	public Integer buscarIdReunion( Integer idproyecto);
	@Query(value ="select * from pga where pga.idreuniones = ?1 ; ", nativeQuery = true)
	public pga buscarPorIdReunion(Integer idreuniones);

}
