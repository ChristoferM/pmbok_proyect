package com.tesis.v1.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesis.v1.domain.actas;
import com.tesis.v1.repository.actasRepository;
import com.tesis.v1.repository.reunionesRepository;

@Service
@Scope("singleton")
public class ActaServiceImpl implements ActaService {

	private final static Logger log = LoggerFactory.getLogger(ActaServiceImpl.class);

	@Autowired
	actasRepository actasRepository;
	@Autowired
	reunionesRepository reunionesRepository;

	@Override
	@Transactional(readOnly = true)
	public List<actas> findAll() {

		return actasRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<actas> findById(Integer id) throws Exception {
		if (id < 0 || id == null) {
			throw new Exception("error en el identificador");
		}
		return actasRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = false,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void delete(actas entity) throws Exception {
		if (entity == null) {
			throw new Exception("El shoppingCart es nulo");
		}

		if (entity.getReuniones() == null || entity.getReuniones().getIdreuniones()< 0) {
			throw new Exception("ERROR ES SERVICIOS");
		}
		actasRepository.deleteById(entity.getIdactas());

	}


	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public actas save(actas entity) throws Exception {
		if (entity == null) {
			throw new Exception("error en peticion");
		}
		log.info(entity.getReuniones().toString());

		return actasRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public actas update(actas entity) throws Exception {
		if (entity == null) {
			throw new Exception("error en peticion");
		}
		return actasRepository.save(entity);
	}


	@Override
	public void deleteById(Integer id) throws Exception {

	}

	@Override
	public void validate(actas entity) throws Exception {
		if (entity == null) {
			throw new Exception("error en peticion");
		}
	}
	@Override
	@Transactional(readOnly = true)
	public Long count() {

		return null;
	}
}
