package de.htw.berlin.MensaTalk.MensaTalkBackend.ChatMessage;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import de.htw.berlin.MensaTalk.MensaTalkBackend.ChatRoom.ChatRoom;
import de.htw.berlin.jwt.model.DAOUser;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    private DAOUser author;

    //Inhalte
    @Column(nullable = false)
    private String textMessage;

    //TimeStamp
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date created_at;

    public ChatMessage() {
    }

    public ChatMessage(ChatRoom chatRoom, String textMessage, Date created_at, DAOUser author) {
        this.chatRoom = chatRoom;
        this.textMessage = textMessage;
        this.created_at = created_at;
        this.author = author;
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
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public DAOUser getAuthor() {
        return author;
    }

    public void setAuthor(DAOUser author) {
        this.author = author;
    }
}
