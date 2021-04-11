package com.tesis.v1.service;

import java.util.List;

import com.tesis.v1.domain.entradacta;

public interface EntradaActaService extends GenericService<entradacta,Integer> {
	public List<entradacta> entradaDelActa(Integer idProyecto);
}
