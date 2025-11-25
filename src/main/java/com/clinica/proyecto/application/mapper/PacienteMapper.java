package com.clinica.proyecto.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.clinica.proyecto.application.dto.PacienteDTO;
import com.clinica.proyecto.infraestructure.modelo.Paciente;

@Mapper(componentModel = "spring")
public interface PacienteMapper {
    PacienteMapper INSTANCE = Mappers.getMapper(PacienteMapper.class);
    PacienteDTO toDTO(Paciente paciente);
    @Mapping(target = "usuario", ignore = true)
    Paciente toEntity(PacienteDTO pacienteDTO);
}
