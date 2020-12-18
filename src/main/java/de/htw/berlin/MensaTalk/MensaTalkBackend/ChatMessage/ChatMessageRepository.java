package de.htw.berlin.MensaTalk.MensaTalkBackend.ChatMessage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findAllByChatRoomId(Long roomId);
    List<ChatMessage> findAllByChatRoomIdAndCreationDateTimeAfter(Long roomId, Date timeFilter);
}
