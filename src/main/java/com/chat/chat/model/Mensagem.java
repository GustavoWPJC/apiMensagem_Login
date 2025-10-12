package com.chat.chat.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Mensagem")
public class Mensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_conversa", referencedColumnName = "id_conversa", nullable = false)
    private Conversa conversa;

    @Column(name = "id_remetente_tipo")
    @Enumerated(EnumType.STRING)
    private RemetenteTipo remetenteTipo;

    // mantemos id_remetente para referência simples (id da tabela Psicologo ou Supervisor)
    @Column(name = "id_remetente")
    private Integer remetenteId;

    @Column(name = "conteudo", columnDefinition = "TEXT")
    private String conteudo;

    @Column(name = "data_envio")
    private LocalDateTime dataEnvio;

    public Mensagem() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Conversa getConversa() { return conversa; }
    public void setConversa(Conversa conversa) { this.conversa = conversa; }

    public RemetenteTipo getRemetenteTipo() { return remetenteTipo; }
    public void setRemetenteTipo(RemetenteTipo remetenteTipo) { this.remetenteTipo = remetenteTipo; }

    public Integer getRemetenteId() { return remetenteId; }
    public void setRemetenteId(Integer remetenteId) { this.remetenteId = remetenteId; }

    public String getConteudo() { return conteudo; }
    public void setConteudo(String conteudo) { this.conteudo = conteudo; }

    public LocalDateTime getDataEnvio() { return dataEnvio; }
    public void setDataEnvio(LocalDateTime dataEnvio) { this.dataEnvio = dataEnvio; }

    public enum RemetenteTipo {
        psicologo,
        supervisor
    }
}
