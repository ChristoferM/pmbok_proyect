package com.tesis.v1.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tesis.v1.domain.proyectos;


public interface proyectosRepository extends JpaRepository<proyectos,Integer>{
	
	@Query(value = "SELECT * FROM public.proyectos WHERE  public.proyectos.admin = ?1 ", nativeQuery = true)
	public List<proyectos> finByEmail(String email);
	
	/*
	@Query("SELECT pro FROM public.proyectos  pro WHERE  pro.admin= :id") 
	public Optional<proyectos>finByEmail(@Param("id") String email);*/
	
}
