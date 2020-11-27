package de.htw.berlin.MensaTalk.MensaTalkBackend.ChatMessage;

import de.htw.berlin.MensaTalk.MensaTalkBackend.ChatRoom.ChatRoom;
import de.htw.berlin.MensaTalk.MensaTalkBackend.User.ChatUser;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "chat_message")
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "chat_room_id", nullable = false)
    private ChatRoom chatRoom;

    //Inhalte
    private String chatMessage;

    //User
    @JoinColumn(name = "chat_user_id", nullable = false)
    private ChatUser chatUser;

    //TimeStamp
    @Temporal(TemporalType.DATE)
    private Date publicationDate;

    @Temporal(TemporalType.TIME)
    private Date publicationTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDateTime;

    public ChatMessage() {
    }

    public ChatMessage(long id, ChatRoom chatRoom, String chatMessage, ChatUser chatUser, Date publicationDate, Date publicationTime, Date creationDateTime) {
        this.id = id;
        this.chatRoom = chatRoom;
        this.chatMessage = chatMessage;
        this.chatUser = chatUser;
        this.publicationDate = publicationDate;
        this.publicationTime = publicationTime;
        this.creationDateTime = creationDateTime;
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

    public String getChatMessage() {
        return chatMessage;
    }

    public void setChatMessage(String chatMessage) {
        this.chatMessage = chatMessage;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Date getPublicationTime() {
        return publicationTime;
    }

    public void setPublicationTime(Date publicationTime) {
        this.publicationTime = publicationTime;
    }

    public Date getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(Date creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public de.htw.berlin.MensaTalk.MensaTalkBackend.User.ChatUser getChatUser() {
        return chatUser;
    }

    public void setChatUser(de.htw.berlin.MensaTalk.MensaTalkBackend.User.ChatUser chatUser) {
        this.chatUser = chatUser;
    }
}
