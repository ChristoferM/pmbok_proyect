package com.tesis.v1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.tesis.v1.domain.usuarios;
import com.tesis.v1.repository.usuariosRepository;

@Service
@Scope("singleton")
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	usuariosRepository usuariosRepository;

	@Override
	public List<usuarios> findAll() {
		return usuariosRepository.findAll();

	}

	@Override
	public Optional<usuarios> findById(String id) throws Exception {
		if (id != null || id.isBlank() == false || id.isEmpty() != true) {
			return usuariosRepository.findById(id);
		}
		throw new Exception("Error con el identificador");
	}

	@Override
	public Long count() {

		return null;
	}

	@Override
	public usuarios save(usuarios entity) throws Exception {
		if (entity == null) {

			throw new Exception("Error con los datos");
		}
		if (usuariosRepository.existsById(entity.getEmail())) {
			throw new Exception("Correo ya registrado");
		}
		return usuariosRepository.save(entity);

	}

	@Override
	public usuarios update(usuarios entity) throws Exception {
		if (entity == null) {

			throw new Exception("Error con los datos");

		}
		Optional<usuarios> usuarios = usuariosRepository.findById(entity.getEmail());
		if (usuarios.isPresent()) {
			// entity.setIdusuario(usuarios.get().getIdusuario());
			
			return usuariosRepository.save(entity);
		}
		throw new Exception("Error con los datos");

	}

	@Override
	public void delete(usuarios entity) throws Exception {

	}

	@Override
	public void deleteById(String id) throws Exception {
		if(usuariosRepository.findById(id)!=null ) {
			usuariosRepository.deleteById(id);
			
			
		}else {
			throw new Exception("Error Con el identificador del Usuario");	
		}
		

	}

	@Override
	public void validate(usuarios entity) throws Exception {

	}

}
