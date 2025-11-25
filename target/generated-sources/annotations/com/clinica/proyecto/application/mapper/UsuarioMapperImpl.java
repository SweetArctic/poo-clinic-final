package com.clinica.proyecto.application.mapper;

import com.clinica.proyecto.application.dto.UsuarioDTO;
import com.clinica.proyecto.infraestructure.modelo.Usuario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-25T02:14:46-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Oracle Corporation)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioDTO toDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId( usuario.getId() );
        usuarioDTO.setUsername( usuario.getUsername() );
        usuarioDTO.setPassword( usuario.getPassword() );
        if ( usuario.getRol() != null ) {
            usuarioDTO.setRol( usuario.getRol().name() );
        }

        return usuarioDTO;
    }

    @Override
    public Usuario toEntity(UsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setId( usuarioDTO.getId() );
        usuario.setUsername( usuarioDTO.getUsername() );
        usuario.setPassword( usuarioDTO.getPassword() );

        usuario.setEnabled( true );
        usuario.setRol( com.clinica.proyecto.infraestructure.modelo.enums.RolUsuario.valueOf(usuarioDTO.getRol()) );

        return usuario;
    }
}
