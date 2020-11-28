package de.htw.berlin.MensaTalk.MensaTalkBackend.ChatRoom;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import de.htw.berlin.MensaTalk.MensaTalkBackend.ChatMessage.ChatMessage;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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

    @OneToMany(
            mappedBy = "chatRoom",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    @JsonIgnore
    private List<ChatMessage> chatMessageList = new ArrayList<>();

    public ChatRoom() {

    }

    public ChatRoom(String name, List<ChatMessage> chatMessageList) {
        this.name = name;
        this.chatMessageList = chatMessageList;
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

    public List<ChatMessage> getChatMessageList() {
        return chatMessageList;
    }

    public void setChatMessageList(List<ChatMessage> chatMessageList) {
        this.chatMessageList = chatMessageList;
    }
}
