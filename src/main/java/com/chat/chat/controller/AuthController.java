package com.chat.chat.controller;

import com.chat.chat.dto.LoginDTO;
import com.chat.chat.dto.LoginResponseDTO;
import com.chat.chat.model.Psicologo;
import com.chat.chat.model.Supervisor;
import com.chat.chat.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginDTO dto) {
        return authService.autenticarPsicologo(dto.getEmail(), dto.getSenha())
                .map(p -> ResponseEntity.ok(new LoginResponseDTO(p.getId(), p.getNome(), "psicologo")))
                .or(() -> authService.autenticarSupervisor(dto.getEmail(), dto.getSenha())
                        .map(s -> ResponseEntity.ok(new LoginResponseDTO(s.getId(), s.getNome(), "supervisor"))))
                .orElseGet(() -> ResponseEntity.status(401)
                        .body(new LoginResponseDTO(null, null, "erro")));
    }




}
