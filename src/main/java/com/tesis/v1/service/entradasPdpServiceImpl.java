package com.tesis.v1.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesis.v1.domain.Reunion;
import com.tesis.v1.domain.pdp.Entradas;
import com.tesis.v1.domain.pdp.Pdp;
import com.tesis.v1.dto.pdp.EntradasDTO;
import com.tesis.v1.repository.pdp.entradaPdpRepository;
import com.tesis.v1.repository.pdp.pdpRepository;

@Service
@Scope("singleton")
public class entradasPdpServiceImpl implements entradasPdpService {

    @Autowired
    entradaPdpRepository entradaPdpRepository;

    @Autowired
	pdpRepository PDPrepositorio;
    
    @Override
    @Transactional(readOnly = true)
    public List<Entradas> findAll() {
        //  Auto-generated method stub
        return entradaPdpRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Entradas> findById(Integer id) throws Exception {
        if (id < 0 || id == null) {
            throw new Exception("error en el identificador");
        }
        return entradaPdpRepository.findById(id);
    }

    @Override
    public Long count() {
        //  Auto-generated method stub
        return null;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Entradas save(Entradas entity) throws Exception {

        return entradaPdpRepository.save(entity);
    }

    

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(Entradas entity) throws Exception {
        //  Auto-generated method stub
        if (entity == null) {
            throw new Exception("La entrada acta es nulo");
        }
        if (entity.getIdentradapdp() == null || entity.getIdentradapdp() <= 0) {
            throw new Exception("La id es obligatoria");

        }
        if (entradaPdpRepository.existsById(entity.getIdentradapdp()) == false) {
            throw new Exception("La entrada acta  con id No existe (No se puede eliminar)");
        }
        entradaPdpRepository.deleteById(entity.getIdentradapdp());
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        //  Auto-generated method stub

    }

    @Override
    public void validate(Entradas entity) throws Exception {
        //  Auto-generated method stub

    }

    @Override
    @Transactional(readOnly = true)
    public Entradas BuscarEntradasPdpPorIdDelProyecto(Integer id) throws Exception {
        if (id < 0 || id == null) {
            throw new Exception("error en el identificador");
        }
        return entradaPdpRepository.BuscarEntradasPdpPorIdDelProyecto(id);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor =Exception.class)
    public Entradas update(Entradas entity) throws Exception {
    	if(entity ==null) {
			throw new Exception("Error en los datos");
			
		}
    	if(entradaPdpRepository.existsById(entity.getIdentradapdp() )==false ) {
			throw new Exception("Error El Id No existe");
		}
    	return entradaPdpRepository.save(entity);
    }
    
    /*
     * NUEVOS MÉTODOS PARA GUARDAR ACTUALIZAR Y BUSCAR DATOS PREVIOS
     * 25/9/2021
     * */

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public EntradasDTO guardarEntradaDelpdp(EntradasDTO entradasDTO) throws Exception {
		
	Integer idreuniones = entradaPdpRepository.buscarIdReunion(entradasDTO.getIdproyecto());
		
		// primero se crea un PDP para crear la instancia en base de datos
		// o verificar si YA existe la instancia
		// ambas deben ir ligado al id de proyecto
		Pdp pdp = PDPrepositorio.buscarPorIdReunion(idreuniones);
	

		if(pdp == null  ) {
			Reunion reunion = new Reunion();
        	reunion.setIdreuniones(idreuniones);
        	
        	reunion.setIdreuniones(idreuniones);
        	pdp = new Pdp();
    		pdp.setReuniones(reunion);
    		pdp = PDPrepositorio.save(pdp);
			
		}
	
		Entradas entity = new Entradas();
		
		entity.setActivosprocesos(entradasDTO.getActivosprocesos());
		entity.setEstado(true);
		entity.setFactoresambientales(entradasDTO.getFactoresambientales());
		entity.setOtrosprocesos(entradasDTO.getOtrosprocesos());
		entity.setParticipa(entradasDTO.getParticipa());
		entity.setPdp(pdp);
		try {
			entity = entradaPdpRepository.save(entity);
		} catch (Exception e) {
			throw new Exception("Error SQL: No se grabo los datos de Entradas Del PDP "
					+ "\n DETALLE:"+e);
		}
		EntradasDTO dto = new EntradasDTO();
		
		dto.setActivosprocesos(entity.getActivosprocesos());
		dto.setEstado(entity.getEstado());
		dto.setFactoresambientales(entity.getFactoresambientales());
		dto.setOtrosprocesos(entity.getOtrosprocesos());
		dto.setParticipa(entity.getParticipa());
		dto.setIdpdp(entity.getPdp().getIdpdp());
		
		return dto;
	}

}
