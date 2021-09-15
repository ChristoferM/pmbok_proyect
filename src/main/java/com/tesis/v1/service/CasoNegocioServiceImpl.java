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

import com.tesis.v1.domain.CasoNegocio;
import com.tesis.v1.domain.Entradacta;
import com.tesis.v1.dto.CasoDeNegocioDelActaDTO;
import com.tesis.v1.repository.CasoNegocioRepository;
import com.tesis.v1.repository.EntradactaRepository;

@Service
@Scope("singleton")
public class CasoNegocioServiceImpl implements CasoNegocioService {

    @Autowired
    CasoNegocioRepository casoNegocioRepository;
    @Autowired
    EntradaActaService EntradaActaService;

    @Autowired
    EntradactaRepository entradActaRepository;
    private final static Logger log = LoggerFactory.getLogger(CasoNegocioServiceImpl.class);

    @Override
    @Transactional(readOnly = true)
    public List<CasoNegocio> findAll() {
        return casoNegocioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Long count() {
        return casoNegocioRepository.count();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public CasoNegocio save(CasoNegocio entity) throws Exception {
        Optional<Entradacta> entradacta = EntradaActaService.findById(entity.getEntradacta().getIdentrada());
        // entity.setEntradacta(Entradacta.get());
        log.info("********************" + entity.getEntradacta().getIdentrada().toString());

        if (entradacta.isEmpty()) {
            throw new Exception("No se reconoce el identificador del ACTA");
        }
        log.info(entity.getEntradacta().getIdentrada().toString());
        return casoNegocioRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public CasoNegocio update(CasoNegocio entity) throws Exception {
        if (casoNegocioRepository.existsById(entity.getId_caso_negocio()) == false) {
            throw new Exception("El caso negocio  con Id +" + entity.getId_caso_negocio() + "ya existe");
        }
        return casoNegocioRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CasoNegocio> findById(Integer id) throws Exception {
        return casoNegocioRepository.findById(id);
    }

    public void deleteById(Integer id) throws Exception {
        if (id == null || id <= 0) {
            throw new Exception("El  id es obligatorio");
        }

        if (casoNegocioRepository.existsById(id)) {
            try {
                Optional<CasoNegocio> caso = casoNegocioRepository.findById(id);
                casoNegocioRepository.delete(caso.get());

            } catch (Exception e) {
                throw new Exception("error" + e);
            }

        } else {
            throw new Exception("El caso negocio con id: " + id + " No existe");
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(CasoNegocio entity) throws Exception {
        if (entity == null) {
            throw new Exception("La entrada acta es nulo");
        }
        if (entity.getId_caso_negocio() == null || entity.getId_caso_negocio() <= 0) {
            throw new Exception("La id es obligatoria");

        }
        if (casoNegocioRepository.existsById(entity.getId_caso_negocio()) == false) {
            throw new Exception(
                    "La entrada acta  con id " + entity.getId_caso_negocio() + " No existe (No se puede eliminar)");
        }

        casoNegocioRepository.deleteById(entity.getId_caso_negocio());

    }

    @Override
    public void validate(CasoNegocio entity) throws Exception {

    }

    @Override
    public CasoNegocio save(CasoNegocio entity, Integer idEntrada) throws Exception {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CasoNegocio> casoNegocioDelActa(Integer idProyecto) {
        return casoNegocioRepository.casoNegocioDelActa(idProyecto);
    }

	@Override
	public List<CasoNegocio> BuscarDatosDeCasonegocio(CasoDeNegocioDelActaDTO cCasoDeNegocioDelActaDTO)
			throws Exception {
		return casoNegocioRepository.casoNegocioDelActa(cCasoDeNegocioDelActaDTO.getIdproyecto());
	}

	@Override
	public CasoNegocio guardarCasoNegocio(CasoDeNegocioDelActaDTO casoDeNegocioDelActaDTO) throws Exception {
		
		Integer idreuniones = casoNegocioRepository.BuscarDatosDeCasonegocio(casoDeNegocioDelActaDTO.getIdproyecto());

		CasoNegocio entity = new CasoNegocio();
		Entradacta entity_01 =  new Entradacta();
		if(idreuniones== null || idreuniones == 0 ) {
			 throw new Exception("guardarCasoNegocio De IMplementacion Error en idEntradaDel Acta");
			
		}
		entity_01.setIdentrada(idreuniones);
		
		
		entity.setEstado(true);
		entity.setEntradacta(entity_01);
		entity.setIncidentes(casoDeNegocioDelActaDTO.getIncidentes());
		entity.setMetas(casoDeNegocioDelActaDTO.getMetas());
		entity.setObjetivos(casoDeNegocioDelActaDTO.getObjetivos());
		entity.setOportunidades(casoDeNegocioDelActaDTO.getOportunidades());
		entity.setParticipa(casoDeNegocioDelActaDTO.getParticipa());	
		
		return casoNegocioRepository.save(entity);
	}

}
