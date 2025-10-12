package com.chat.chat.controller;

import com.chat.chat.model.Consulta;
import com.chat.chat.repository.ConsultaRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaRepository repo;
    public ConsultaController(ConsultaRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Consulta> listar() { return repo.findAll(); }

    @PostMapping
    public Consulta criar(@RequestBody Consulta c) { return repo.save(c); }
}
