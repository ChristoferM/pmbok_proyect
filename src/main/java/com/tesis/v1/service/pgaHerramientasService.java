package com.tesis.v1.service;

import com.tesis.v1.domain.pga.herramientaspga;

public interface pgaHerramientasService extends GenericService<herramientaspga,Integer>{
    public herramientaspga BuscarHerramientasPGAPorIdDelProyecto(Integer id) throws Exception;
}
