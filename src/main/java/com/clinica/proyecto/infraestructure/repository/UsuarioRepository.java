package com.clinica.proyecto.infraestructure.repository;

import com.clinica.proyecto.application.dto.UsuarioDTO;
import com.clinica.proyecto.application.mapper.UsuarioMapper;
import com.clinica.proyecto.application.repository.IUsuarioRepository;
import com.clinica.proyecto.infraestructure.modelo.Usuario;
import com.clinica.proyecto.infraestructure.repository.jpa.UsuarioJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository implements IUsuarioRepository {
    @Autowired
    private UsuarioJpaRepository usuarioJpaRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public List<Usuario> findAll() { return usuarioJpaRepository.findAll(); }

    @Override
    public Optional<Usuario> findById(Long id) { return usuarioJpaRepository.findById(id); }

    @Override
    public Optional<Usuario> findByUsername(String username) { return usuarioJpaRepository.findByUsername(username); }

    @Override
    public Usuario save(Usuario usuario) { return usuarioJpaRepository.save(usuario); }

    @Override
    public List<UsuarioDTO> findAllDTO() { return findAll().stream().map(usuarioMapper::toDTO).toList(); }

    @Override
    public Optional<UsuarioDTO> findByIdDTO(Long id) { return findById(id).map(usuarioMapper::toDTO); }

    @Override
    public Optional<UsuarioDTO> findByUsernameDTO(String username) { return findByUsername(username).map(usuarioMapper::toDTO); }

    @Override
    public UsuarioDTO saveDTO(UsuarioDTO usuarioDTO) { return usuarioMapper.toDTO(save(usuarioMapper.toEntity(usuarioDTO))); }
}

