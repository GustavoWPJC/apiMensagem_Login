package com.chat.chat.controller;

import com.chat.chat.model.Usuario;
import com.chat.chat.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000") // <-- aqui libera pro front local
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Cadastro de novo usuário (psicólogo, supervisor, etc.)
    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Login: verifica e retorna o usuário se email e senha estiverem corretos
    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario dados) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(dados.getEmail());
        if (usuario.isPresent() && usuario.get().getSenha().equals(dados.getSenha())) {
            return usuario.get();
        }
        throw new RuntimeException("Email ou senha inválidos");
    }

    // Listar todos os usuários por tipo (ex: psicologo, supervisor, usuario)
    @GetMapping("/tipo/{tipo}")
    public List<Usuario> listarPorTipo(@PathVariable String tipo) {
        return usuarioRepository.findByTipo(tipo);
    }
}