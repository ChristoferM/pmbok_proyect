package com.tesis.v1.service;

import com.tesis.v1.domain.pdp.Pdp;
import com.tesis.v1.domain.pga.pga;
import com.tesis.v1.dto.pdp.ValidarPdpDTO;
import com.tesis.v1.dto.pga.ValidarPgaDTO;


public interface pgaServices  extends GenericService<pga,Integer>{
	public ValidarPgaDTO encontrarData(Integer idProyecto);
	
	public pga savePgaPorIdProyecto(Integer idProyecto) throws Exception ;
	
	public pga BuscarPgaPorIdProyecto(Integer idProyecto) throws Exception ;
}
