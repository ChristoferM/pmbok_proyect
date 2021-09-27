package com.tesis.v1.service;

import com.tesis.v1.domain.pdp.Entradas;
import com.tesis.v1.dto.pdp.EntradasDTO;

public interface entradasPdpService extends GenericService<Entradas, Integer> {
	Entradas BuscarEntradasPdpPorIdDelProyecto(Integer id) throws Exception;

	EntradasDTO guardarEntradaDelpdp(EntradasDTO entradasDTO) throws Exception;
}
