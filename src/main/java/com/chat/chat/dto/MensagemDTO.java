package com.chat.chat.dto;

public class MensagemDTO {
    private Integer remetenteId;
    private Integer destinatarioId;
    private String conteudo;
    private String remetenteTipo; // "psicologo" | "supervisor"

    public Integer getRemetenteId() { return remetenteId; }
    public void setRemetenteId(Integer remetenteId) { this.remetenteId = remetenteId; }
    public Integer getDestinatarioId() { return destinatarioId; }
    public void setDestinatarioId(Integer destinatarioId) { this.destinatarioId = destinatarioId; }
    public String getConteudo() { return conteudo; }
    public void setConteudo(String conteudo) { this.conteudo = conteudo; }
    public String getRemetenteTipo() { return remetenteTipo; }
    public void setRemetenteTipo(String remetenteTipo) { this.remetenteTipo = remetenteTipo; }
}
