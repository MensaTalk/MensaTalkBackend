package de.htw.berlin.MensaTalk.MensaTalkBackend.ChatRoom;

import de.htw.berlin.MensaTalk.MensaTalkBackend.ChatMessage.ChatMessage;
import de.htw.berlin.MensaTalk.MensaTalkBackend.ChatUser.ChatUser;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "chat_room")
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(nullable = true)
    @OneToMany(mappedBy = "chatRoom")
    private Set<ChatMessage> chatMessages;

    @Column(nullable = true)
    @OneToMany(mappedBy = "chatRoom")
    private Set<ChatUser> chatUsers;

    public ChatRoom() {
    }

    public ChatRoom(long id, String name, Set<ChatMessage> chatMessages, Set<ChatUser> chatUsers) {
        this.id = id;
        this.name = name;
        this.chatMessages = chatMessages;
        this.chatUsers = chatUsers;
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

    public Set<ChatMessage> getChatMessages() {
        return chatMessages;
    }

    public void setChatMessages(Set<ChatMessage> chatMessages) {
        this.chatMessages = chatMessages;
    }

    public Set<ChatUser> getChatUsers() {
        return chatUsers;
    }

    public void setChatUsers(Set<ChatUser> chatUsers) {
        this.chatUsers = chatUsers;
    }
}
