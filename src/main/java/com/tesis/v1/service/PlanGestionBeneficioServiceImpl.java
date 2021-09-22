package com.tesis.v1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesis.v1.domain.Entradacta;
import com.tesis.v1.domain.PlanGestionbeneficio;
import com.tesis.v1.dto.PlanDeGestionDeBeneficiosDelActaDTO;
import com.tesis.v1.dto.PlanGestionBeneficioDTO;
import com.tesis.v1.mapper.PlanGestionBeneficioMapper;
import com.tesis.v1.repository.PlanGestionBeneficioRepository;

@Service
@Scope("singleton")
public class PlanGestionBeneficioServiceImpl implements PlanGestionBeneficiosService {

	@Autowired
	PlanGestionBeneficioRepository planGestionBeneficiosRepository;
	@Autowired
    PlanGestionBeneficioMapper planesgestionbeneficiosMapper;

	private final static Logger log = LoggerFactory.getLogger(PlanGestionBeneficioServiceImpl.class);

	@Override
	@Transactional(readOnly = true)
	public List<PlanGestionbeneficio> findAll() {
		return planGestionBeneficiosRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return planGestionBeneficiosRepository.count();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public PlanGestionbeneficio save(PlanGestionbeneficio entity) throws Exception {
		/*
		 * if(planGestionBeneficiosRepository.existsById(entity.getId_plan_gb())){ throw
		 * new Exception("El plan gestion beneficio " + entity.getId_plan_gb() +
		 * " ya existe"); }
		 */
		log.info("---" + entity.getAcciones());
		log.info("---" + entity.getComponentes());
		log.info("---" + entity.getResultado());
		log.info("---" + entity.getServicios());
		log.info("---" + entity.getProdcutos());
		log.info("--- entrada: " + entity.getEntradacta().getIdentrada().toString());
		return planGestionBeneficiosRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public PlanGestionbeneficio update(PlanGestionbeneficio entity) throws Exception {
		if (planGestionBeneficiosRepository.existsById(entity.getId_plan_gb()) == false) {
			throw new Exception("El plan gestion beneficio " + entity.getId_plan_gb() + " No existe");
		}
		return planGestionBeneficiosRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<PlanGestionbeneficio> findById(Integer id) throws Exception {
		return planGestionBeneficiosRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(PlanGestionbeneficio entity) throws Exception {
		if (entity == null) {
			throw new Exception("La reunion es nulo");
		}

		if (entity.getId_plan_gb() == null || entity.getId_plan_gb() <= 0) {
			throw new Exception("El planGestionId  es obligatorio");
		}

		if (planGestionBeneficiosRepository.existsById(entity.getId_plan_gb()) == false) {
			throw new Exception("El plan beneficio " + entity.getId_plan_gb() + " no existe");
		}

		planGestionBeneficiosRepository.delete(entity);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(Integer id) throws Exception {
		if (id == null || id <= 0) {
			throw new Exception("El plan beneficio id no debe ser nulo");
		}

		if (planGestionBeneficiosRepository.existsById(id)) {
			delete(planGestionBeneficiosRepository.findById(id).get());
		} else {
			throw new Exception("El plan beneficio" + id + " No existe");
		}
	}

	@Override
	public void validate(PlanGestionbeneficio entity) throws Exception {

	}

	@Override
	@Transactional(readOnly = true)
	public List<PlanGestionbeneficio> planGestionDelActa(Integer idProyecto) {
		return planGestionBeneficiosRepository.planGestionDelActa(idProyecto);
	}

	/*
	 * Métodos nuevos para guardar la informacion desde el frontend 21/9/2021
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public PlanGestionBeneficioDTO guardarPlanDeBeneficiosNuevo(
			PlanDeGestionDeBeneficiosDelActaDTO planDeGestionDeBeneficiosDelActaDTO) throws Exception {

		PlanGestionbeneficio entity = new PlanGestionbeneficio();
		try {
			Integer identrada = this.planGestionBeneficiosRepository
					.BuscarIdDeEntradaParaPlanDeBeneficios(planDeGestionDeBeneficiosDelActaDTO.getIdproyecto());
			
			if(identrada == 0 || identrada == null ) {
				throw new Exception("error Con el Id de la entrada");	
			}
			Entradacta entity_01 =  new Entradacta();
			entity_01.setIdentrada(identrada);
			
			// Sett
			entity.setAcciones(planDeGestionDeBeneficiosDelActaDTO.getAcciones());
			entity.setComponentes(planDeGestionDeBeneficiosDelActaDTO.getComponentes());
			entity.setProdcutos(planDeGestionDeBeneficiosDelActaDTO.getProdcutos());
			entity.setServicios(planDeGestionDeBeneficiosDelActaDTO.getServicios());
			entity.setResultado(planDeGestionDeBeneficiosDelActaDTO.getResultado());
			
			entity.setEntradacta(entity_01);
			entity.setEstado(true);
			
			entity.setParticipa(planDeGestionDeBeneficiosDelActaDTO.getParticipa());
			entity = 		planGestionBeneficiosRepository.save(entity);
			PlanGestionBeneficioDTO dto = this.planesgestionbeneficiosMapper.toplanesGestionBeneficiosDTO(entity);
			
			dto.setIdEntradaActa(identrada);
			return dto;
		} catch (Exception e) {
			throw new Exception(e);
		}

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public PlanGestionBeneficioDTO updatePlanNuevo(PlanDeGestionDeBeneficiosDelActaDTO planDeGestionDeBeneficiosDelActaDTO)
			throws Exception {
		PlanGestionbeneficio entity = new PlanGestionbeneficio();

		try {
			
			Integer identrada = this.planGestionBeneficiosRepository
					.BuscarIdDeEntradaParaPlanDeBeneficios(planDeGestionDeBeneficiosDelActaDTO.getIdproyecto());
			
			if(identrada == 0 || identrada == null ) {
				throw new Exception("error Con el Id de la entrada");	
			}
			Entradacta entity_01 =  new Entradacta();
			entity_01.setIdentrada(identrada);
			
			// ID PARA MODIFICAR DE VERDAD
			entity.setId_plan_gb(planDeGestionDeBeneficiosDelActaDTO.getId_plan_gb());
			
			// Sett
			entity.setAcciones(planDeGestionDeBeneficiosDelActaDTO.getAcciones());
			entity.setComponentes(planDeGestionDeBeneficiosDelActaDTO.getComponentes());
			entity.setProdcutos(planDeGestionDeBeneficiosDelActaDTO.getProdcutos());
			entity.setServicios(planDeGestionDeBeneficiosDelActaDTO.getServicios());
			entity.setResultado(planDeGestionDeBeneficiosDelActaDTO.getResultado());
			
			entity.setEntradacta(entity_01);
			entity.setEstado(true);
			
			entity.setParticipa(planDeGestionDeBeneficiosDelActaDTO.getParticipa());
			
			PlanGestionBeneficioDTO dto = this.planesgestionbeneficiosMapper.toplanesGestionBeneficiosDTO(entity);
			
			dto.setIdEntradaActa(identrada);
			return dto;
		} catch (Exception e) {
			throw new Exception(e);
		}

	}

	@Override
	@Transactional(readOnly = true)
	public List<PlanGestionBeneficioDTO> BuscarDatosDePlanBeneficiosPrevias(
			PlanDeGestionDeBeneficiosDelActaDTO planDeGestionDeBeneficiosDelActaDTO) throws Exception {
		
		
		List<PlanGestionbeneficio> listDomine = new ArrayList<>();
		List<PlanGestionBeneficioDTO> dtoList = new ArrayList<>();
		
		try {
			listDomine = this.planGestionBeneficiosRepository.planGestionDelActa(planDeGestionDeBeneficiosDelActaDTO.getIdproyecto());
		} catch (Exception e) {
			throw new Exception(e); 
		}
		
		for(PlanGestionbeneficio domine:listDomine) {
			PlanGestionBeneficioDTO dto = new PlanGestionBeneficioDTO();
			
			dto.setAcciones(domine.getAcciones());
			
			
			dto.setComponentes(domine.getComponentes());
			dto.setParticipa(domine.getParticipa());
			dto.setProdcutos(domine.getProdcutos());
			dto.setResultado(domine.getResultado());
			dto.setServicios(domine.getServicios());
			dto.setIdEntradaActa(domine.getEntradacta().getIdentrada());
			dto.setEstado(domine.getEstado());
			dto.setId_plan_gb(domine.getId_plan_gb());
			dtoList.add(dto);
			
			
		}
		return dtoList;
	}

}
