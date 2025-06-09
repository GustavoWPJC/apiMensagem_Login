package com.chat.chat.repository;

import com.chat.chat.model.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {

    // Lista todas as mensagens de um usuário (como remetente OU destinatário), ordenadas por data
    List<Mensagem> findByRemetenteIdOrDestinatarioIdOrderByDataEnvioAsc(Long remetenteId, Long destinatarioId);

    // Lista apenas as mensagens trocadas entre dois usuários, ordenadas por data
    List<Mensagem> findByRemetenteIdAndDestinatarioIdOrRemetenteIdAndDestinatarioIdOrderByDataEnvioAsc(
            Long remetenteId1, Long destinatarioId1,
            Long remetenteId2, Long destinatarioId2
    );
}