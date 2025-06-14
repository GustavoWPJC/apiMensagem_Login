package com.chat.chat.repository;

import com.chat.chat.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    // Buscar todos os usuários por tipo (ex: "psicologo", "usuario", "supervisor")
    List<Usuario> findByTipo(String tipo);
}