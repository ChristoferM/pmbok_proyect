package com.tesis.v1.mapper;

import org.mapstruct.Mapper;

import com.tesis.v1.domain.Usuario;
import com.tesis.v1.dto.UsuariosDTO;

import java.util.List;

@Mapper
public interface UsuarioMapper {

    public UsuariosDTO toUsuariosDTO(Usuario usuarios);

    public Usuario toUsuarios(UsuariosDTO usuariosDTO);

    public List<UsuariosDTO> toUsuariosDTOs(List<Usuario> usuarioss);

    public List<Usuario> toUsuarioss(List<UsuariosDTO> usuariosDTOs);

}
