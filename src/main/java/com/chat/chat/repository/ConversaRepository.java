package com.chat.chat.repository;

import com.chat.chat.model.Conversa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ConversaRepository extends JpaRepository<Conversa, Integer> {
    Optional<Conversa> findByPsicologoIdAndSupervisorId(Integer psicologoId, Integer supervisorId);
}
