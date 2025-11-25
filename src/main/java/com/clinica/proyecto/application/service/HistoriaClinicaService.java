package com.clinica.proyecto.application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.proyecto.application.dto.HistoriaClinicaDTO;
import com.clinica.proyecto.application.mapper.HistoriaClinicaMapper;
import com.clinica.proyecto.application.repository.IHistoriaClinicaRepository;
import com.clinica.proyecto.infraestructure.modelo.HistoriaClinica;
import com.clinica.proyecto.infraestructure.modelo.Paciente;

@Service
public class HistoriaClinicaService {
    @Autowired
    private IHistoriaClinicaRepository historiaClinicaRepository;

    @Autowired
    private HistoriaClinicaMapper historiaClinicaMapper;

    public Optional<HistoriaClinicaDTO> buscarPorPaciente(Long pacienteId) {
        return historiaClinicaRepository.findByPacienteId(pacienteId)
                .map(historiaClinicaMapper::toDTO);
    }

    public HistoriaClinica crearParaPaciente(Long pacienteId) {
        HistoriaClinica hc = new HistoriaClinica();
        Paciente p = new Paciente();
        p.setId(pacienteId);
        hc.setPaciente(p);
        return historiaClinicaRepository.save(hc);
    }
}
