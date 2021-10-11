package com.tesis.v1.service;

import java.util.List;

import com.tesis.v1.domain.pga.herramientaspga;
import com.tesis.v1.dto.pga.herramientaspgaDTO;

public interface pgaHerramientasService extends GenericService<herramientaspga, Integer> {

	public List<herramientaspgaDTO> BuscarHerramientasPGAPorIdDelProyecto(Integer id) throws Exception;

	herramientaspgaDTO guardarHerramientasDelPga(herramientaspgaDTO herramientasDTO) throws Exception;

	List<herramientaspgaDTO> BuscarDatosDeHerramientasDePga(herramientaspgaDTO herramientasDTO) throws Exception;

}
