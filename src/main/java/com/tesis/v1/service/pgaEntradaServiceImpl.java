package com.tesis.v1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesis.v1.domain.pga.entradapga;
import com.tesis.v1.repository.pga.entradaPgaRepository;

@Service
@Scope("singleton")
public class pgaEntradaServiceImpl implements pgaEntradasServices{

	
	@Autowired
	entradaPgaRepository entradaPgaRepository;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<entradapga> findAll() {
		return entradaPgaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<entradapga> findById(Integer id) throws Exception {
		return entradaPgaRepository.findById(id);
	}

	@Override
	public Long count() {
		return entradaPgaRepository.count();
	}

	@Override
	@Transactional(readOnly = false,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public entradapga save(entradapga entity) throws Exception {
		return entradaPgaRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public entradapga update(entradapga entity) throws Exception {
		return entradaPgaRepository.save(entity);
	}

	@Override
	public void delete(entradapga entity) throws Exception {
		

		 if (entity==null) {
	            throw new Exception("La entrada acta es nulo");
	        }
	        if(entity.getIdentradapga()==null || entity.getIdentradapga() <= 0 ) {
	            throw new Exception("La id es obligatoria");
	            
	        }
	        if(entradaPgaRepository.existsById(entity.getIdentradapga())==false) {
	        	  throw new Exception("La entrada acta  con id No existe (No se puede eliminar)");
	        }
	        entradaPgaRepository.deleteById(entity.getIdentradapga()); 
		
		
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validate(entradapga entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
