package com.tesis.v1.repository;


import java.util.List;
 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tesis.v1.domain.Proyecto;


public interface ProyectoRepository extends JpaRepository<Proyecto,Integer>{
	
	@Query(value = "SELECT * FROM public.proyectos WHERE  public.proyectos.admin = ?1 ", nativeQuery = true)
	public List<Proyecto> finByEmail(String email);
	
	/*
	@Query("SELECT pro FROM public.Proyecto  pro WHERE  pro.admin= :id") 
	public Optional<proyectos>finByEmail(@Param("id") String email);*/
	
}