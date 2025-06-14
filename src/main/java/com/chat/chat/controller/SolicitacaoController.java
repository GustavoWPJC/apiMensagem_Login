package com.chat.chat.controller;

import com.chat.chat.model.Solicitacao;
import com.chat.chat.repository.SolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/solicitacoes")
public class SolicitacaoController {

    @Autowired
    private SolicitacaoRepository repository;

    // Enviar uma solicitação
    @PostMapping
    public Solicitacao enviar(@RequestBody Solicitacao solicitacao) {
        return repository.save(solicitacao);
    }

    // Listar solicitações recebidas por um supervisor
    @GetMapping("/supervisor/{id}")
    public List<Solicitacao> recebidas(@PathVariable Long id) {
        return repository.findBySupervisorId(id);
    }

    // Listar solicitações feitas por um psicólogo
    @GetMapping("/psicologo/{id}")
    public List<Solicitacao> feitas(@PathVariable Long id) {
        return repository.findByPsicologoId(id);
    }

    // Aceitar uma solicitação
    @PostMapping("/{id}/aceitar")
    public Solicitacao aceitar(@PathVariable Long id) {
        Optional<Solicitacao> solicitacao = repository.findById(id);
        if (solicitacao.isPresent()) {
            Solicitacao s = solicitacao.get();
            s.setStatus("ACEITA");
            return repository.save(s);
        }
        throw new RuntimeException("Solicitação não encontrada");
    }

    // Recusar uma solicitação
    @PostMapping("/{id}/recusar")
    public Solicitacao recusar(@PathVariable Long id) {
        Optional<Solicitacao> solicitacao = repository.findById(id);
        if (solicitacao.isPresent()) {
            Solicitacao s = solicitacao.get();
            s.setStatus("RECUSADA");
            return repository.save(s);
        }
        throw new RuntimeException("Solicitação não encontrada");
    }
}