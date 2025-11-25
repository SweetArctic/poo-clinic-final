package com.clinica.proyecto.application.mapper;

import com.clinica.proyecto.application.dto.PacienteDTO;
import com.clinica.proyecto.infraestructure.modelo.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PacienteMapper {
    PacienteMapper INSTANCE = Mappers.getMapper(PacienteMapper.class);
    PacienteDTO toDTO(Paciente paciente);
    Paciente toEntity(PacienteDTO pacienteDTO);
}

