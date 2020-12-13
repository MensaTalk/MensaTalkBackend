package de.htw.berlin.MensaTalk.MensaTalkBackend.ChatMessage;

import de.htw.berlin.jwt.model.DAOUser;

import java.util.Date;

public class ChatMessageDTO {


    private Long chatRoomId;

    private String authorName;

    private String textMessage;

    private Date created_at;

    public ChatMessageDTO(Long chatRoomId, String authorName, String textMessage, Date created_at) {
        this.chatRoomId = chatRoomId;
        this.authorName = authorName;
        this.textMessage = textMessage;
        this.created_at = created_at;
    }

    public ChatMessageDTO() {

    }

    public Long getChatRoomId() {
        return chatRoomId;
    }

    public void setChatRoomId(Long chatRoomId) {
        this.chatRoomId = chatRoomId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
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
}
