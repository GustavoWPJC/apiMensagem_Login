package com.chat.chat.controller;

import com.chat.chat.model.Psicologo;
import com.chat.chat.repository.PsicologoRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/psicologos")
public class PsicologoController {

    private final PsicologoRepository repo;
    public PsicologoController(PsicologoRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Psicologo> listar() { return repo.findAll(); }

    @GetMapping("/{id}")
    public Optional<Psicologo> porId(@PathVariable Integer id) { return repo.findById(id); }

    @PostMapping
    public Psicologo criar(@RequestBody Psicologo p) { return repo.save(p); }

    @PutMapping("/{id}")
    public Psicologo atualizar(@PathVariable Integer id, @RequestBody Psicologo p) {
        p.setId(id);
        return repo.save(p);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) { repo.deleteById(id); }
}
