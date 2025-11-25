package com.clinica.proyecto.application.mapper;

import com.clinica.proyecto.application.dto.UsuarioDTO;
import com.clinica.proyecto.infraestructure.modelo.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);
    UsuarioDTO toDTO(Usuario usuario);
    Usuario toEntity(UsuarioDTO usuarioDTO);
}

