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

import com.tesis.v1.domain.grupo;
import com.tesis.v1.repository.grupoRepository;

@Service
@Scope("singleton")
public class GrupoServiceImpl implements GrupoService {

	private final static Logger log = LoggerFactory.getLogger(GrupoServiceImpl.class);

	@Autowired
	grupoRepository grupoRepository;

	@Override
	@Transactional(readOnly = true)
	public List<grupo> findAll() {
		return grupoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<grupo> findById(Integer id) throws Exception {
		if (id <= 0 || id == null) {
			throw new Exception("error en peticion");
		} else
			return grupoRepository.findById(id);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public grupo save(grupo entity) throws Exception {
		if (entity == null) {
			throw new Exception("error en peticion");
		} else {
			return grupoRepository.save(entity);
		}

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public grupo update(grupo entity) throws Exception {
		if (entity == null) {
			throw new Exception("error en peticion");
		}
		return grupoRepository.save(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		if (grupoRepository.existsById(id)) {

			grupoRepository.deleteById(id);

		} else {
			throw new Exception("Erro: No se reconocio el identificador de grupo");
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {

		return null;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(grupo entity) throws Exception {

	}

	@Override
	public void validate(grupo entity) throws Exception {

	}

}
