package com.chat.chat.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Solicitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long psicologoId;
    private Long supervisorId;

    private String mensagem; // mensagem opcional do psicólogo
    private String status;   // "PENDENTE", "ACEITA", "RECUSADA"

    private LocalDateTime dataSolicitacao;

    public Solicitacao() {
        this.status = "PENDENTE";
        this.dataSolicitacao = LocalDateTime.now();
    }

    public Solicitacao(Long psicologoId, Long supervisorId, String mensagem) {
        this.psicologoId = psicologoId;
        this.supervisorId = supervisorId;
        this.mensagem = mensagem;
        this.status = "PENDENTE";
        this.dataSolicitacao = LocalDateTime.now();
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public Long getPsicologoId() {
        return psicologoId;
    }

    public void setPsicologoId(Long psicologoId) {
        this.psicologoId = psicologoId;
    }

    public Long getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Long supervisorId) {
        this.supervisorId = supervisorId;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDateTime dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }
}