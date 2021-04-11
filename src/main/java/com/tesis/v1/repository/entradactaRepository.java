package com.tesis.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tesis.v1.domain.entradacta;

public interface entradactaRepository extends JpaRepository<entradacta,Integer>{

	@Query(value = "SELECT *" +
			"from " + 
			"	public.reuniones, public.actas,public.entradacta , public.proyectos " + 
			"WHERE " + 
			"	public.proyectos.idproyecto= ?1 AND " + 
			"	public.proyectos.idproyecto= public.reuniones.idproyecto AND " + 
			"	public.reuniones.idreuniones= public.actas.idreuniones AND " + 
			"	public.actas.idactas = public.entradacta.idactas  " + 
			"	", nativeQuery = true)
	public List<entradacta> entradaDelActa(Integer idProyecto);
}
