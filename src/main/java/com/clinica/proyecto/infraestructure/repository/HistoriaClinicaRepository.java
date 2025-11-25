package com.clinica.proyecto.infraestructure.repository;

import com.clinica.proyecto.application.dto.HistoriaClinicaDTO;
import com.clinica.proyecto.application.mapper.HistoriaClinicaMapper;
import com.clinica.proyecto.application.repository.IHistoriaClinicaRepository;
import com.clinica.proyecto.infraestructure.modelo.HistoriaClinica;
import com.clinica.proyecto.infraestructure.repository.jpa.HistoriaClinicaJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class HistoriaClinicaRepository implements IHistoriaClinicaRepository {
    @Autowired
    private HistoriaClinicaJpaRepository historiaClinicaJpaRepository;
    @Autowired
    private HistoriaClinicaMapper historiaClinicaMapper;

    @Override
    public List<HistoriaClinica> findAll() { return historiaClinicaJpaRepository.findAll(); }
    @Override
    public Optional<HistoriaClinica> findById(Long id) { return historiaClinicaJpaRepository.findById(id); }
    @Override
    public HistoriaClinica save(HistoriaClinica historiaClinica) { return historiaClinicaJpaRepository.save(historiaClinica); }
    @Override
    public Optional<HistoriaClinica> findByPacienteId(Long pacienteId) { return historiaClinicaJpaRepository.findByPaciente_Id(pacienteId); }

    @Override
    public List<HistoriaClinicaDTO> findAllDTO() { return findAll().stream().map(historiaClinicaMapper::toDTO).toList(); }
    @Override
    public Optional<HistoriaClinicaDTO> findByIdDTO(Long id) { return findById(id).map(historiaClinicaMapper::toDTO); }
    @Override
    public HistoriaClinicaDTO saveDTO(HistoriaClinicaDTO historiaClinicaDTO) { return historiaClinicaMapper.toDTO(save(historiaClinicaMapper.toEntity(historiaClinicaDTO))); }
    @Override
    public Optional<HistoriaClinicaDTO> findByPacienteIdDTO(Long pacienteId) { return findByPacienteId(pacienteId).map(historiaClinicaMapper::toDTO); }
}

