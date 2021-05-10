package com.tesis.v1.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesis.v1.domain.planesgestionbeneficios;
import com.tesis.v1.repository.planesgestionbeneficiosRepository;



@Service
@Scope("singleton")
public class PlanGestionBeneficioServiceImpl implements PlanGestionBeneficiosService{

    @Autowired
    planesgestionbeneficiosRepository planGestionBeneficiosRepository;

    private final static Logger log = LoggerFactory.getLogger(PlanGestionBeneficioServiceImpl.class);
    @Override
    @Transactional(readOnly = true)
    public List<planesgestionbeneficios> findAll() {
        return planGestionBeneficiosRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Long count() {
        return planGestionBeneficiosRepository.count();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor =Exception.class)
    public planesgestionbeneficios save(planesgestionbeneficios entity) throws Exception {
        /*if(planGestionBeneficiosRepository.existsById(entity.getId_plan_gb())){
            throw new Exception("El plan gestion beneficio " + entity.getId_plan_gb() + " ya existe");
        }*/
    	log.info("---"+entity.getAcciones());
    	log.info("---"+entity.getComponentes());
    	log.info("---"+entity.getResultado());
    	log.info("---"+entity.getServicios());
    	log.info("---"+entity.getProdcutos());
    	log.info("--- entrada: "+entity.getEntradacta().getIdentrada().toString());
        return planGestionBeneficiosRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor =Exception.class)
    public planesgestionbeneficios update(planesgestionbeneficios entity) throws Exception {
        if(planGestionBeneficiosRepository.existsById(entity.getId_plan_gb())== false){
            throw new Exception("El plan gestion beneficio " + entity.getId_plan_gb() + " No existe");
        }
        return planGestionBeneficiosRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<planesgestionbeneficios> findById(Integer id) throws Exception {
        return planGestionBeneficiosRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = false,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void delete(planesgestionbeneficios entity) throws Exception {
        if(entity == null){
            throw new Exception("La reunion es nulo");
        }

        if(entity.getId_plan_gb() == null || entity.getId_plan_gb() <= 0 ) {
            throw new Exception("El planGestionId  es obligatorio");
        }

        if(planGestionBeneficiosRepository.existsById(entity.getId_plan_gb()) == false){
            throw new Exception("El plan beneficio " + entity.getId_plan_gb() + " no existe");
        }

        planGestionBeneficiosRepository.delete(entity);          
    }

    @Override
    @Transactional(readOnly = false,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void deleteById(Integer id) throws Exception {
        if(id == null || id <= 0 ) {
            throw new Exception("El plan beneficio id no debe ser nulo");
        }
        
        if(planGestionBeneficiosRepository.existsById(id)){
            delete(planGestionBeneficiosRepository.findById(id).get());
        }else{
            throw new Exception("El plan beneficio" + id + " No existe");
        }        
    }

	

	@Override
	public void validate(planesgestionbeneficios entity) throws Exception {
		
	}

	@Override
    @Transactional(readOnly = true)
	public List<planesgestionbeneficios> planGestionDelActa(Integer idProyecto) {
		 return planGestionBeneficiosRepository.planGestionDelActa(idProyecto);
	}
    
}
