package com.clinica.proyecto.application.mapper;

import com.clinica.proyecto.application.dto.DoctorDTO;
import com.clinica.proyecto.infraestructure.modelo.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);
    DoctorDTO toDTO(Doctor doctor);
    @Mapping(target = "usuario", ignore = true)
    Doctor toEntity(DoctorDTO doctorDTO);
}
