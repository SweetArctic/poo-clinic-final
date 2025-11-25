package com.clinica.proyecto.application.repository;

import com.clinica.proyecto.application.dto.UsuarioDTO;
import com.clinica.proyecto.infraestructure.modelo.Usuario;
import java.util.List;
import java.util.Optional;

public interface IUsuarioRepository {
    List<Usuario> findAll();
    Optional<Usuario> findById(Long id);
    Optional<Usuario> findByUsername(String username);
    Usuario save(Usuario usuario);

    List<UsuarioDTO> findAllDTO();
    Optional<UsuarioDTO> findByIdDTO(Long id);
    Optional<UsuarioDTO> findByUsernameDTO(String username);
    UsuarioDTO saveDTO(UsuarioDTO usuarioDTO);
}

