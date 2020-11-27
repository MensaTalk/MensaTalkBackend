package de.htw.berlin.MensaTalk.MensaTalkBackend.User;

import de.htw.berlin.MensaTalk.MensaTalkBackend.ChatRoom.ChatRoom;
import org.springframework.data.annotation.Id;

import javax.persistence.*;


@Entity
@Table(name = "chat_user")
public class ChatUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name="chat_room_id", nullable=false)
    private ChatRoom chatRoom;


    public ChatUser(){}
    public ChatUser(long id, String name, ChatRoom chatRoom) {
        this.id = id;
        this.name = name;
        this.chatRoom = chatRoom;
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

    public ChatRoom getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }
}
