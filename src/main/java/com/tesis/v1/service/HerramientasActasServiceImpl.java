package com.tesis.v1.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesis.v1.domain.Acta;
import com.tesis.v1.domain.Herramientasacta;
import com.tesis.v1.dto.HerramientasDelActaDTO;
import com.tesis.v1.repository.ActaRepository;
import com.tesis.v1.repository.EntradactaRepository;
import com.tesis.v1.repository.HerramientasactaRepository;

@Service
@Scope("singleton")
public class HerramientasActasServiceImpl implements HerramientasActasService {

    @Autowired
    HerramientasactaRepository herramientasActaRepository;
    @Autowired
    EntradactaRepository entradActaRepository;
    @Autowired
    ActaRepository actaRepository ;
    

    @Override
    @Transactional(readOnly = true)
    public List<Herramientasacta> findAll() {
        return herramientasActaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Long count() {
        return herramientasActaRepository.count();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Herramientasacta save(Herramientasacta entity) throws Exception {
        if (herramientasActaRepository.existsById(entity.getIdherramienta())) {
            throw new Exception("La herramienta con Id +" + entity.getIdherramienta() + "ya existe");
        }
        return herramientasActaRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Herramientasacta update(Herramientasacta entity) throws Exception {
        if (herramientasActaRepository.existsById(entity.getIdherramienta()) == false
                || entity.getIdherramienta() == null) {
            throw new Exception("La herramienta con id +" + entity.getIdherramienta() + "no existe");
        }
        return herramientasActaRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Herramientasacta> findById(Integer id) throws Exception {
        return herramientasActaRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(Herramientasacta entity) throws Exception {
        if (entity == null) {
            throw new Exception("El idHerramienta es nulo");
        }
        if (entity.getIdherramienta() == null || entity.getIdherramienta() <= 0) {
            throw new Exception("El id es obligatoria");

        }
        if (herramientasActaRepository.existsById(entity.getIdherramienta()) == false) {
            throw new Exception("La herramienta Acta con id " + entity.getIdherramienta() + " No existe (No se puede eliminar)");
        }

        herramientasActaRepository.deleteById(entity.getIdherramienta());

    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteById(Integer id) throws Exception {
        if (id == null || id <= 0) {
            throw new Exception("La herramienta id es obligatorio");
        }

        if (herramientasActaRepository.existsById(id)) {
            delete(herramientasActaRepository.findById(id).get());
        } else {
            throw new Exception("La herramienta con id" + id + " No existe");
        }
    }

    @Override
    public void validate(Herramientasacta entity) throws Exception {

    }

    @Override
    @Transactional(readOnly = true)
    public List<Herramientasacta> herramientaDelActa(Integer idProyecto) {
        return herramientasActaRepository.herramientaDelActa(idProyecto);
    }

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Herramientasacta guardarHerramientasDelActa(HerramientasDelActaDTO herramientasDelActaDTO) throws Exception {

		Integer idreuniones = entradActaRepository.buscarIdReunion(herramientasDelActaDTO.getIdfase(),herramientasDelActaDTO.getIdproyecto());
		
		// Problema detectado, la acta corresponde a un unico valor
		// y ese unico valor va ligado a la primera reunion por ende, es necesario ubicar ese id unico
		Acta acta  = actaRepository.buscarIdActaPorProyecto(herramientasDelActaDTO.getIdproyecto());
		
		Herramientasacta herramienta = new Herramientasacta();
		
		herramienta.setEstado(true);
		herramienta.setActas(acta);
		herramienta.setHabilidades(herramientasDelActaDTO.getHabilidades());
		herramienta.setHerramientareuniones(herramientasDelActaDTO.getHerramientareuniones());
		herramienta.setJuicioexpertos(herramientasDelActaDTO.getJuicioexpertos());
		herramienta.setParticipa(herramientasDelActaDTO.getParticipa());
		herramienta.setRecopilaciondatos(herramientasDelActaDTO.getRecopilaciondatos());
		
		return herramientasActaRepository.save(herramienta);
		
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Herramientasacta> BuscarDatosDeHerramietasPrevias(HerramientasDelActaDTO herramientasDelActaDTO)
			throws Exception {
		// return herramientasActaRepository.BuscarDatosDeHerramietasPrevias(herramientasDelActaDTO.getIdfase(),herramientasDelActaDTO.getIdproyecto());
		return herramientasActaRepository.BuscarDatosDeHerramietasPrevias(herramientasDelActaDTO.getIdproyecto());
		// return null;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
