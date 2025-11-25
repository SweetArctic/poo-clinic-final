package com.clinica.proyecto.application.service;

import com.clinica.proyecto.application.dto.HistoriaClinicaDTO;
import com.clinica.proyecto.application.mapper.HistoriaClinicaMapper;
import com.clinica.proyecto.application.repository.IHistoriaClinicaRepository;
import com.clinica.proyecto.infraestructure.modelo.HistoriaClinica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HistoriaClinicaService {
    @Autowired
    private IHistoriaClinicaRepository historiaClinicaRepository;

    @Autowired
    private HistoriaClinicaMapper historiaClinicaMapper;

    public Optional<HistoriaClinicaDTO> buscarPorPaciente(Long pacienteId) {
        return historiaClinicaRepository.findByPacienteIdDTO(pacienteId);
    }

    public HistoriaClinica crearParaPaciente(Long pacienteId) {
        HistoriaClinica hc = new HistoriaClinica();
        hc.getPaciente().setId(pacienteId);
        return historiaClinicaRepository.save(hc);
    }
}

