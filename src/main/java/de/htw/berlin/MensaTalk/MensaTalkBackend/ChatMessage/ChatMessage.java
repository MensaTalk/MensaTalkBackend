package de.htw.berlin.MensaTalk.MensaTalkBackend.ChatMessage;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import de.htw.berlin.MensaTalk.MensaTalkBackend.ChatRoom.ChatRoom;
import de.htw.berlin.MensaTalk.MensaTalkBackend.User.model.User;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "chat_message")
public class ChatMessage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="chat_message_id")
    private long id;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "chat_room_id", nullable = false)
    private ChatRoom chatRoom;

    @ManyToOne
    @JoinColumn(name= "app_user_id", nullable = false)
    @JsonManagedReference
    private User author;

    //Inhalte
    @Column(nullable = false)
    private String textMessage;

    //TimeStamp
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDateTime;


    public ChatMessage() {
    }

    public ChatMessage(ChatRoom chatRoom, String textMessage, Date created_at, User author) {
        this.chatRoom = chatRoom;
        this.textMessage = textMessage;
        this.creationDateTime = created_at;
        this.author = author;
    }

    public ChatMessageDTO createDTO(){
        return new ChatMessageDTO(chatRoom.getId() ,author.getUsername(),textMessage, creationDateTime);
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

    public Date getCreated_at() {
        return creationDateTime;
    }

    public void setCreated_at(Date created_at) {
        this.creationDateTime = created_at;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }


}
