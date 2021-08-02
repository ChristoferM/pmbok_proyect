package com.tesis.v1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesis.v1.domain.tipofases;
import com.tesis.v1.repository.tipofasesRepository;

@Service
@Scope("singleton")
public class tipofasesServiceImpl implements tipofasesService{

    @Autowired
    tipofasesRepository TtipofasesRepository;
    
	@Override
	@Transactional(readOnly = true)
	public List<tipofases> findAll() {

		return TtipofasesRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<tipofases> findById(Integer id) throws Exception {
		if(id == null || id <= 0) {
			return Optional.empty();
			
		}else {
			return TtipofasesRepository.findById(id);
		}
		
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public tipofases save(tipofases entity) throws Exception {
	
		return TtipofasesRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public tipofases update(tipofases entity) throws Exception {
		if(TtipofasesRepository.existsById(entity.getIdtipofase())) {
			
			Optional<tipofases> faseOld = TtipofasesRepository.findById(entity.getIdtipofase());
			tipofases faseTipoObjeto = faseOld.get();
			// faseTipoObjeto.setIdtipofase(entity.getIdtipofase());
			faseTipoObjeto.setNombrefase(entity.getNombrefase());
			return TtipofasesRepository.save(faseTipoObjeto);	
		}else {
			return entity;
		}
		
	}

	@Override
	public void delete(tipofases entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		TtipofasesRepository.deleteById(id);
		
	}

	@Override
	public void validate(tipofases entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
