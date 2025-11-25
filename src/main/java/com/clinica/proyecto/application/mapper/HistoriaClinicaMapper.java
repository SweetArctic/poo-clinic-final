package com.clinica.proyecto.application.mapper;

import com.clinica.proyecto.application.dto.HistoriaClinicaDTO;
import com.clinica.proyecto.infraestructure.modelo.HistoriaClinica;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {TratamientoMapper.class})
public interface HistoriaClinicaMapper {
    HistoriaClinicaMapper INSTANCE = Mappers.getMapper(HistoriaClinicaMapper.class);

    @Mapping(source = "paciente.id", target = "pacienteId")
    HistoriaClinicaDTO toDTO(HistoriaClinica historiaClinica);

    @Mapping(source = "pacienteId", target = "paciente.id")
    HistoriaClinica toEntity(HistoriaClinicaDTO historiaClinicaDTO);
}

