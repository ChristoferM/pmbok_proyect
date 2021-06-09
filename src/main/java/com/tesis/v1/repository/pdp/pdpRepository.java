package com.tesis.v1.repository.pdp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tesis.v1.domain.pdp.Pdp;
import com.tesis.v1.dto.ValidarActaDTO;
import com.tesis.v1.dto.pdp.PdpDTO;
import com.tesis.v1.dto.pdp.ValidarPdpDTO;

public interface pdpRepository  extends JpaRepository<Pdp,Integer>{
	
	
	
	
	@Query(value ="select pdp.idpdp, pdp.idreuniones  from reuniones, proyectos, pdp " + 
			"WHERE reuniones.idproyecto = proyectos.idproyecto  " + 
			"AND reuniones.idreuniones = pdp.idreuniones " + 
			"AND proyectos.idproyecto = ?1 "
			, nativeQuery = true)
	public Pdp findIdPdpForIdProyecto(Integer idProyecto);
	
	
	@Modifying(clearAutomatically = true)
	@Query(value =
			"	INSERT INTO public.pdp( " + 
			"	idreuniones) " + 
			"	VALUES (  " + 
			"		(select reuniones.idreuniones from reuniones, proyectos  " + 
			"				WHERE reuniones.idproyecto = proyectos.idproyecto  " + 
			"				AND proyectos.idproyecto = ?1 ));", nativeQuery = true)
			
	public void savePdpPorIdProyecto(Integer idProyecto);
	
	@Query(value =
			"SELECT " + 
			"  CASE WHEN " + 
			"    EXISTS ( " + 
			"      	select * from proyectos,reuniones,pdp " + 
			"		where proyectos.idproyecto=reuniones.idproyecto and " + 
			"		reuniones.idreuniones= pdp.idreuniones and  " + 
			"		proyectos.idproyecto = ?1 ) " + 
			" THEN " + 
			"    TRUE " + 
			" ELSE " + 
			"    FALSE " + 
			" END;", nativeQuery = true)
	public Boolean validarPdp(Integer idProyecto);
	
	@Query(value =" " + 
			"SELECT " + 
			"  CASE WHEN " + 
			"    EXISTS ( " + 
			"      	select * from proyectos,reuniones,pdp,entradapdp " + 
			"		where proyectos.idproyecto=reuniones.idproyecto and " + 
			"		reuniones.idreuniones= pdp.idreuniones and  " + 
			"		pdp.idpdp =entradapdp.idpdp and " + 
			"		proyectos.idproyecto= ?1) " + 
			" THEN " + 
			"    TRUE " + 
			" ELSE " + 
			"    FALSE " + 
			" END;", nativeQuery = true)
	public Boolean validarEntradaPdp(Integer idProyecto);
	
	@Query(value =" " + 
			"SELECT " + 
			"  CASE WHEN " + 
			"    EXISTS ( " + 
			"      	select * from proyectos,reuniones,pdp,herramientaspdp " + 
			"		where proyectos.idproyecto=reuniones.idproyecto and " + 
			"		reuniones.idreuniones= pdp.idreuniones and  " + 
			"		pdp.idpdp =herramientaspdp.idpdp and " + 
			"		proyectos.idproyecto = ?1) " + 
			" THEN " + 
			"    TRUE " + 
			" ELSE " + 
			"    FALSE " + 
			" END;", nativeQuery = true)
	public Boolean validarHerramientaPdp(Integer idProyecto);
	
}
