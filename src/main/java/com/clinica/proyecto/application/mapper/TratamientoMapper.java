package com.clinica.proyecto.application.mapper;

import com.clinica.proyecto.application.dto.TratamientoDTO;
import com.clinica.proyecto.infraestructure.modelo.Tratamiento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TratamientoMapper {
    TratamientoMapper INSTANCE = Mappers.getMapper(TratamientoMapper.class);

    @Mapping(source = "historiaClinica.id", target = "historiaClinicaId")
    @Mapping(source = "doctor.id", target = "doctorId")
    TratamientoDTO toDTO(Tratamiento tratamiento);

    @Mapping(source = "historiaClinicaId", target = "historiaClinica.id")
    @Mapping(source = "doctorId", target = "doctor.id")
    Tratamiento toEntity(TratamientoDTO tratamientoDTO);
}

