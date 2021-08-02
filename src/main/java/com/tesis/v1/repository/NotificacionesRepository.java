package com.tesis.v1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tesis.v1.domain.notificaciones;

public interface NotificacionesRepository extends JpaRepository<notificaciones, Integer> {
	
	@Query(value ="SELECT * FROM notificaciones WHERE notificaciones.receptor = ?1", nativeQuery = true)
	public List<notificaciones> BuscarEnviados(String email);
	
	@Query(value ="SELECT * FROM notificaciones WHERE notificaciones.emisor = ?1 ", nativeQuery = true)
	public List<notificaciones> BuscarRecibidos(String email);

}
