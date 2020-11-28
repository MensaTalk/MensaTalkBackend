package de.htw.berlin.MensaTalk.MensaTalkBackend.ChatMessage;

import de.htw.berlin.MensaTalk.MensaTalkBackend.ChatRoom.ChatRoom;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "chat_message")
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="chat_message_id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "chat_room_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ChatRoom chatRoom;

    //Inhalte
    @Column(nullable = false)
    private String textMessage;

    //TimeStamp
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date created_at;

    public ChatMessage() {
    }

    public ChatMessage(long id, ChatRoom chatRoom, String textMessage) {
        this.id = id;
        this.chatRoom = chatRoom;
        this.textMessage = textMessage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ChatRoom getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }


}
