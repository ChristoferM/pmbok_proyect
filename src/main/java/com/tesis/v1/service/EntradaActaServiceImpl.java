package com.tesis.v1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesis.v1.domain.Acta;
import com.tesis.v1.domain.Entradacta;
import com.tesis.v1.domain.Reunion;
import com.tesis.v1.dto.EntradaDelActaDTO;
import com.tesis.v1.dto.ValidarActaDTO;
import com.tesis.v1.dto.idresponsable;
import com.tesis.v1.repository.ActaRepository;
import com.tesis.v1.repository.EntradactaRepository;
import com.tesis.v1.repository.ReunionRepository;

@Service
@Scope("singleton")
public class EntradaActaServiceImpl implements EntradaActaService {

    @Autowired
    EntradactaRepository entradActaRepository;
    
    @Autowired
    ActaRepository actaRepository ;
    
    @Autowired
    ReunionRepository reunionRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Entradacta> findAll() {
        return entradActaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Entradacta> entradaDelActa(Integer idProyecto) {
        return entradActaRepository.entradaDelActa(idProyecto);

    }

    @Override
    @Transactional(readOnly = true)
    public Long count() {
        return entradActaRepository.count();
    }
    
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Entradacta guardarEntradaDelActa(EntradaDelActaDTO EntradactaDTO) {
    	//Integer idreuniones = entradActaRepository.buscarIdReunion(EntradactaDTO.getIdfase(),EntradactaDTO.getIdproyecto());
    	Integer idreuniones = entradActaRepository.buscarIdReunion(EntradactaDTO.getIdproyecto());
    	
    	// --------------------------------------------------
    	Acta acta  = actaRepository.buscarPorIdReunion(idreuniones);
    	if(acta == null) {
    		Reunion reunion = new Reunion();
        	reunion.setIdreuniones(idreuniones);
    		acta = new Acta();
        	acta.setReuniones(reunion);
        	acta = actaRepository.save(acta);
    	}    	
    	Entradacta entity =  new Entradacta();
    	
    	entity.setAcuerdos(EntradactaDTO.getAcuerdos());
    	entity.setFactores(EntradactaDTO.getFactores());
    	entity.setActivosprocesos(EntradactaDTO.getActivosprocesos());
    	entity.setActas(acta);
    	entity.setEstado(true);
    	entity.setParticipa(EntradactaDTO.getParticipa());
    	
        return entradActaRepository.save(entity);
	}

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Entradacta actualiazrEntradaDelActa(EntradaDelActaDTO EntradactaDTO) {
    	//Integer idreuniones = entradActaRepository.buscarIdReunion(EntradactaDTO.getIdfase(),EntradactaDTO.getIdproyecto());
    	Integer idreuniones = entradActaRepository.buscarIdReunion(EntradactaDTO.getIdproyecto());
    	
    	// --------------------------------------------------
    	Acta acta  = actaRepository.buscarPorIdReunion(idreuniones);
    	if(acta == null) {
    		Reunion reunion = new Reunion();
        	reunion.setIdreuniones(idreuniones);
    		acta = new Acta();
        	acta.setReuniones(reunion);
        	acta = actaRepository.save(acta);
    	}    	
    	Entradacta entity =  new Entradacta();
    	entity.setIdentrada(EntradactaDTO.getIdentrada());
    	entity.setAcuerdos(EntradactaDTO.getAcuerdos());
    	entity.setFactores(EntradactaDTO.getFactores());
    	entity.setActivosprocesos(EntradactaDTO.getActivosprocesos());
    	entity.setActas(acta);
    	entity.setEstado(true);
    	entity.setParticipa(EntradactaDTO.getParticipa());
    	
        return entradActaRepository.save(entity);
	}


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Entradacta save(Entradacta entity) throws Exception {
        /*if(entradActaRepository.existsById(entity.getIdentrada())){
            throw new Exception("La Entrada acta con Id +" + entity.getIdentrada() + "ya existe");
        }*/
        return entradActaRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Entradacta update(Entradacta entity) throws Exception {
        if (entradActaRepository.existsById(entity.getIdentrada()) == false) {
            throw new Exception("La entrada acta  con Id +" + entity.getIdentrada() + "ya existe");
        }
        return entradActaRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Entradacta> findById(Integer id) throws Exception {
        return entradActaRepository.findById(id);

    }
	@Override
	@Transactional(readOnly = true)
	public List<Entradacta> BuscarDatosDeEntradas(EntradaDelActaDTO EntradactaDTO) {
		return entradActaRepository.BuscarDatosDeEntradas(EntradactaDTO.getIdproyecto());
	}


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(Entradacta entity) throws Exception {
        if (entity == null) {
            throw new Exception("La entrada acta es nulo");
        }
        if (entity.getIdentrada() == null || entity.getIdentrada() <= 0) {
            throw new Exception("La id es obligatoria");

        }
        if (entradActaRepository.existsById(entity.getIdentrada()) == false) {
            throw new Exception("La entrada acta  con id " + entity.getIdentrada() + " No existe (No se puede eliminar)");
        }

        entradActaRepository.deleteById(entity.getIdentrada());
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteById(Integer id) throws Exception {
        if (id == null || id <= 0) {
            throw new Exception("El  id es obligatorio");
        }

        if (entradActaRepository.existsById(id)) {
            delete(entradActaRepository.findById(id).get());
        } else {
            throw new Exception("La entrada acta con id" + id + " No existe");
        }

    }

    @Override
    public void validate(Entradacta entity) throws Exception {

    }

    @Override
    public ValidarActaDTO encontrarData(Integer idProyecto) {
        ValidarActaDTO validaciones = new ValidarActaDTO();
        validaciones.setActa(entradActaRepository.validarActa(idProyecto));

        validaciones.setEntradactaValidate(entradActaRepository.validarEntrada(idProyecto));
        validaciones.setHerramientasValidate(entradActaRepository.validarHerramienta(idProyecto));
        validaciones.setCasoNegocioValidate(entradActaRepository.validarCasoNegocio(idProyecto));
        validaciones.setPlanValidate(entradActaRepository.validarHPlanGestion(idProyecto));

        return validaciones;
    }

    @Override
    @Transactional(readOnly = true)
    public Integer valorIdActa(Integer idProyecto) {
        if (idProyecto > 0) {
            return entradActaRepository.valorIdActa(idProyecto);
        } else {
            return 0;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Integer valorIdEntraActa(Integer idProyecto) {
        if (idProyecto > 0) {
            return entradActaRepository.valorIdEntraActa(idProyecto);
        } else {
            return 0;
        }
    }


	
}
