package com.tesis.v1.service;

import java.util.List;

import com.tesis.v1.domain.Proyecto;

public interface ProyectoService extends GenericService<Proyecto, Integer> {

    public List<Proyecto> findByEmail(String email) throws Exception;
    
    
    public List<Proyecto> BuscarParticipaciones(String email) throws Exception;

}
