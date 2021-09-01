package com.tesis.v1.service;

import java.util.List;

import com.tesis.v1.domain.Entradacta;
import com.tesis.v1.dto.EntradaDelActaDTO;
import com.tesis.v1.dto.ValidarActaDTO;

public interface EntradaActaService extends GenericService<Entradacta,Integer> {
	public List<Entradacta> entradaDelActa(Integer idProyecto);
	
	public ValidarActaDTO encontrarData(Integer idProyecto);
	
	public Integer valorIdActa(Integer idProyecto) ;
	
	public Integer valorIdEntraActa(Integer idProyecto) ;
	
	public List<Entradacta> BuscarDatosDeEntradas(EntradaDelActaDTO EntradactaDTO);
	
	public Entradacta guardarEntradaDelActa(EntradaDelActaDTO EntradactaDTO);
	
	public Entradacta actualiazrEntradaDelActa(EntradaDelActaDTO EntradactaDTO);
	
}