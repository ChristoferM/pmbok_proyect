package com.tesis.v1.service;

import java.util.List;

import com.tesis.v1.domain.pga.entradapga;
import com.tesis.v1.dto.pga.entradapgaDTO;

public interface pgaEntradasServices  extends GenericService<entradapga,Integer>{
	List<entradapgaDTO>  BuscarEntradasPGAPorIdDelProyecto(Integer id) throws Exception;
	
	entradapgaDTO guardarEntradaDelPga(entradapgaDTO entradasDTO) throws Exception;
	
	List<entradapgaDTO> BuscarDatosDeEntradasDePga( entradapgaDTO herramientasDTO) throws Exception;

}
