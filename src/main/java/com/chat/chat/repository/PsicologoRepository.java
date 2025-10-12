package com.chat.chat.repository;

import com.chat.chat.model.Psicologo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PsicologoRepository extends JpaRepository<Psicologo, Integer> {
    Optional<Psicologo> findByEmail(String email);
}
