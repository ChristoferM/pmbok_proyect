package com.tesis.v1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesis.v1.domain.reuniones;
import com.tesis.v1.repository.reunionesRepository;
import com.tesis.v1.repository.usuariosRepository;

@Service
@Scope("singleton")
public class ReunionesServiceImpl implements ReunionesService {

	@Autowired
	reunionesRepository reunionesRepository;

	@Autowired
	usuariosRepository usuariosRepository;

	@Override
	@Transactional(readOnly = true)
	public List<reuniones> findAll() {
		List<reuniones> poryectosList = reunionesRepository.findAll();
		if (poryectosList == null || poryectosList.size() == 0) {
			return null;

		} else
			return poryectosList;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<reuniones> findById(Integer id) throws Exception {
		Optional<reuniones> proyectoOpt = reunionesRepository.findById(id);
		if (proyectoOpt.isPresent()) {
			return proyectoOpt;

		} else {
			throw new Exception("El No se encontro reuniones : Posible Problemas con el identifcador ");
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public reuniones save(reuniones entity) throws Exception {
		// las reuniones deben cargarse con el numero ID del proyecto
		
		
		return reunionesRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public reuniones update(reuniones entity) throws Exception {
		if (reunionesRepository.existsById(entity.getIdreuniones()) == false) {
			throw new Exception("el proyecto No se encontro");
		}
		return reunionesRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(reuniones entity) throws Exception {

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(Integer id) throws Exception {
		if (id == null || id <= 0) {
			throw new Exception("El Identificador es obligatoria");
		}
		if (reunionesRepository.existsById(id)) {
			reunionesRepository.deleteById(id);
		} else {
			throw new Exception("El product con id :" + id + " no existe");
		}

	}

	@Override
	public void validate(reuniones entity) throws Exception {

	}

	@Override
	public Long count() {

		return null;
	}
}
