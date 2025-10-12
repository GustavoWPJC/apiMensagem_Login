package com.chat.chat.controller;

import com.chat.chat.model.Mensagem;
import com.chat.chat.model.Conversa;
import com.chat.chat.repository.MensagemRepository;
import com.chat.chat.repository.ConversaRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/mensagens")
public class MensagemController {

    private final MensagemRepository repo;
    private final ConversaRepository conversaRepo;

    public MensagemController(MensagemRepository repo, ConversaRepository conversaRepo) {
        this.repo = repo;
        this.conversaRepo = conversaRepo;
    }

    // Envia uma mensagem dentro de uma conversa existente (forneça conversaId)
    @PostMapping
    public Mensagem enviar(@RequestBody Mensagem m) {
        m.setDataEnvio(LocalDateTime.now());
        // garante que conversa existe
        Conversa c = conversaRepo.findById(m.getConversa().getId())
                .orElseThrow(() -> new RuntimeException("Conversa não encontrada"));
        m.setConversa(c);
        return repo.save(m);
    }

    // Listar mensagens por conversa
    @GetMapping("/conversa/{conversaId}")
    public List<Mensagem> listarPorConversa(@PathVariable Integer conversaId) {
        return repo.findByConversaIdOrderByDataEnvioAsc(conversaId);
    }
}
