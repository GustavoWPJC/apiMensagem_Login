package com.chat.chat.controller;

import com.chat.chat.model.Supervisor;
import com.chat.chat.repository.SupervisorRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/supervisores")
public class SupervisorController {

    private final SupervisorRepository repo;
    public SupervisorController(SupervisorRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Supervisor> listar() { return repo.findAll(); }

    @GetMapping("/{id}")
    public Optional<Supervisor> porId(@PathVariable Integer id) { return repo.findById(id); }

    @PostMapping
    public Supervisor criar(@RequestBody Supervisor s) { return repo.save(s); }

    @PutMapping("/{id}")
    public Supervisor atualizar(@PathVariable Integer id, @RequestBody Supervisor s) {
        s.setId(id);
        return repo.save(s);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) { repo.deleteById(id); }
}
