package de.htw.berlin.MensaTalk.MensaTalkBackend.ChatMessage;

import de.htw.berlin.MensaTalk.MensaTalkBackend.ChatRoom.ChatRoom;
import de.htw.berlin.MensaTalk.MensaTalkBackend.ChatUser.ChatUser;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "chat_message")
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @ManyToOne
    @JoinColumn(name = "chat_room_id", nullable = false)
    private ChatRoom chatRoom;

    //Inhalte
    @Column(nullable = false)
    private String textMessage;

    //User
    @ManyToOne
    @JoinColumn(name = "chat_user_id", nullable = false)
    private ChatUser chatUser;

    //TimeStamp
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date publicationDate;

    @Temporal(TemporalType.TIME)
    @Column(nullable = false)
    private Date publicationTime;

    public ChatMessage() {
    }

    public ChatMessage(long id, ChatRoom chatRoom, String textMessage, ChatUser chatUser, Date publicationDate, Date publicationTime) {
        this.id = id;
        this.chatRoom = chatRoom;
        this.textMessage = textMessage;
        this.chatUser = chatUser;
        this.publicationDate = publicationDate;
        this.publicationTime = publicationTime;

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

    public de.htw.berlin.MensaTalk.MensaTalkBackend.ChatUser.ChatUser getChatUser() {
        return chatUser;
    }

    public void setChatUser(de.htw.berlin.MensaTalk.MensaTalkBackend.ChatUser.ChatUser chatUser) {
        this.chatUser = chatUser;
    }
}
