package de.htw.berlin.MensaTalk.MensaTalkBackend.ChatUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatUserRepository extends JpaRepository<ChatUser, Long> {
}
