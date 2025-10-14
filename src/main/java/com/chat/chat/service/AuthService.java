package com.chat.chat.service;

import com.chat.chat.model.Psicologo;
import com.chat.chat.model.Supervisor;
import com.chat.chat.repository.PsicologoRepository;
import com.chat.chat.repository.SupervisorRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AuthService {

    private final PsicologoRepository psicRepo;
    private final SupervisorRepository supRepo;

    public AuthService(PsicologoRepository psicRepo, SupervisorRepository supRepo) {
        this.psicRepo = psicRepo;
        this.supRepo = supRepo;
    }

    public Optional<Psicologo> autenticarPsicologo(String email, String senha) {
        return psicRepo.findByEmail(email)
                .filter(p -> p.getSenha().equals(senha));
    }

    public Optional<Supervisor> autenticarSupervisor(String email, String senha) {
        return supRepo.findByEmail(email)
                .filter(s -> s.getSenha().equals(senha));
    }
}
