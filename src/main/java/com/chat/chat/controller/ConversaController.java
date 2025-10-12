package com.chat.chat.controller;

import com.chat.chat.model.Conversa;
import com.chat.chat.model.Psicologo;
import com.chat.chat.model.Supervisor;
import com.chat.chat.repository.ConversaRepository;
import com.chat.chat.repository.PsicologoRepository;
import com.chat.chat.repository.SupervisorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/conversas")
public class ConversaController {

    private final ConversaRepository conversaRepo;
    private final PsicologoRepository psicRepo;
    private final SupervisorRepository supRepo;

    public ConversaController(ConversaRepository conversaRepo, PsicologoRepository psicRepo, SupervisorRepository supRepo) {
        this.conversaRepo = conversaRepo;
        this.psicRepo = psicRepo;
        this.supRepo = supRepo;
    }

    // cria ou retorna conversa existente entre psicologo e supervisor
    @PostMapping("/between")
    public Conversa criarOuRetornar(@RequestParam Integer psicologoId, @RequestParam Integer supervisorId) {
        Optional<Conversa> existing = conversaRepo.findByPsicologoIdAndSupervisorId(psicologoId, supervisorId);
        if (existing.isPresent()) return existing.get();

        Psicologo p = psicRepo.findById(psicologoId).orElseThrow(() -> new RuntimeException("Psicologo não encontrado"));
        Supervisor s = supRepo.findById(supervisorId).orElseThrow(() -> new RuntimeException("Supervisor não encontrado"));

        Conversa c = new Conversa();
        c.setPsicologo(p);
        c.setSupervisor(s);
        return conversaRepo.save(c);
    }
}
