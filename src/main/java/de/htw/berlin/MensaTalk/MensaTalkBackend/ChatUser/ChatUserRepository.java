package de.htw.berlin.MensaTalk.MensaTalkBackend.ChatUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface ChatUserRepository extends JpaRepository<ChatUser, Long> {
}
