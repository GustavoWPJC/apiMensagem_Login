package com.chat.chat.repository;

import com.chat.chat.model.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SupervisorRepository extends JpaRepository<Supervisor, Integer> {
    Optional<Supervisor> findByEmail(String email);
}
