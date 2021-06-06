package com.tesis.v1.service;

import com.tesis.v1.domain.pdp.Pdp;
import com.tesis.v1.dto.pdp.PdpDTO;
import com.tesis.v1.dto.pdp.ValidarPdpDTO;

public interface pdpService extends GenericService<Pdp,Integer>{

	public ValidarPdpDTO encontrarData(Integer idProyecto);
	
	public Pdp savePdpPorIdProyecto(Integer idProyecto) throws Exception ;
	
	public Pdp BuscarPdpPorIdProyecto(Integer idProyecto) throws Exception ;
}
