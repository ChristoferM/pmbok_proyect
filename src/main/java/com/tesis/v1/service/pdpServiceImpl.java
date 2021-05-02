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

import com.tesis.v1.domain.pdp.pdp;
import com.tesis.v1.repository.reunionesRepository;
import com.tesis.v1.repository.pdp.pdpRepository;

@Service
@Scope("singleton")
public class pdpServiceImpl  implements pdpService {
	
	private final static Logger log = LoggerFactory.getLogger(pdpServiceImpl.class);

	@Autowired
	pdpRepository pdpRepository;
	
	@Autowired
	reunionesRepository reunionesRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<pdp> findAll() {
		return pdpRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<pdp> findById(Integer id) throws Exception {
		//  Auto-generated method stub pdpRepository
		if (id < 0 || id == null) {
			throw new Exception("error en el identificador");
		}
		return pdpRepository.findById(id);
	}

	@Override
	public Long count() {
		//  Auto-generated method stub pdpRepository
		return null;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public pdp save(pdp entity) throws Exception {
		//  Auto-generated method stub pdpRepository
		if (entity == null) {
			throw new Exception("error en peticion");
		}
		return pdpRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public pdp update(pdp entity) throws Exception {
		//  Auto-generated method stub pdpRepository 
		if (entity == null) {
			throw new Exception("error en peticion");
		}
		return pdpRepository.save(entity);
	}

	@Override
	public void delete(pdp entity) throws Exception {
		//  Auto-generated method stub pdpRepository
		if (entity == null) {
			throw new Exception("Error Con el Plan...");
		}
		if (entity.getReuniones() == null || entity.getReuniones().getIdreuniones()< 0) {
			throw new Exception("ERROR ES SERVICIOS");
		}
		pdpRepository.deleteById(entity.getIdpdp());

		
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		//  Auto-generated method stub
		
	}

	@Override
	public void validate(pdp entity) throws Exception {
		//  Auto-generated method stub
		
	}

}
