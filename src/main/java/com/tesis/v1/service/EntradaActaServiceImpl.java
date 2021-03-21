package com.tesis.v1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesis.v1.domain.entradacta;
import com.tesis.v1.repository.entradactaRepository;



@Service
@Scope("singleton")
public  class EntradaActaServiceImpl implements EntradaActaService {

    @Autowired
    entradactaRepository entradActaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<entradacta> findAll() {
        return entradActaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Long count() {
        return entradActaRepository.count();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor =Exception.class)
    public entradacta save(entradacta entity) throws Exception {
        if(entradActaRepository.existsById(entity.getIdentrada())){
            throw new Exception("La Entrada acta con Id +" + entity.getIdentrada() + "ya existe");
        }
        return entradActaRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor =Exception.class)
    public entradacta update(entradacta entity) throws Exception {
        if(entradActaRepository.existsById(entity.getIdentrada()) == false ){            
            throw new Exception("La entrada acta  con Id +" + entity.getIdentrada() + "ya existe");
        }
        return entradActaRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<entradacta> findById(Integer id) throws Exception {
        return entradActaRepository.findById(id);

    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor =Exception.class)
    public void delete(entradacta entity) throws Exception {
        if (entity==null) {
            throw new Exception("La entrada acta es nulo");
        }
        if(entity.getIdentrada()==null || entity.getIdentrada() <= 0 ) {
            throw new Exception("La id es obligatoria");
            
        }
        if(entradActaRepository.existsById(entity.getIdentrada())==false ) {
            throw new Exception("La entrada acta  con id "+entity.getIdentrada() +" No existe (No se puede eliminar)");
        }

        entradActaRepository.deleteById(entity.getIdentrada());        
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor =Exception.class)
    public void deleteById(Integer id) throws Exception {
        if(id == null || id <= 0 ) {
            throw new Exception("El  id es obligatorio");
        }
        
        if(entradActaRepository.existsById(id)){
            delete(entradActaRepository.findById(id).get());
        }else{
            throw new Exception("La entrada acta con id" + id + " No existe");
        }
        
    }

	@Override
	public void validate(entradacta entity) throws Exception {
		// TODO Auto-generated method stub
		
	}
    
}
