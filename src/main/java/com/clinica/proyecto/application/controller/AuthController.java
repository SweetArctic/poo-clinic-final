package com.clinica.proyecto.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.proyecto.application.dto.UsuarioDTO;
import com.clinica.proyecto.application.service.UsuarioService;
import com.clinica.proyecto.security.AuthTokenService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private AuthTokenService authTokenService;

    @PostMapping("/registro")
    public ResponseEntity<UsuarioDTO> registrar(@RequestBody UsuarioDTO body) {
        UsuarioDTO creado = usuarioService.registrar(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/password")
    public ResponseEntity<Void> actualizarPassword(@RequestParam String username, @RequestParam String nuevaPassword) {
        boolean ok = usuarioService.actualizarPassword(username, nuevaPassword);
        if (ok) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UsuarioDTO body) {
        try {
            boolean ok = usuarioService.validarCredenciales(body.getUsername(), body.getPassword());
            if (!ok) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            String token = authTokenService.createToken(body.getUsername());
            return ResponseEntity.ok(java.util.Map.of("token", token));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
