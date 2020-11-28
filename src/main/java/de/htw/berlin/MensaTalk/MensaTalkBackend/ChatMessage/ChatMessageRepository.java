package de.htw.berlin.MensaTalk.MensaTalkBackend.ChatMessage;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel  = "chatMessage", path = "chatMessage")
public interface ChatMessageRepository extends CrudRepository<ChatMessage, Long> {

}
