package com.clinica.proyecto.application.mapper;

import com.clinica.proyecto.application.dto.UsuarioDTO;
import com.clinica.proyecto.infraestructure.modelo.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);
    UsuarioDTO toDTO(Usuario usuario);
    @Mapping(target = "enabled", constant = "true")
    @Mapping(target = "rol", expression = "java(com.clinica.proyecto.infraestructure.modelo.enums.RolUsuario.valueOf(usuarioDTO.getRol()))")
    Usuario toEntity(UsuarioDTO usuarioDTO);
}
