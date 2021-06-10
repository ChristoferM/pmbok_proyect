package com.tesis.v1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesis.v1.domain.pga.herramientaspga;
import com.tesis.v1.repository.pga.herramientasPgaRepository;

@Service
@Scope("singleton")
public class pgaHerramientasServiceImpl implements pgaHerramientasService{

	@Autowired
	herramientasPgaRepository herramientasPgaRepository ; 
		
	
	
	@Override
	@Transactional(readOnly = true)
	public List<herramientaspga> findAll() {
		return herramientasPgaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<herramientaspga> findById(Integer id) throws Exception {
		return herramientasPgaRepository.findById(id);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return herramientasPgaRepository.count();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public herramientaspga save(herramientaspga entity) throws Exception {
		return herramientasPgaRepository.save(entity);
	}

 

	@Override
	public void delete(herramientaspga entity) throws Exception {
		
		
		if (entity==null) {
	            throw new Exception("La entrada acta es nulo");
	        }
	        if(entity.getIdherramientapga()==null || entity.getIdherramientapga() <= 0 ) {
	            throw new Exception("La id es obligatoria");
	            
	        }
	        if(herramientasPgaRepository.existsById(entity.getIdherramientapga())==false) {
	        	  throw new Exception("EL id No existe (No se puede eliminar)");
	        }
	        herramientasPgaRepository.deleteById(entity.getIdherramientapga());
		 
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validate(herramientaspga entity) throws Exception {
		// TODO Auto-generated method stub
		
	}



	// JUNIO 8  AGREGADO POR REUNION
	@Transactional(readOnly = true)
    public herramientaspga BuscarHerramientasPGAPorIdDelProyecto(Integer id) throws Exception {
        if (id < 0 || id == null) {
            throw new Exception("error en el identificador");
        }
        return herramientasPgaRepository.BuscarHerramientasPGAPorIdDelProyecto(id);
    }


	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public herramientaspga update(herramientaspga entity) throws Exception {
	 	if(entity ==null) {
			throw new Exception("Error en los datos");
			
		}
    	if(herramientasPgaRepository.existsById(entity.getIdherramientapga() )==false ) {
			throw new Exception("Erro: El Id No existe");
		}
		return herramientasPgaRepository.save(entity);
	}

}
