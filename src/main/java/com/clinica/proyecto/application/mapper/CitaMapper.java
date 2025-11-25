package com.clinica.proyecto.application.mapper;

import com.clinica.proyecto.application.dto.CitaDTO;
import com.clinica.proyecto.infraestructure.modelo.Cita;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CitaMapper {
    CitaMapper INSTANCE = Mappers.getMapper(CitaMapper.class);

    @Mapping(source = "paciente.id", target = "pacienteId")
    @Mapping(source = "doctor.id", target = "doctorId")
    @Mapping(source = "estado", target = "estado")
    CitaDTO toDTO(Cita cita);

    @Mapping(source = "pacienteId", target = "paciente.id")
    @Mapping(source = "doctorId", target = "doctor.id")
    @Mapping(source = "estado", target = "estado")
    Cita toEntity(CitaDTO citaDTO);
}

