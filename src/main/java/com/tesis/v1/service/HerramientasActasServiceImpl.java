package com.tesis.v1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesis.v1.domain.herramientasacta;
import com.tesis.v1.repository.herramientasactaRepository;



@Service
@Scope("singleton")
public class HerramientasActasServiceImpl implements HerramientasActasService {

    @Autowired
    herramientasactaRepository herramientasActaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<herramientasacta> findAll() {
         return herramientasActaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Long count() {
        return herramientasActaRepository.count();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor =Exception.class)
    public herramientasacta save(herramientasacta entity) throws Exception {
        if(herramientasActaRepository.existsById(entity.getIdherramienta())){
            throw new Exception("La herramienta con Id +" + entity.getIdherramienta() + "ya existe");
        }
        return herramientasActaRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor =Exception.class)
    public herramientasacta update(herramientasacta entity) throws Exception {
        if(herramientasActaRepository.existsById(entity.getIdherramienta()) == false
        		|| entity.getIdherramienta() == null ){
            throw new Exception("La herramienta con id +" + entity.getIdherramienta() + "no existe");
        }
        return herramientasActaRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<herramientasacta> findById(Integer id) throws Exception {
        return herramientasActaRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor =Exception.class)
    public void delete(herramientasacta entity) throws Exception {
        if (entity==null) {
            throw new Exception("El idHerramienta es nulo");
        }
        if(entity.getIdherramienta()==null || entity.getIdherramienta() <= 0 ) {
            throw new Exception("El id es obligatoria");
            
        }
        if(herramientasActaRepository.existsById(entity.getIdherramienta())==false ) {
            throw new Exception("La herramienta Acta con id "+entity.getIdherramienta() +" No existe (No se puede eliminar)");
        }

        herramientasActaRepository.deleteById(entity.getIdherramienta());

    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteById(Integer id) throws Exception {
        if(id == null || id <= 0 ) {
            throw new Exception("La herramienta id es obligatorio");
        }
        
        if(herramientasActaRepository.existsById(id)){
            delete(herramientasActaRepository.findById(id).get());
        }else{
            throw new Exception("La herramienta con id" + id + " No existe");
        }
    }

	@Override
	public void validate(herramientasacta entity) throws Exception {
		
	}

	@Override
    @Transactional(readOnly = true)
	public List<herramientasacta> herramientaDelActa(Integer idProyecto) {
		return herramientasActaRepository.herramientaDelActa(idProyecto);
	}
    
}
