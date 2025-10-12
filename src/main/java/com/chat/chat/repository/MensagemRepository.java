package com.chat.chat.repository;

import com.chat.chat.model.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {

    // Buscar mensagens por conversa ordenadas
    List<Mensagem> findByConversaIdOrderByDataEnvioAsc(Integer conversaId);

    // Consulta customizada para compatibilidade com antigo endpoint (entre dois usuários):
    @Query("SELECT m FROM Mensagem m WHERE (m.remetenteId = ?1 AND m.conversa.supervisor.id = ?2) OR (m.remetenteId = ?2 AND m.conversa.supervisor.id = ?1) ORDER BY m.dataEnvio ASC")
    List<Mensagem> findMensagensEntreUsuarios(Long usuario1Id, Long usuario2Id);
}
