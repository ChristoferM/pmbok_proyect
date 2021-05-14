package com.tesis.v1.service;

import com.tesis.v1.domain.Tipo_proyecto;
import com.tesis.v1.repository.tipo_proyectoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author david
 */

@Service
@Scope("singleton")
public class Tipo_proyectoServiceImpl implements Tipo_proyectoService{
    
    @Autowired
    tipo_proyectoRepository tipoRepository;
    
    @Override
    @Transactional(readOnly = true)
    public List<Tipo_proyecto> findAll() {
        return this.tipoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Tipo_proyecto> findById(String id) throws Exception {
        return this.tipoRepository.findById(id);
    }
    

    @Override
    public Long count() {
        return this.tipoRepository.count();
    }

    @Override
    public Tipo_proyecto save(Tipo_proyecto entity) throws Exception {
        if(entity != null){
            return this.tipoRepository.save(entity);
        }
        
        throw new Exception("Verificar el tipo proyecto nulo");  
    }

    @Override
    public Tipo_proyecto update(Tipo_proyecto entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Tipo_proyecto entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void validate(Tipo_proyecto entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
