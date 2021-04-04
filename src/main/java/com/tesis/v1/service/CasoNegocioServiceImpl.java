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

import com.tesis.v1.domain.casonegocio;
import com.tesis.v1.domain.entradacta;
import com.tesis.v1.repository.casonegocioRepository;

@Service
@Scope("singleton")
public class CasoNegocioServiceImpl implements CasoNegocioService {

	@Autowired
	casonegocioRepository casoNegocioRepository;
	@Autowired
	EntradaActaService EntradaActaService;

	private final static Logger log = LoggerFactory.getLogger(CasoNegocioServiceImpl.class);

	@Override
	@Transactional(readOnly = true)
	public List<casonegocio> findAll() {
		return casoNegocioRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return casoNegocioRepository.count();
	}
	
	

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public casonegocio save(casonegocio entity) throws Exception {
		Optional<entradacta> entradacta = EntradaActaService.findById(entity.getEntradacta().getIdentrada());
		// entity.setEntradacta(entradacta.get());
		log.info("********************"+entity.getEntradacta().getIdentrada().toString());

		if (entradacta.isEmpty()) {
			throw new Exception("No se reconoce el identificador del ACTA");
		}
		log.info(entity.getEntradacta().getIdentrada().toString());
		return casoNegocioRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public casonegocio update(casonegocio entity) throws Exception {
		if (casoNegocioRepository.existsById(entity.getId_caso_negocio()) == false) {
			throw new Exception("El caso negocio  con Id +" + entity.getId_caso_negocio() + "ya existe");
		}
		return casoNegocioRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<casonegocio> findById(Integer id) throws Exception {
		return casoNegocioRepository.findById(id);
	}

	public void deleteById(Integer id) throws Exception {
		if (id == null || id <= 0) {
			throw new Exception("El  id es obligatorio");
		}

		if (casoNegocioRepository.existsById(id)) {
			try {
				Optional<casonegocio> caso = casoNegocioRepository.findById(id);
				casoNegocioRepository.delete(caso.get());

			} catch (Exception e) {
				throw new Exception("error" + e);
			}

		} else {
			throw new Exception("El caso negocio con id: " + id + " No existe");
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(casonegocio entity) throws Exception {
		if (entity == null) {
			throw new Exception("La entrada acta es nulo");
		}
		if (entity.getId_caso_negocio() == null || entity.getId_caso_negocio() <= 0) {
			throw new Exception("La id es obligatoria");

		}
		if (casoNegocioRepository.existsById(entity.getId_caso_negocio()) == false) {
			throw new Exception(
					"La entrada acta  con id " + entity.getId_caso_negocio() + " No existe (No se puede eliminar)");
		}

		casoNegocioRepository.deleteById(entity.getId_caso_negocio());

	}

	@Override
	public void validate(casonegocio entity) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public casonegocio save(casonegocio entity, Integer idEntrada) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}
