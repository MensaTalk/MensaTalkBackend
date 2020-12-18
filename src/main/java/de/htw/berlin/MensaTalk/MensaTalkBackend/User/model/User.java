package de.htw.berlin.MensaTalk.MensaTalkBackend.User.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import de.htw.berlin.MensaTalk.MensaTalkBackend.ChatMessage.ChatMessage;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "app_user_id")
    private long id;
    @Column(unique = true)
    private String username;
    @Column
    @JsonIgnore
    private String password;

    @OneToMany(
            mappedBy = "author",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonBackReference
    private List<ChatMessage> chatMessageList = new ArrayList<>();

    //**************************************************************
    // Profile
    //**************************************************************

    // Alter
    @Column
    private int age;

    // Interessen
    @Column
    private String interests;

    // StatusNachricht
    @Column
    private String status;

    // Profilbild


    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ChatMessage> getChatMessageList() {
        return chatMessageList;
    }

    public void setChatMessageList(List<ChatMessage> chatMessageList) {
        this.chatMessageList = chatMessageList;
    }

    public void addChatMessage(ChatMessage chatMessage) {
        this.chatMessageList.add(chatMessage);
    }

    public void addChatMessage(List<ChatMessage> chatMessageList) {
        this.chatMessageList.addAll(chatMessageList);
    }
}