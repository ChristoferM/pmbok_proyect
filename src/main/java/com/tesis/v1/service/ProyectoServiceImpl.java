package com.tesis.v1.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesis.v1.domain.proyectos;
import com.tesis.v1.repository.proyectosRepository;
import com.tesis.v1.repository.usuariosRepository;

@Service
@Scope("singleton")
public class ProyectoServiceImpl implements ProyectoService {

	@Autowired
	proyectosRepository proyectosRepository;

	@Autowired
	usuariosRepository usuariosRepository;

	private final static Logger log = LoggerFactory.getLogger(ProyectoServiceImpl.class);

	@Override
	@Transactional(readOnly = true)
	public List<proyectos> findByEmail(String email) throws Exception {
		log.info("EL CORREO ES -> " + email);

		// Optional<proyectos> proyectoOpt = proyectosRepository.finByEmail(email);
		List<proyectos> poryectosList = proyectosRepository.finByEmail(email);
		if (poryectosList == null || poryectosList.size() == 0) {
			return null;

		} else
			return poryectosList;
	}

	@Override
	@Transactional(readOnly = true)
	public List<proyectos> findAll() {
		List<proyectos> poryectosList = proyectosRepository.findAll();
		if (poryectosList == null || poryectosList.size() == 0) {
			return null;

		} else
			return poryectosList;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<proyectos> findById(Integer id) throws Exception {
		Optional<proyectos> proyectoOpt = proyectosRepository.findById(id);
		if (proyectoOpt.isPresent()) {
			return proyectoOpt;

		} else {
			throw new Exception("El No se encontro Proyectos : Posible Problemas con el identifcador ");
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public proyectos save(proyectos entity) throws Exception {
		if (entity == null) {
			throw new Exception("Error en los datos");

		}
		if (usuariosRepository.existsById(entity.getAdmin())) {
			return proyectosRepository.save(entity);
		} else {
			throw new Exception("Error: Usuario No Valido");
		}

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public proyectos update(proyectos entity) throws Exception {
		if (proyectosRepository.existsById(entity.getIdproyecto()) == false) {
			throw new Exception("el proyecto No se encontro");
		}
		return proyectosRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(proyectos entity) throws Exception {

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(Integer id) throws Exception {
		if (id == null || id <= 0) {
			throw new Exception("El Identificador es obligatoria");
		}
		if (proyectosRepository.existsById(id)) {
			proyectosRepository.deleteById(id);
		} else {
			throw new Exception("El product con id :" + id + " no existe");
		}
	}

	@Override
	public void validate(proyectos entity) throws Exception {

	}

	@Override
	public Long count() {

		return null;
	}

}
