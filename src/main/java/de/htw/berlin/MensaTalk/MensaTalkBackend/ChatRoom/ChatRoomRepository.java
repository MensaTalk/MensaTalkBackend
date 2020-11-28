package de.htw.berlin.MensaTalk.MensaTalkBackend.ChatRoom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel  = "chatRoom", path = "chatRoom")
public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
}
