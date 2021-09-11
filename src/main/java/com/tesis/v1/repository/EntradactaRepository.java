package com.tesis.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tesis.v1.domain.Entradacta;

public interface EntradactaRepository extends JpaRepository<Entradacta,Integer>{
	
	
	@Query(value ="select entradacta.identrada from proyectos,reuniones,actas,entradacta " + 
			"		where proyectos.idproyecto=reuniones.idproyecto and " + 
			"		reuniones.idreuniones= actas.idreuniones and  " + 
			"		actas.idactas =entradacta.idactas and " + 
			"		proyectos.idproyecto= ?1", nativeQuery = true)
	public Integer valorIdEntraActa(Integer idProyecto);
	
	@Query(value ="SELECT actas.idactas FROM proyectos,reuniones,actas " + 
			"		WHERE proyectos.idproyecto=reuniones.idproyecto AND " + 
			"		reuniones.idreuniones= actas.idreuniones AND  " + 
			"		proyectos.idproyecto = ?1 ", nativeQuery = true)
	public Integer valorIdActa  (Integer idProyecto);

	@Query(value = "SELECT *" +
			"from " + 
			"	public.reuniones, public.actas,public.entradacta , public.proyectos " + 
			"WHERE " + 
			"	public.proyectos.idproyecto= ?1 AND " + 
			"	public.proyectos.idproyecto= public.reuniones.idproyecto AND " + 
			"	public.reuniones.idreuniones= public.actas.idreuniones AND " + 
			"	public.actas.idactas = public.entradacta.idactas  " + 
			"	", nativeQuery = true)
	public List<Entradacta> entradaDelActa(Integer idProyecto);
	
	@Query(value ="SELECT " + 
			"  CASE WHEN " + 
			"    EXISTS ( " + 
			"      	select * from proyectos,reuniones,actas " + 
			"		where proyectos.idproyecto=reuniones.idproyecto and " + 
			"		reuniones.idreuniones= actas.idreuniones and  " + 
			"		proyectos.idproyecto=?1) " + 
			" THEN " + 
			"    TRUE " + 
			" ELSE " + 
			"    FALSE " + 
			" END;", nativeQuery = true)
	public Boolean validarActa(Integer idProyecto) ;
	
	
	@Query(value ="SELECT " + 
			"  CASE WHEN " + 
			"    EXISTS ( " + 
			"      	select * from proyectos,reuniones,actas,entradacta " + 
			"		where proyectos.idproyecto=reuniones.idproyecto and " + 
			"		reuniones.idreuniones= actas.idreuniones and  " + 
			"		actas.idactas =entradacta.idactas and " + 
			"		proyectos.idproyecto=?1) " + 
			" THEN " + 
			"    TRUE " + 
			" ELSE " + 
			"    FALSE " + 
			" END;", nativeQuery = true)
	public Boolean validarEntrada(Integer idProyecto);
	
	
	@Query(value ="SELECT " + 
			"  CASE WHEN " + 
			"    EXISTS ( " + 
			"      	select * from proyectos,reuniones,actas,herramientasacta " + 
			"		where proyectos.idproyecto=reuniones.idproyecto and " + 
			"		reuniones.idreuniones= actas.idreuniones and  " + 
			"		actas.idactas =herramientasacta.idactas and " + 
			"		proyectos.idproyecto=?1) " + 
			" THEN " + 
			"    TRUE " + 
			" ELSE " + 
			"    FALSE " + 
			" END; ", nativeQuery = true)
	public Boolean validarHerramienta(Integer idProyecto);
	
	
	@Query(value ="SELECT " + 
			"  CASE WHEN " + 
			"    EXISTS ( " + 
			"      	select * from proyectos,reuniones,actas,entradacta,casonegocio " + 
			"		where proyectos.idproyecto=reuniones.idproyecto and " + 
			"		reuniones.idreuniones= actas.idreuniones and  " + 
			"		actas.idactas =entradacta.idactas and " + 
			"		entradacta.identrada =casonegocio.identrada and " + 
			"		proyectos.idproyecto=?1) " + 
			" THEN " + 
			"    TRUE " + 
			" ELSE " + 
			"    FALSE " + 
			" END;", nativeQuery = true)
	public Boolean validarCasoNegocio(Integer idProyecto);
	
	
	@Query(value ="SELECT " + 
			"  CASE WHEN " + 
			"    EXISTS ( " + 
			"      	select * from proyectos,reuniones,actas,entradacta,planesgestionbeneficios " + 
			"		where proyectos.idproyecto=reuniones.idproyecto and " + 
			"		reuniones.idreuniones= actas.idreuniones and  " + 
			"		actas.idactas =entradacta.idactas and " + 
			"		entradacta.identrada =planesgestionbeneficios.identrada and " + 
			"		proyectos.idproyecto=?1) " + 
			" THEN " + 
			"    TRUE " + 
			" ELSE " + 
			"    FALSE " + 
			" END;", nativeQuery = true)
	public Boolean validarHPlanGestion (Integer idProyecto);

	// @Query(value ="SELECT reuniones.idreuniones FROM reuniones WHERE reuniones.idfase = ?1 AND reuniones.idproyecto = ?2 ; ", nativeQuery = true)
	@Query(value ="select actas.idreuniones from actas where actas.idreuniones in ("
			+ "SELECT reuniones.idreuniones FROM reuniones WHERE  reuniones.idproyecto = ?1 "
			+ ");", nativeQuery = true)
	public Integer buscarIdReunion( Integer idproyecto);
	
	@Query(value ="SELECT * FROM entradacta WHERE entradacta.idactas IN  (  " + 
			"	SELECT actas.idactas FROM actas WHERE actas.idreuniones IN (   " + 
			"		SELECT reuniones.idreuniones FROM reuniones, proyectos   " + 
			"			WHERE reuniones.idproyecto = proyectos.idproyecto    " + 
			"			AND proyectos.idproyecto= ?1 ) );", nativeQuery = true)
	public List<Entradacta> BuscarDatosDeEntradas( Integer idproyecto);
	
	
}
