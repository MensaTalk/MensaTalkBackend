package de.htw.berlin.MensaTalk.MensaTalkBackend.ChatUser;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel  = "chatUser", path = "chatUser")
public interface ChatUserRepository extends CrudRepository<ChatUser, Long> {
}
