package com.tesis.v1.service;

import java.util.Optional;

import com.tesis.v1.domain.Usuario;

public interface UsuarioService extends GenericService<Usuario,String>{
	
    // REaliza delete Solo por Id
    public Optional<Usuario> findByIdLogin(String id,String pass) throws Exception;

}
