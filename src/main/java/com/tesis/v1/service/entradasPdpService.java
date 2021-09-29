package com.tesis.v1.service;

import java.util.List;

import com.tesis.v1.domain.pdp.Entradas;
import com.tesis.v1.dto.pdp.EntradasDTO;
import com.tesis.v1.dto.pdp.HerramientasDTO;

public interface entradasPdpService extends GenericService<Entradas, Integer> {
	Entradas BuscarEntradasPdpPorIdDelProyecto(Integer id) throws Exception;

	EntradasDTO guardarEntradaDelpdp(EntradasDTO entradasDTO) throws Exception;
	
	List<EntradasDTO> BuscarDatosDeEntradasDePDP( HerramientasDTO herramientasDTO) throws Exception;
}
