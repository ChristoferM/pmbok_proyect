package com.tesis.v1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesis.v1.domain.notificaciones;
import com.tesis.v1.repository.NotificacionesRepository;
import com.tesis.v1.repository.UsuarioRepository;

@Service
@Scope("singleton")
public class NotificacionesServiceImpl implements NotificacionesService {

	@Autowired
	NotificacionesRepository notificacionesRepository;
	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	@Transactional(readOnly = true)
	public List<notificaciones> findAll() {

		return notificacionesRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<notificaciones> findById(Integer id) throws Exception {

		return notificacionesRepository.findById(id);
	}

	@Override
	public Long count() {

		return notificacionesRepository.count();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public notificaciones save(notificaciones entity) throws Exception {

		if (usuarioRepository.existsById(entity.getReceptor()) && usuarioRepository.existsById(entity.getEmisor())) {
			// Se validan que los 2 usuarios Existan
			return notificacionesRepository.save(entity);
		} else {
			throw new Exception("{\"success\":false,\"status\":error, \"message\": Error en los datos }");
		}

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public notificaciones update(notificaciones entity) throws Exception {
		Optional<notificaciones> entity2 = findById(entity.getIdnotificaciones());
		if (entity2.isEmpty()) {
			throw new Exception("{\"success\":false,\"status\":error, \"message\": No existe la notificacion  }");
		}

		if (entity2.get().getEstado() != true && entity2.get().getEmisor() == entity.getEmisor()
				&& entity2.get().getReceptor() == entity.getReceptor()) {
			if (notificacionesRepository.existsById(entity.getIdnotificaciones())) {
				// Se validan que los 2 usuarios Existan
				entity.setEstado(true); // se Quema el set por si existe algun error con el servicio
				return notificacionesRepository.save(entity);
			} else {
				throw new Exception("{\"success\":false,\"status\":error, \"message\": Error en los datos }");
			}

		} else {
			throw new Exception("{ \"success\":false,\"status\":error, \"message\": Estado Ya modificado }");
		}
	}

	@Override
	public void delete(notificaciones entity) throws Exception {

	}

	@SuppressWarnings("null")
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(Integer id) throws Exception {
		if (id != null || id >= 1) {
			notificacionesRepository.deleteById(id);
		} else {
			throw new Exception("{\"success\":false,\"status\":error, \"message\": Error en los datos }");
		}

	}

	@Override
	public void validate(notificaciones entity) throws Exception {

		if (entity == null) {
			throw new Exception("Error Al momento de crear la notificacion");
		}
		if (entity.getEmisor() == "" || entity.getEmisor().isEmpty()) {
			throw new Exception("Erro; No se encontro el emisor");

		}
		if (entity.getReceptor() == "" || entity.getReceptor().isEmpty()) {
			throw new Exception("Erro; No se encontro el receptor");
		}
		if (entity.getMensaje() == "" || entity.getMensaje().isEmpty()) {
			throw new Exception("Erro; No Posee mensaje la notificacion");
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<notificaciones> BuscarEnviados(String email) throws Exception {
		if (usuarioRepository.existsById(email)) {
			return notificacionesRepository.BuscarEnviados(email);
		} else {
			throw new Exception("{\"success\":false,\"status\":error, \"message\": Error en los datos }");
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<notificaciones> BuscarRecibidos(String email) throws Exception {

		if (usuarioRepository.existsById(email)) {
			return notificacionesRepository.BuscarRecibidos(email);
		} else {
			throw new Exception("{\"success\":false,\"status\":error, \"message\": Error en los datos }");
		}
	}

}
