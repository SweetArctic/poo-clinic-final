package com.clinica.proyecto.infraestructure.repository;

import com.clinica.proyecto.application.dto.CitaDTO;
import com.clinica.proyecto.application.mapper.CitaMapper;
import com.clinica.proyecto.application.repository.ICitaRepository;
import com.clinica.proyecto.infraestructure.modelo.Cita;
import com.clinica.proyecto.infraestructure.repository.jpa.CitaJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CitaRepository implements ICitaRepository {
    @Autowired
    private CitaJpaRepository citaJpaRepository;
    @Autowired
    private CitaMapper citaMapper;

    @Override
    public List<Cita> findAll() { return citaJpaRepository.findAll(); }
    @Override
    public Optional<Cita> findById(Long id) { return citaJpaRepository.findById(id); }
    @Override
    public Cita save(Cita cita) { return citaJpaRepository.save(cita); }
    @Override
    public void deleteById(Long id) { citaJpaRepository.deleteById(id); }
    @Override
    public List<Cita> findByDoctorId(Long doctorId) { return citaJpaRepository.findByDoctor_Id(doctorId); }
    @Override
    public List<Cita> findByPacienteId(Long pacienteId) { return citaJpaRepository.findByPaciente_Id(pacienteId); }

    @Override
    public List<CitaDTO> findAllDTO() { return findAll().stream().map(citaMapper::toDTO).toList(); }
    @Override
    public Optional<CitaDTO> findByIdDTO(Long id) { return findById(id).map(citaMapper::toDTO); }
    @Override
    public CitaDTO saveDTO(CitaDTO citaDTO) { return citaMapper.toDTO(save(citaMapper.toEntity(citaDTO))); }
    @Override
    public void deleteByIdDTO(Long id) { deleteById(id); }
    @Override
    public List<CitaDTO> findByDoctorIdDTO(Long doctorId) { return findByDoctorId(doctorId).stream().map(citaMapper::toDTO).toList(); }
    @Override
    public List<CitaDTO> findByPacienteIdDTO(Long pacienteId) { return findByPacienteId(pacienteId).stream().map(citaMapper::toDTO).toList(); }
}

