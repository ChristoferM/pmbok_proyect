package com.tesis.v1.service;

import com.tesis.v1.domain.pdp.Herramientas;

public interface herramientasServicePdp extends GenericService<Herramientas,Integer>{
    public Herramientas BuscarHerramientasPdpPorIdDelProyecto(Integer id) throws Exception;
}
