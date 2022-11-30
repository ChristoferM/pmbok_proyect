package com.tesis.v1.mapper;

import com.tesis.v1.domain.Usuario;
import com.tesis.v1.dto.UsuariosDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 17.0.2 (Eclipse Adoptium)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuariosDTO toUsuariosDTO(Usuario usuarios) {
        if ( usuarios == null ) {
            return null;
        }

        UsuariosDTO usuariosDTO = new UsuariosDTO();

        usuariosDTO.setEmail( usuarios.getEmail() );
        usuariosDTO.setNombre( usuarios.getNombre() );
        usuariosDTO.setPassword( usuarios.getPassword() );
        usuariosDTO.setToken( usuarios.getToken() );
        usuariosDTO.setActivo( usuarios.getActivo() );
        usuariosDTO.setDocumento( usuarios.getDocumento() );

        return usuariosDTO;
    }

    @Override
    public Usuario toUsuarios(UsuariosDTO usuariosDTO) {
        if ( usuariosDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setDocumento( usuariosDTO.getDocumento() );
        usuario.setEmail( usuariosDTO.getEmail() );
        usuario.setNombre( usuariosDTO.getNombre() );
        usuario.setPassword( usuariosDTO.getPassword() );
        usuario.setToken( usuariosDTO.getToken() );
        usuario.setActivo( usuariosDTO.getActivo() );

        return usuario;
    }

    @Override
    public List<UsuariosDTO> toUsuariosDTOs(List<Usuario> usuarioss) {
        if ( usuarioss == null ) {
            return null;
        }

        List<UsuariosDTO> list = new ArrayList<UsuariosDTO>( usuarioss.size() );
        for ( Usuario usuario : usuarioss ) {
            list.add( toUsuariosDTO( usuario ) );
        }

        return list;
    }

    @Override
    public List<Usuario> toUsuarioss(List<UsuariosDTO> usuariosDTOs) {
        if ( usuariosDTOs == null ) {
            return null;
        }

        List<Usuario> list = new ArrayList<Usuario>( usuariosDTOs.size() );
        for ( UsuariosDTO usuariosDTO : usuariosDTOs ) {
            list.add( toUsuarios( usuariosDTO ) );
        }

        return list;
    }
}
