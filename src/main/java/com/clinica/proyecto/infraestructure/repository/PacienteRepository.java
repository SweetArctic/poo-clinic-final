package com.clinica.proyecto.infraestructure.repository;

import com.clinica.proyecto.application.dto.PacienteDTO;
import com.clinica.proyecto.application.mapper.PacienteMapper;
import com.clinica.proyecto.application.repository.IPacienteRepository;
import com.clinica.proyecto.infraestructure.modelo.Paciente;
import com.clinica.proyecto.infraestructure.repository.jpa.PacienteJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PacienteRepository implements IPacienteRepository {
    @Autowired
    private PacienteJpaRepository pacienteJpaRepository;
    @Autowired
    private PacienteMapper pacienteMapper;

    @Override
    public List<Paciente> findAll() { return pacienteJpaRepository.findAll(); }
    @Override
    public Optional<Paciente> findById(Long id) { return pacienteJpaRepository.findById(id); }
    @Override
    public Paciente save(Paciente paciente) { return pacienteJpaRepository.save(paciente); }
    @Override
    public void deleteById(Long id) { pacienteJpaRepository.deleteById(id); }

    @Override
    public List<PacienteDTO> findAllDTO() { return findAll().stream().map(pacienteMapper::toDTO).toList(); }
    @Override
    public Optional<PacienteDTO> findByIdDTO(Long id) { return findById(id).map(pacienteMapper::toDTO); }
    @Override
    public PacienteDTO saveDTO(PacienteDTO pacienteDTO) { return pacienteMapper.toDTO(save(pacienteMapper.toEntity(pacienteDTO))); }
    @Override
    public void deleteByIdDTO(Long id) { deleteById(id); }
}

