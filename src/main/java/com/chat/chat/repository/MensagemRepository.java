package com.chat.chat.repository;

import com.chat.chat.model.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {

    @Query("SELECT m FROM Mensagem m WHERE " +
            "(m.remetenteId = :remetenteId1 AND m.destinatarioId = :destinatarioId1) OR " +
            "(m.remetenteId = :remetenteId2 AND m.destinatarioId = :destinatarioId2) " +
            "ORDER BY m.dataEnvio ASC")
    List<Mensagem> findMensagensEntreUsuarios(
            @Param("remetenteId1") Long remetenteId1,
            @Param("destinatarioId1") Long destinatarioId1,
            @Param("remetenteId2") Long remetenteId2,
            @Param("destinatarioId2") Long destinatarioId2
    );

    List<Mensagem> findByRemetenteIdOrDestinatarioIdOrderByDataEnvioAsc(Long remetenteId, Long destinatarioId);
}