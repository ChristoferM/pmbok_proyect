package com.tesis.v1.service;

import com.tesis.v1.domain.pdp.Herramientas;
import com.tesis.v1.dto.pdp.EntradasDTO;
import com.tesis.v1.dto.pdp.HerramientasDTO;

public interface herramientasServicePdp extends GenericService<Herramientas,Integer>{
    public Herramientas BuscarHerramientasPdpPorIdDelProyecto(Integer id) throws Exception;
    
    public HerramientasDTO guardarHerramientasDelpdp(HerramientasDTO herramientasDTO) throws Exception;
    
    
}
