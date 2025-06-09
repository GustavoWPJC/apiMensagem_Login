package com.chat.chat.controller;


import com.chat.chat.model.Usuario;
import com.chat.chat.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //  Cadastro
    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    // login, que retorna o usuário caso a senha esteja correta
    @PostMapping("/login")
    public  Usuario login(@RequestBody Usuario dados){
        Optional<Usuario> usuario = usuarioRepository.findByEmail(dados.getEmail());
        if (usuario.isPresent() && usuario.get().getSenha().equals(dados.getSenha())){
            return usuario.get();
        }
        throw new RuntimeException("Email ou senha inválidos");
    }
}
