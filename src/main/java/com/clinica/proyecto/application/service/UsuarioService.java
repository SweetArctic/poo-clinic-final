package com.clinica.proyecto.application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.clinica.proyecto.application.dto.UsuarioDTO;
import com.clinica.proyecto.application.mapper.UsuarioMapper;
import com.clinica.proyecto.application.repository.IUsuarioRepository;
import com.clinica.proyecto.infraestructure.modelo.Usuario;

@Service
public class UsuarioService {
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioDTO registrar(UsuarioDTO dto) {
        Usuario usuario = usuarioMapper.toEntity(dto);
        usuario.setPassword(passwordEncoder.encode(dto.getPassword()));
        Usuario u = usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(u);
    }

    public Optional<UsuarioDTO> buscarPorUsername(String username) {
        return usuarioRepository.findByUsername(username).map(usuarioMapper::toDTO);
    }

    public boolean actualizarPassword(String username, String nuevaPassword) {
        return usuarioRepository.findByUsername(username).map(u -> {
            u.setPassword(passwordEncoder.encode(nuevaPassword));
            usuarioRepository.save(u);
            return true;
        }).orElse(false);
    }

    public boolean validarCredenciales(String username, String password) {
        try {
            return usuarioRepository.findByUsername(username)
                    .map(u -> {
                        String encoded = u.getPassword();
                        if (encoded == null || password == null) return false;
                        return passwordEncoder.matches(password, encoded);
                    })
                    .orElse(false);
        } catch (Exception e) {
            return false;
        }
    }
}
