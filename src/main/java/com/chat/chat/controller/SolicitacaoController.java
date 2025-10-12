package com.chat.chat.controller;

import com.chat.chat.model.Solicitacao;
import com.chat.chat.model.Psicologo;
import com.chat.chat.model.Supervisor;
import com.chat.chat.repository.SolicitacaoRepository;
import com.chat.chat.repository.PsicologoRepository;
import com.chat.chat.repository.SupervisorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitacoes")
public class SolicitacaoController {

    private final SolicitacaoRepository repo;
    private final PsicologoRepository psicRepo;
    private final SupervisorRepository supRepo;

    public SolicitacaoController(SolicitacaoRepository repo, PsicologoRepository psicRepo, SupervisorRepository supRepo) {
        this.repo = repo;
        this.psicRepo = psicRepo;
        this.supRepo = supRepo;
    }

    @PostMapping
    public Solicitacao criar(@RequestBody Solicitacao s) {
        // espera que corpo contenha psicologo.id e supervisor.id
        Psicologo p = psicRepo.findById(s.getPsicologo().getId()).orElseThrow(() -> new RuntimeException("Psicologo não encontrado"));
        Supervisor sup = supRepo.findById(s.getSupervisor().getId()).orElseThrow(() -> new RuntimeException("Supervisor não encontrado"));
        s.setPsicologo(p);
        s.setSupervisor(sup);
        return repo.save(s);
    }

    @GetMapping("/supervisor/{id}")
    public List<Solicitacao> recebidas(@PathVariable Integer id) {
        return repo.findBySupervisorId(id);
    }

    @GetMapping("/psicologo/{id}")
    public List<Solicitacao> feitas(@PathVariable Integer id) {
        return repo.findByPsicologoId(id);
    }

    @PostMapping("/{id}/aceitar")
    public Solicitacao aceitar(@PathVariable Long id) {
        Solicitacao s = repo.findById(id).orElseThrow(() -> new RuntimeException("Solicitação não encontrada"));
        s.setStatus("aceita");
        return repo.save(s);
    }

    @PostMapping("/{id}/recusar")
    public Solicitacao recusar(@PathVariable Long id) {
        Solicitacao s = repo.findById(id).orElseThrow(() -> new RuntimeException("Solicitação não encontrada"));
        s.setStatus("recusada");
        return repo.save(s);
    }
}
