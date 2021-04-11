package com.tesis.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tesis.v1.domain.planesgestionbeneficios;

public interface planesgestionbeneficiosRepository extends JpaRepository<planesgestionbeneficios, Integer> {

	
	@Query(value = "SELECT  *" + 
			"	 " + 
			"from  " + 
			"	public.reuniones, public.actas, public.herramientasacta, " + 
			"	public.entradacta, public.planesgestionbeneficios, " + 
			"	public.proyectos " + 
			"WHERE " + 
			"	public.proyectos.idproyecto= 1 AND " + 
			"	public.proyectos.idproyecto= public.reuniones.idproyecto AND " + 
			"	public.reuniones.idreuniones= public.actas.idreuniones AND " + 
			"	public.actas.idactas = public.entradacta.idactas and " + 
			"	public.entradacta.identrada= public.planesgestionbeneficios.identrada; " , nativeQuery = true)
	public List<planesgestionbeneficios> planGestionDelActa(Integer idProyecto);
}
