package de.htw.berlin.MensaTalk.MensaTalkBackend.ChatRoom;

import de.htw.berlin.MensaTalk.MensaTalkBackend.ChatMessage.ChatMessage;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "chat_room")
public class ChatRoom implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="chat_room_id")
    private long id;

    @Column(nullable = false)
    private String name;


    public ChatRoom() {
    }

    public ChatRoom(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
