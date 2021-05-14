package com.tesis.v1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesis.v1.domain.Reunion;
import com.tesis.v1.repository.UsuarioRepository;
import com.tesis.v1.repository.ReunionRepository;

@Service
@Scope("singleton")
public class ReunionesServiceImpl implements ReunionesService {

	@Autowired
	ReunionRepository reunionesRepository;

	@Autowired
	UsuarioRepository usuariosRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Reunion> findAll() {
		List<Reunion> poryectosList = reunionesRepository.findAll();
		if (poryectosList == null || poryectosList.size() == 0) {
			return null;

		} else
			return poryectosList;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Reunion> findById(Integer id) throws Exception {
		Optional<Reunion> proyectoOpt = reunionesRepository.findById(id);
		if (proyectoOpt.isPresent()) {
			return proyectoOpt;

		} else {
			throw new Exception("El No se encontro reuniones : Posible Problemas con el identifcador ");
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Reunion save(Reunion entity) throws Exception {
		// las Reunion deben cargarse con el numero ID del proyecto
		
		
		return reunionesRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Reunion update(Reunion entity) throws Exception {
		if (reunionesRepository.existsById(entity.getIdreuniones()) == false) {
			throw new Exception("el proyecto No se encontro");
		}
		return reunionesRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(Reunion entity) throws Exception {

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
	public void validate(Reunion entity) throws Exception {

	}

	@Override
	public Long count() {

		return null;
	}
}
