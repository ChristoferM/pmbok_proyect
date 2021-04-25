package com.tesis.v1.service;

import java.util.List;

import com.tesis.v1.domain.entradacta;
import com.tesis.v1.dto.validarActa;

public interface EntradaActaService extends GenericService<entradacta,Integer> {
	public List<entradacta> entradaDelActa(Integer idProyecto);
	
	public validarActa encontrarData(Integer idProyecto);
	
	public Integer valorIdActa(Integer idProyecto) ;
	
	public Integer valorIdEntraActa(Integer idProyecto) ;
	
}
