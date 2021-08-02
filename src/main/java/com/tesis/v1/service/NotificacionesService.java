package com.tesis.v1.service;

import java.util.List;
import java.util.Optional;

import com.tesis.v1.domain.notificaciones;

public interface NotificacionesService extends GenericService<notificaciones,Integer> {
	
	public List<notificaciones> BuscarEnviados(String email) throws Exception;
	
	public List<notificaciones> BuscarRecibidos(String email) throws Exception;
	
}
