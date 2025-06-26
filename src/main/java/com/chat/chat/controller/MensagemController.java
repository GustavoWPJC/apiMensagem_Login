package com.chat.chat.controller;

import com.chat.chat.model.Mensagem;
import com.chat.chat.repository.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "https://psiconecta.vercel.app/") // <-- aqui libera pro front local
@RestController
@RequestMapping("/mensagens")
public class MensagemController {

    @Autowired
    private MensagemRepository repository;

    // Enviar mensagem
    @PostMapping
    public Mensagem enviar(@RequestBody Mensagem mensagem) {
        mensagem.setDataEnvio(LocalDateTime.now());
        return repository.save(mensagem);
    }

    // Listar todas as mensagens de um usuário (remetente ou destinatário)
    @GetMapping("/usuario/{usuarioId}")
    public List<Mensagem> listarTodasDoUsuario(@PathVariable Long usuarioId) {
        return repository.findByRemetenteIdOrDestinatarioIdOrderByDataEnvioAsc(usuarioId, usuarioId);
    }

    @GetMapping("/{usuario1Id}/{usuario2Id}")
    public List<Mensagem> listarEntreUsuarios(@PathVariable Long usuario1Id, @PathVariable Long usuario2Id) {
        return repository.findMensagensEntreUsuarios(
                usuario1Id, usuario2Id,
                usuario2Id, usuario1Id
        );
    }
}