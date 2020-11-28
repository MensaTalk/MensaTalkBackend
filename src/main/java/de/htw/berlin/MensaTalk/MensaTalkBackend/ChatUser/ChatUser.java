package de.htw.berlin.MensaTalk.MensaTalkBackend.ChatUser;

import de.htw.berlin.MensaTalk.MensaTalkBackend.ChatMessage.ChatMessage;
import de.htw.berlin.MensaTalk.MensaTalkBackend.ChatRoom.ChatRoom;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "chat_user")
public class ChatUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name="chat_room_id", nullable=true)
    private ChatRoom chatRoom;

    @OneToMany(mappedBy = "chatUser")
    @Column(nullable = true)
    private Set<ChatMessage> chatMessages;

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
