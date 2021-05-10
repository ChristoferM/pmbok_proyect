package com.tesis.v1.service;

import java.util.List;

import com.tesis.v1.domain.proyectos;

public interface ProyectoService  extends GenericService<proyectos, Integer> {

	public List<proyectos> findByEmail(String email) throws Exception;

}
