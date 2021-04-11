package com.tesis.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tesis.v1.domain.herramientasacta;

public interface herramientasactaRepository extends JpaRepository<herramientasacta,Integer>{

	@Query(value = "SELECT * " + 
			"from  " + 
			"	public.reuniones, public.actas, public.herramientasacta, " + 
			"	public.proyectos " + 
			"WHERE " + 
			"	public.proyectos.idproyecto= ?1 AND " + 
			"	public.proyectos.idproyecto= public.reuniones.idproyecto AND " + 
			"	public.reuniones.idreuniones= public.actas.idreuniones AND " + 
			"	public.actas.idactas = public.herramientasacta.idactas", nativeQuery = true)
	public List<herramientasacta> herramientaDelActa(Integer idProyecto);
}
