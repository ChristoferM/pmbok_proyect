package com.tesis.v1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.tesis.v1.domain.Usuario;
import com.tesis.v1.repository.UsuarioRepository;

@Service
@Scope("singleton")
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuariosRepository;

    @Override
    public List<Usuario> findAll() {
        return usuariosRepository.findAll();

    }

    @Override  // warning Null pointer access ==> || id.isBlank() == false || id.isEmpty() != true
    public Optional<Usuario> findById(String id) throws Exception {
        if (id != null) {
            return usuariosRepository.findById(id);
        }
        throw new Exception("Error con el identificador");
    }

    @Override
    public Long count() {
        return usuariosRepository.count();
    }

    @SuppressWarnings("unused")
	@Override
    public Usuario save(Usuario entity) throws Exception {
        entity.setPassword(DigestUtils.md5DigestAsHex(entity.getPassword().getBytes()));
        entity.setDocumento(DigestUtils.md5DigestAsHex(entity.getDocumento().getBytes()));
        if (entity == null) {
            throw new Exception("Error con los datos");
        }
        if (usuariosRepository.existsById(entity.getEmail())) {
            throw new Exception("Correo ya registrado");
        }
        if (usuariosRepository.existsByDocument(entity.getDocumento())) {
            throw new Exception("Documento ya registrado");
        }
  
        return usuariosRepository.save(entity);

    }

    @Override
    public Usuario update(Usuario entity) throws Exception {
        if (entity == null) {

            throw new Exception("Error con los datos");

        }
        Optional<Usuario> usuarios = usuariosRepository.findById(entity.getEmail());
        if (usuarios.isPresent()) {
            // entity.setIdusuario(Usuario.get().getIdusuario());

            return usuariosRepository.save(entity);
        }
        throw new Exception("Error con los datos");

    }

    @Override
    public void delete(Usuario entity) throws Exception {

    }

    @Override
    public void deleteById(String id) throws Exception {
        if (usuariosRepository.findById(id) != null) {
            usuariosRepository.deleteById(id);

        } else {
            throw new Exception("Error Con el identificador del Usuario");
        }

    }

    @Override
    public void validate(Usuario entity) throws Exception {

    }

}
