package com.tesis.v1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesis.v1.domain.pga.pga;
import com.tesis.v1.dto.pdp.ValidarPdpDTO;
import com.tesis.v1.dto.pga.ValidarPgaDTO;
import com.tesis.v1.repository.pga.pgaRespository;

@Service
@Scope("singleton")
public class pgaServiceImpl implements pgaServices {

	@Autowired
	pgaRespository pgaRespository;

	@Override
	@Transactional(readOnly = true)
	public List<pga> findAll() {
		// TODO Auto-generated method stub
		return pgaRespository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<pga> findById(Integer id) throws Exception {
		return pgaRespository.findById(id);
	}

	@Override
	public Long count() {
		return pgaRespository.count();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public pga save(pga entity) throws Exception {
		return pgaRespository.save(entity);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public pga update(pga entity) throws Exception {
		return pgaRespository.save(entity);
	}

	@Override
	public void delete(pga entity) throws Exception {

		if (entity == null) {
			throw new Exception("La entrada acta es nulo");
		}
		if (entity.getIdpga() == null || entity.getIdpga() <= 0) {
			throw new Exception("La id es obligatoria");

		}
		if (pgaRespository.existsById(entity.getIdpga()) == false) {
			throw new Exception("La entrada acta  con id No existe (No se puede eliminar)");
		}
		pgaRespository.deleteById(entity.getIdpga());

	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void validate(pga entity) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public ValidarPgaDTO encontrarData(Integer idProyecto) {
		ValidarPgaDTO validarPdpDTO = new ValidarPgaDTO();
		validarPdpDTO.setPga(pgaRespository.validarPga(idProyecto));
		validarPdpDTO.setEntradactaPgaValidate(pgaRespository.validarEntradasPga(idProyecto));
		validarPdpDTO.setHerramientasPgaValidate(pgaRespository.validarHerramientasPga(idProyecto));

		return validarPdpDTO;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public pga savePgaPorIdProyecto(Integer idProyecto) throws Exception {
		if (idProyecto == null || idProyecto <= 0) {
			throw new Exception("error en peticion");
		}
		pgaRespository.savePgaPorIdProyecto(idProyecto);
		return pgaRespository.findIdPgaForIdProyecto(idProyecto);
	}

	@Override
	@Transactional(readOnly = true)
	public pga BuscarPgaPorIdProyecto(Integer idProyecto) throws Exception {
		if (idProyecto < 0 || idProyecto == null) {
			throw new Exception("error en el identificador");
		}
		return pgaRespository.findIdPgaForIdProyecto(idProyecto);
	}

}
